package com.yinhai.base.appcode;

import com.yinhai.base.domain.cxvo.Wtcxgg0001InVO;
import com.yinhai.base.domain.cxvo.Wtcxgg0001OutDetailVO;
import com.yinhai.base.domain.cxvo.Wtcxgg0001OutVO;
import com.yinhai.base.exception.AppException;
import com.yinhai.base.service.cdsixtpt.CdsiXtptService;
import com.yinhai.base.service.cdsixtpt.FwidConstant;
import com.yinhai.base.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author qiurong
 * @version 1.0.0
 * @Description
 * @ClassName CdsiAppCode.java
 * @createTime 2021年02月26日 11:38:00
 */
public class CdsiAppCode {
    /**
     * 需要加载的码表参数串
     */
    private List<String> needCode;
    private static final Logger log = LoggerFactory.getLogger(CdsiAppCode.class);
    private CdsiXtptService cdsiXtptService;
    private Wtcxgg0001OutVO[] appCodes;
    
    public void flushCodeAll(){
        if(ValidateUtil.isEmpty(needCode)) return;
        log.info("开始加载码表...");
         flushCode();
        log.info("加载码表完成!!!");
    }

    private void flushCode() {
        Wtcxgg0001OutVO[] appCodess = new Wtcxgg0001OutVO[needCode.size()];
        for (int i = 0, len = needCode.size(); i < len; i++) {
            Wtcxgg0001InVO wtcxgg0001InVO = new Wtcxgg0001InVO();
            wtcxgg0001InVO.setAaa100(needCode.get(i));
     //       appCodess[i] = this.cdsiXtptService.doQuery(FwidConstant.WTCXGG0001, wtcxgg0001InVO, Wtcxgg0001OutVO.class);
            log.info("加载-" + needCode.get(i) + "-完成!");
        }
        this.appCodes = appCodess;
    }

    /**
     * 查询码表所有对应键值对
     *
     * @param aaa100
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List getCodeAll(String aaa100) throws Exception{
        aaa100 = aaa100.toUpperCase();
        int index = -1;
        for (int i = 0; i < needCode.size(); i++) {
            if (aaa100.equals(needCode.get(i))) {
                index = i;
                break;
            }
        }
        if (index < 0) throw new AppException("未加入码表参数串的aaa100，请联系开发人员!");
        List<Wtcxgg0001OutDetailVO> detailList = appCodes[index].getDetailVOList();
        if (detailList == null || detailList.size() == 0) throw new AppException("加入码表参数串的aaa100没有存在于社保库中，请联系开发人员!");
        List relist = new ArrayList(detailList.size());
        for (int i = 0, len = detailList.size(); i < len; i++) {
            relist.add(detailList.get(i).toMap());
        }
        return relist;
    }
    /**
     * 查询码表所有对应键值对
     *
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map<String, List> getCodeAll() throws Exception {
        Map<String, List> map = new HashMap<>();
        for (int i = 0; i < needCode.size(); i++) {
            List<Wtcxgg0001OutDetailVO> detailList = appCodes[i].getDetailVOList();
            List relist = new ArrayList(detailList.size());
            for (Wtcxgg0001OutDetailVO detailVO : detailList) {
                relist.add(detailVO.toMap());
            }
            map.put(needCode.get(i), relist);
        }
        return map;
    }
    /**
     * 查询码表所有对应键值对
     *
     * @param aaa100
     * @param aaa102 键值，如AAC004
     * @return 码值，如果没有则为""
     */
    public String getCodeDesc(String aaa100, String aaa102) throws Exception{
        aaa100 = aaa100.toUpperCase();
        int index = -1;
        for (int i = 0; i < needCode.size(); i++) {
            if (aaa100.equals(needCode.get(i))) {
                index = i;
                break;
            }
        }
        if (index < 0) throw new AppException("未加入码表参数串的aaa100，请联系开发人员!");
        List<Wtcxgg0001OutDetailVO> detailList = appCodes[index].getDetailVOList();
        if (detailList == null) throw new AppException("加入码表参数串的aaa100没有存在于社保库中，请联系开发人员!");
        for (int i = 0, len = detailList.size(); i < len; i++) {
            if (detailList.get(i).getAaa102().equals(aaa102))
                return detailList.get(i).getAaa103();
        }
        return "";
    }

    /**
     * 获取3版码值（带过滤）
     *
     * @param aaa100
     * @param filters 需要过滤的码值，多个值以“,”隔开
     * @param reverse true为正向过滤，false为反向过滤
     * @return
     */
    public List getFilterCode(String aaa100, String filters, boolean reverse) throws Exception{
        List cdsi3AppCode = this.getCodeAll(aaa100);
        List list = new ArrayList();//正向过滤数据

        if (ValidateUtil.isNotEmpty(filters)) {
            String[] split = filters.split(",");
            Iterator iterator = cdsi3AppCode.iterator();
            Map tmap;
            while (iterator.hasNext()) {
                tmap = (Map) iterator.next();
                for (int i = 0, len = split.length; i < len; i++) {
                    if (!reverse && ValidateUtil.areEqual(tmap.get("id"), split[i])) {
                        list.add(tmap);
                    }
                    if (reverse && ValidateUtil.areEqual(tmap.get("id"), split[i])) {
                        iterator.remove();
                    }
                }
            }
        }
        return reverse ? cdsi3AppCode : list;
    }

    public List<String> getNeedCode() {
        return needCode;
    }

    public void setNeedCode(List<String> needCode) {
        this.needCode = needCode;
    }

    public CdsiXtptService getCdsiXtptService() {
        return cdsiXtptService;
    }

    public void setCdsiXtptService(CdsiXtptService cdsiXtptService) {
        this.cdsiXtptService = cdsiXtptService;
    }
}
