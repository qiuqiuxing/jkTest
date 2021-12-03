package com.yinhai.base.service.cdsixtpt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yinhai.base.access.AccessAbstract;
import com.yinhai.base.access.AccessRole;
import com.yinhai.base.access.AccessType;
import com.yinhai.base.domain.CdsiParamVO;
import com.yinhai.base.domain.cxvo.*;
import com.yinhai.base.exception.AppException;
import com.yinhai.base.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 协同平台查询接口汇总
 */
public class QueryXtptService {
    @Autowired
    private CdsiXtptService cdsiXtptService;

    /**
     * 功能描述: 查询个人基本信息
     */
    public List<Wtcxgr0001OutDetailVO> wtcxgr0001(Wtcxgr0001InVO param) {
        Wtcxgr0001OutVO wtcxgr0001OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0001, param, Wtcxgr0001OutVO.class);
        return wtcxgr0001OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 查询个人参保信息
     */
    public List<Wtcxgr0002OutDetailVO> wtcxgr0002(Wtcxgr0002InVO param) {
        Wtcxgr0002OutVO wtcxgr0002OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0002, param, Wtcxgr0002OutVO.class);
        return wtcxgr0002OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 个体正常缴费查询
     */
    public List<Wtcxgr0026OutDetailVO> wtcxgr0026(Wtcxgr0026InVO wtcxgr0026InVO) {
        Wtcxgr0026OutVO wtcxgr0026OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0026, wtcxgr0026InVO, Wtcxgr0026OutVO.class);
        if (!wtcxgr0026OutVO.isFlag() && ValidateUtil.isNotEmpty(wtcxgr0026OutVO.getErrMsg())) {
            throw new AppException(wtcxgr0026OutVO.getErrMsg());
        }
        return wtcxgr0026OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 查询个体人员参保信息
     */
    public List<Wtcxgr0029OutDetailVO> wtcxgr0029(String aac001) {
        Wtcxgr0029InVO wtcxgr0029InVO = new Wtcxgr0029InVO();
        wtcxgr0029InVO.setAac001(aac001);
        Wtcxgr0029OutVO wtcxgr0029OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0029, wtcxgr0029InVO, Wtcxgr0029OutVO.class);
        if (!wtcxgr0029OutVO.isFlag() && ValidateUtil.isNotEmpty(wtcxgr0029OutVO.getErrMsg())) {
            throw new AppException(wtcxgr0029OutVO.getErrMsg());
        }
        return wtcxgr0029OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 查询缴费档次
     */
    public List<Wtcxgr0030OutDetailVO> wtcxgr0030(String aac009, String aae140, String yab003) {
        Wtcxgr0030InVO wtcxgr0030InVO = new Wtcxgr0030InVO();
        wtcxgr0030InVO.setAac009(aac009);
        wtcxgr0030InVO.setAae140(aae140);
        wtcxgr0030InVO.setYab139(yab003);
        Wtcxgr0030OutVO wtcxgr0030OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0030, wtcxgr0030InVO, Wtcxgr0030OutVO.class);
        if (!wtcxgr0030OutVO.isFlag() && ValidateUtil.isNotEmpty(wtcxgr0030OutVO.getErrMsg())) {
            throw new AppException(wtcxgr0030OutVO.getErrMsg());
        }
        return wtcxgr0030OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 查询银行账户信息
     */
    public List<Wtcxgr0031OutDetailVO> wtcxgr0031(String aac001) {
        Wtcxgr0031InVO wtcxgr0031InVO = new Wtcxgr0031InVO();
        wtcxgr0031InVO.setAac001(aac001);
        Wtcxgr0031OutVO wtcxgr0031OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0031, wtcxgr0031InVO, Wtcxgr0031OutVO.class);
        return wtcxgr0031OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 查询城居预算结果
     */
//    public CjPensionForecastInVO wtcxgr0045(CjPensionForecastInVO pensionForecastInVO) {
//        CjPensionForecastInVO personalInfoOutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0045, pensionForecastInVO, CjPensionForecastInVO.class);
//        return personalInfoOutVO;
//    }
    public ResSimulationSmyVO wtcxqy0068(ResSimulationSmyVO resSimulationSmyVO) {
        ResSimulationSmyVO ResSimulationSmyOutVO = cdsiXtptService.doQuery(FwidConstant.WTCXQY0068, resSimulationSmyVO, ResSimulationSmyVO.class);
        return ResSimulationSmyOutVO;
    }

    /**
     * 查询地址
     */
    public List<Map> wtcxgg0004(String yxb005, String yab003) {
        AddressInVO addressInVO = new AddressInVO();
        addressInVO.setYxb005(yxb005);
        addressInVO.setYab003(yab003);
        AddressOutVO addressInfoOutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGG0004, addressInVO, AddressOutVO.class);
        return addressInfoOutVO.getmList();
    }

    /**
     * 查询养老待遇发放信息
     */
    public List<Wtcxgr0015OutDetailVO> wtcxgr0015(String aac001, String aac002, String aac003) {
        Wtcxgr0015InVO param = new Wtcxgr0015InVO();
        param.setAac002(aac002);
        param.setAac003(aac003);
        param.setAac001(aac001);
        Wtcxgr0015OutVO wtcxgr0015OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0015, param, Wtcxgr0015OutVO.class);
        return wtcxgr0015OutVO.getDetailVOList();
    }

    /**
     * 查询个人养老账户基本信息
     */
    public SimulationCalVO wtcxqy0062(String aac001) {
        SimulationCalVO simulationCalVO = new SimulationCalVO();
        simulationCalVO.setAac001(aac001);
        SimulationCalVO simulationOutVO = cdsiXtptService.doQuery(FwidConstant.WTCXQY0062, simulationCalVO, SimulationCalVO.class);
        return simulationOutVO;
    }

    /**
     * 查询城职养老待遇测算结果
     */
    public SimulationCalVO wtcxqy0065(SimulationCalVO simulationCalVO) {
        SimulationCalVO simulationOutVO = cdsiXtptService.doQuery(FwidConstant.WTCXQY0065, simulationCalVO, SimulationCalVO.class);
        return simulationOutVO;
    }

    /**
     * 查询社保卡银行信息
     */
    public Map wtcxsmy001(Wtcxsmy001InVO param) {
        Wtcxsmy001InVO wtcxsmy001InVO = cdsiXtptService.doQuery(FwidConstant.WTCXSMY001, param, Wtcxsmy001InVO.class);
        return wtcxsmy001InVO.getResultMap();
    }

    /**
     * 查询联系信息（养老）
     */
    public Map wtcxsmy002(String aac001, String aac002, String aac003) {
        Wtcxsmy002InVO param = new Wtcxsmy002InVO();
        param.setAac001(aac001);
        param.setAac002(aac002);
        param.setAac003(aac003);
        Wtcxsmy002InVO wtcxsmy002InVO = cdsiXtptService.doQuery(FwidConstant.WTCXSMY002, param, Wtcxsmy002InVO.class);
        return wtcxsmy002InVO.getResultMap();
    }

    /**
     * 查询已办业务
     */
    public TfsmyCx003OutVO wtcxsmy003(TfsmyCx003InVO param) {
        if (ValidateUtil.isEmpty(param.getAae041())) {
            param.setAae041("2020-07-01");
        }
        TfsmyCx003OutVO tfsmyCx003OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXSMY003, param, TfsmyCx003OutVO.class);
        return tfsmyCx003OutVO;
    }

    /**
     * 查询已办业务详情（公共业务）
     */
    public List wtcxsmy004(String aac001, String aaz002) {
        List list = new ArrayList();
        TfsmyCx004InVO param = new TfsmyCx004InVO();
        param.setAac001(aac001);
        param.setAaz002(aaz002);
        TfsmyCx004OutVO tfsmyCx004OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXSMY004, param, TfsmyCx004OutVO.class);
        if (!ValidateUtil.isEmpty(tfsmyCx004OutVO.getTfsmyCx004_1OutDetailVOs())) {
            list = tfsmyCx004OutVO.getTfsmyCx004_1OutDetailVOs();
        }
        if (!ValidateUtil.isEmpty(tfsmyCx004OutVO.getTfsmyCx004_2OutDetailVOs())) {
            list = tfsmyCx004OutVO.getTfsmyCx004_2OutDetailVOs();
        }
        if (!ValidateUtil.isEmpty(tfsmyCx004OutVO.getTfsmyCx004_3OutDetailVOs())) {
            list = tfsmyCx004OutVO.getTfsmyCx004_3OutDetailVOs();
        }
        return list;
    }

    /**
     * 查询已办业务详情（四险待遇）
     */
    public List wtcxsmy005(String aac001, String aaz002) {
        ChangeInfoVO param = new ChangeInfoVO();
        param.setAac001(aac001);
        param.setAaz002(aaz002);
        ChangeInfoVO changeInfoVO = cdsiXtptService.doQuery(FwidConstant.WTCXSMY005, param, ChangeInfoVO.class);
        return changeInfoVO.getChangeInfoList();
    }

    /**
     * 城居养老-缴费月数查询
     *
     * @param aac001
     * @return
     */
    public Wtcxqy0066OutVO wtcxqy0066(String aac001) {
        if (ValidateUtil.isEmpty(aac001)) {
            throw new AppException("个人编号不能为空");
        }
        Wtcxqy0066InVO param = new Wtcxqy0066InVO();
        param.setAac001(aac001);
        Wtcxqy0066OutVO wtcxqy0066outvo = cdsiXtptService.doQuery(FwidConstant.WTCXGR0066, param, Wtcxqy0066OutVO.class);
        return wtcxqy0066outvo;
    }

    /**
     * 查询个体欠缴单据信息
     *
     * @param aac001
     * @return
     */
    public List<Wtcxgr0027OutDetailVO> wtcxgr0027(String aac001) {
        Wtcxgr0027InVO param = new Wtcxgr0027InVO();
        param.setAac001(aac001);
        Wtcxgr0027OutVO wtcxgr0027OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0027, param, Wtcxgr0027OutVO.class);
        return wtcxgr0027OutVO.getDetailVOList();
    }

    /**
     * 查询个体欠缴单据明细信息
     *
     * @param aac001
     * @return
     */
    public List<Wtcxgr0028OutDetailVO> wtcxgr0028(String aac001, String aaz288) {
        Wtcxgr0028InVO param = new Wtcxgr0028InVO();
        param.setAac001(aac001);
        param.setAae076(aaz288);
        Wtcxgr0028OutVO wtcxgr0028OutVO = cdsiXtptService.doQuery(FwidConstant.WTCXGR0028, param, Wtcxgr0028OutVO.class);
        return wtcxgr0028OutVO.getDetailVOList();
    }

    /**
     * 功能描述: 查询个体单据明细（aaz002与aaz288可选填一个）
     *
     * @param aac001 个人编号
     * @param aaz002 业务日志号
     * @param aaz288 单据号
     */
    public List<TfsmyCx006OutDetailVO> wtcxsmy006(String aac001, String aaz002, String aaz288) {
        TfsmyCx006InVO param = new TfsmyCx006InVO();
        param.setAac001(aac001);
        param.setAaz002(aaz002);
        param.setAaz288(aaz288);
        TfsmyCx006OutVO returnVo = cdsiXtptService.doQuery(FwidConstant.WTCXSMY006, param, TfsmyCx006OutVO.class);
        return returnVo.getDetailList();
    }

    /**
    *
    * 功能描述: 查询个体单据信息
    *
    * @param aac001
     * @param dzbz 到账标志：0 未到账，1 已到账（可为空）
    */
    public List<TfsmyCx007OutDetailVO> wtcxsmy007(String aac001, String dzbz) {
        TfsmyCx007InVO param = new TfsmyCx007InVO();
        param.setAac001(aac001);
        param.setDzbz(dzbz);
        TfsmyCx007OutVO returnVo = cdsiXtptService.doQuery(FwidConstant.WTCXSMY007, param, TfsmyCx007OutVO.class);
        return returnVo.getDetailList();
    }

    /**
    *
    * 功能描述: 获取预约排号队列信息
    *
    */
    public List<Map> phyy0001(AccessAbstract user) {
        String yab003 = user.getYab003();
        AccessRole role = user.getRoles().get(0);
        if (!"510199".equals(yab003) || role != AccessRole.CZGT) {
            throw new AppException("目前只支持市本级的个体参保人员进行预约！");
        }
        String param = "510199_51010000000001";
        JSONArray objects = cdsiXtptService.doQuery(FwidConstant.PHYY0001, param, JSONArray.class);
        List<Map> list = objects.toJavaList(Map.class);
        Iterator<Map> iterator = list.iterator();
        //去除单位预约业务
        List<Map> list2 = new ArrayList<>();
        while (iterator.hasNext()) {
            Map map = iterator.next();
            if(ValidateUtil.areEqual("7",map.get("id")) || ValidateUtil.areEqual("11",map.get("id"))){
                list2.add(map);
            }
        }
        return list2;
    }

    /**
    *
    * 功能描述: 获取预约排号情况
    *
    * @param aac002 身份证
     * @param appointdate 预约日期
     * @param ph 排号id
    */
    public void phyy0002(String aac002,String appointdate,String ph) {
        Map paramMap = new HashMap();
        paramMap.put("identitycardid", aac002);
        paramMap.put("appointdate", appointdate);
        paramMap.put("ph", ph);
        String param = JSON.toJSONString(paramMap);
        String resultStr = cdsiXtptService.doQuery(FwidConstant.PHYY0002, param, String.class);
        if(ValidateUtil.isNotEmpty(resultStr)){
            throw new AppException(resultStr);
        }
    }

    /**
    *
    * 功能描述:获取预约排号结果信息
     * {"appointdate":"预约日期",(必须)
     * sourceid":"事项id",
     * itemid":"事项实施编码",
     * appointtimestart":"预约开始时间",
     * appointtimeend":"预约结束时间",
     * appointtype":"预约来源",(必须)
     * username":"姓名",(必须)
     * identitycardid":"身份证",(必须)
     * ph":"排号",(必须)
     * mobile":"手机号"
     * }
    * @param user 用户
     * @param appointdate 预约日期
     * @param ph 排号id
     * @param mobile 手机号码
    * @return: java.lang.String 预约成功通知信息
    */
    public String phyy0003(AccessAbstract user, String appointdate, String ph, String mobile) {
        String ly = "";
        if(user.getAccessType() == AccessType.TFSMY){
            ly = CdsiParamVO.ACCEPT_SOURCE_51_SMY;
        }else if(user.getAccessType() == AccessType.WX){
            ly = CdsiParamVO.ACCEPT_SOURCE_52_WX;
        }else if(user.getAccessType() == AccessType.ZFB){
            ly = CdsiParamVO.ACCEPT_SOURCE_53_ZFB;
        }else if(user.getAccessType() == AccessType.DZSBK){
            ly = CdsiParamVO.ACCEPT_SOURCE_54_DZSBK;
        }
        Map paramMap = new HashMap();
        paramMap.put("identitycardid", user.getAac002());
        paramMap.put("username", user.getAac003());
        paramMap.put("appointdate", appointdate);
        paramMap.put("ph", ph);
        paramMap.put("mobile", mobile);
        paramMap.put("appointtype", ly);
        String param = JSON.toJSONString(paramMap);
        Map result = cdsiXtptService.doQuery(FwidConstant.PHYY0003, param, Map.class);
        if(!ValidateUtil.isEmpty(result.get("code")) && ValidateUtil.areEqual("0",result.get("code"))){
            String text = (String) result.get("text");
            throw new AppException(text);
        }
        return result.get("text").toString();
    }
}
