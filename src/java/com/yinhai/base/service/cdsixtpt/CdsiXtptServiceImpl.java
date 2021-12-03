package com.yinhai.base.service.cdsixtpt;

import com.yinhai.base.access.AccessAbstract;
import com.yinhai.base.cdsienum.AAA121;
import com.yinhai.base.domain.CdsiParamVO;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.domain.CdsiReturnVO;
import com.yinhai.base.exception.AppException;
import com.yinhai.base.util.ExceptionStrUtil;
import com.yinhai.bcpcs.BcpRequest;
import com.yinhai.bcpcs.BcpResponse;
import com.yinhai.bcpcs.DefaultBcpClient;
import com.yinhai.bcpcs.IBcpClient;
import com.yinhai.bcpcs.exceptions.ClientException;
import com.yinhai.bcpcs.exceptions.ServerException;
import com.yinhai.bcpcs.profile.DefaultProfile;
import com.yinhai.bcpcs.profile.IClientProfile;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class CdsiXtptServiceImpl implements CdsiXtptService {
    private static final Logger log = LoggerFactory.getLogger(CdsiXtptServiceImpl.class);

    public class XtptConnect {
        public XtptConnect(int maxTotal, int maxPerRoute) {
            DefaultBcpClient.setMaxTotal(maxTotal);
            DefaultBcpClient.setMaxPerRoute(maxPerRoute);
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000).
                    setConnectTimeout(5000).setSocketTimeout(5 * 60 * 1000).build();
            DefaultBcpClient.setRequestConfig(requestConfig);
        }

        /**
         * 获取协同平台客户端连接
         *
         * @param fwid    服务ID
         * @param request 调用请求参数
         * @return
         */
        public IBcpClient getXtptClient(IClientProfile fwid, BcpRequest request) {
            IBcpClient client = new DefaultBcpClient(fwid, request);
            return client;
        }
    }

    private XtptConnect xtptConnect;

    private String xtptUrl;

    private String systemID;

    private ConcurrentHashMap<String, IClientProfile> fws;

    public CdsiXtptServiceImpl(int maxTotal, int maxPerRoute, String xtptUrl, String systemID) {
        this.xtptConnect = new XtptConnect(maxTotal, maxPerRoute);
        this.xtptUrl = xtptUrl;
        this.systemID = systemID;
        fws = new ConcurrentHashMap<String, IClientProfile>();
    }

    @Override
    public CdsiReturnVO doBusiness(AAA121 aaa121, CdsiParamVO param, AccessAbstract user) {
        String fwid = aaa121.getFwid();
        BcpRequest request = new BcpRequest();
        request.setInput(param);
        IClientProfile fw = fws.get(fwid);
        if (fw == null) {
            fw = setFw(fwid);
        }
        IBcpClient client = xtptConnect.getXtptClient(fw, request);
        BcpResponse<CdsiReturnVO> respe = null;
        try {
            respe = client.getResponse(CdsiReturnVO.class);
        } catch (Exception e) {
            log.error("协同平台访问异常，异常内容：" + e.getLocalizedMessage());
            respe = new BcpResponse<CdsiReturnVO>();
            respe.setErrorMessage(e.getLocalizedMessage() == null ? "" :
                    e.getLocalizedMessage().replace("<", "").replace("]]>", "").replaceAll("!\\[CDATA\\[", ""));
            respe.setInvokeSuccess(false);
        }
        if (respe.isInvokeSuccess()) {
            CdsiReturnVO returnVO = respe.getInvokeData();
            /*if(returnVO.isSuccess()){
                //推送办件信息到好差评系统
                try {
                    sendToHcp(aaa121, param, returnVO, user);
                } catch (Exception e) {
                    log.error(returnVO.getAaz002() + ",推送办件信息至好差评失败：" + e.getMessage());
                }
            }*/
            return returnVO;
        } else {
            log.error(respe.getErrorMessage());
            CdsiReturnVO returnVO = new CdsiReturnVO();
            returnVO.setRecode("-1");
            returnVO.setMessage(ExceptionStrUtil.getErrMsg(respe.getErrorMessage()));
            return returnVO;
        }
    }

    @Override
    public <T> T doQuery(String fwid, Object param, Class<T> t) {
        if (param == null) {
            throw new AppException("参数不能为空");
        }
        BcpRequest request = new BcpRequest();
        if (param instanceof CdsiQueryParamVO) {
            ((CdsiQueryParamVO) param).checkData();
        }
        request.setInput(param);
        IClientProfile fw = fws.get(fwid);
        if (fw == null) {
            fw = setFw(fwid);
        }
        IBcpClient client = xtptConnect.getXtptClient(fw, request);
        try {
            if(t == null){
                BcpResponse resp = client.getResponse();
                if (resp.isInvokeSuccess()) {
                    return null;
                } else {
                    String errorMessage = resp.getErrorMessage();
                    log.error(errorMessage);
                    throw new AppException("连接协同平台出现异常：" + ExceptionStrUtil.getErrMsg(errorMessage));
                }
            }
            BcpResponse<T> resp = client.getResponse(t);
            if (resp.isInvokeSuccess()) {
                T invokeData = resp.getInvokeData();
                return invokeData;
            } else {
                String errorMessage = resp.getErrorMessage();
                log.error(errorMessage);
                throw new AppException("连接协同平台出现异常：" + ExceptionStrUtil.getErrMsg(errorMessage));
            }
        } catch (ServerException e) {
            e.printStackTrace();
            throw new AppException("Server" + e.getErrMsg());
        } catch (ClientException e) {
            e.printStackTrace();
            throw new AppException("Client" + e.getErrMsg());
        }
    }

    private synchronized IClientProfile setFw(String fwid) {
        IClientProfile fw = DefaultProfile.getProfile(xtptUrl, systemID, fwid);
        fws.put(fwid, fw);
        return fw;
    }

}
