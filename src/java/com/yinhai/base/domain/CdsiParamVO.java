package com.yinhai.base.domain;

import com.yinhai.base.access.AccessAbstract;
import com.yinhai.base.access.AccessType;
import com.yinhai.base.exception.AppException;

import java.io.Serializable;

/**
 * 参数主体部分内容
 */
public class CdsiParamVO implements Serializable {
    private static final long serialVersionUID = 2017061201L;

    private CdsiParamVO(){};
    /**
     * 经办人
     */
    private String aae011;
    /**
     * 经办分中心
     */
    private String yab003;
    /**
     * 经办人姓名
     */
    private String aae414;
    /**
     * 受理渠道
     */
    private String accept_source;
    /**
     * 个人编号
     */
    private String aac001;
    /**
     * 社会保障号
     */
    private String aac002;
    /**
     * 姓名
     */
    private String aac003;
    /**
     * 评价渠道细则（好差评用）
     */
    private String csk084a1;
    /**
     * 详细参数
     */
    private CdsiParamDetailVO param;

    public String getAae011() {
        return aae011;
    }

    public String getYab003() {
        return yab003;
    }

    public String getAae414() {
        return aae414;
    }

    public String getAccept_source() {
        return accept_source;
    }

    public String getAac001() {
        return aac001;
    }

    public String getAac002() {
        return aac002;
    }

    public String getAac003() {
        return aac003;
    }

    public String getCsk084a1() {
        return csk084a1;
    }

    public CdsiParamDetailVO getParam() {
        return param;
    }

    private static final String AAE011_TFSMY = "999901";//经办人:天府市民云
    private static final String AAE011_WX_1 = "999911";//经办人:微信（社保微信公众号）
    private static final String AAE011_WX_2 = "999912";//经办人:微信（人社微信公众号）
    private static final String AAE011_WX_3 = "999913";//经办人:微信（12333微信公众号）
    private static final String AAE011_ZFB = "999921";//经办人:支付宝
    private static final String AAE011_DZSBK = "999931";//经办人:电子社保卡

    public static final String ACCEPT_SOURCE_51_SMY = "51";//受理数据来源:天府市民云
    public static final String ACCEPT_SOURCE_52_WX = "52";//受理数据来源:微信
    public static final String ACCEPT_SOURCE_53_ZFB = "53";//受理数据来源:支付宝
    public static final String ACCEPT_SOURCE_54_DZSBK = "54";//受理数据来源:电子社保卡

    public static final String CSK084A1_203 = "203";//评价渠道细则-微信
    public static final String CSK084A1_204 = "204";//评价渠道细则-支付宝
    public static final String CSK084A1_209 = "209";//评价渠道细则-市民云
    public static final String CSK084A1_212 = "212";//评价渠道细则-电子社保卡
    /**
     * 工厂方法，获取参数对象
     * @return
     */
    public static CdsiParamVO getInstance(AccessAbstract user, CdsiParamDetailVO param){
        CdsiParamVO paramVO = new CdsiParamVO();
        paramVO.aac001 = user.getAac001();
        paramVO.aac002 = user.getAac002();
        paramVO.aac003 = user.getAac003();
        paramVO.yab003 = user.getYab003();
        if(user.getAccessType() == AccessType.TFSMY){
            paramVO.aae011 = AAE011_TFSMY;
            paramVO.aae414 = "天府市民云";
            paramVO.accept_source = ACCEPT_SOURCE_51_SMY;
            paramVO.csk084a1 = CSK084A1_209;
        }else if(user.getAccessType() == AccessType.WX){
            paramVO.aae011 = AAE011_WX_1;
            paramVO.aae414 = "微信";
            paramVO.accept_source = ACCEPT_SOURCE_52_WX;
            paramVO.csk084a1 = CSK084A1_203;
        }else if(user.getAccessType() == AccessType.ZFB){
            paramVO.aae011 = AAE011_ZFB;
            paramVO.aae414 = "支付宝";
            paramVO.accept_source = ACCEPT_SOURCE_53_ZFB;
            paramVO.csk084a1 = CSK084A1_204;
        }else if(user.getAccessType() == AccessType.DZSBK){
            paramVO.aae011 = AAE011_DZSBK;
            paramVO.aae414 = "电子社保卡";
            paramVO.accept_source = ACCEPT_SOURCE_54_DZSBK;
            paramVO.csk084a1 = CSK084A1_212;
        }else {
            throw new AppException("未获取到用户类型");
        }
        //数据校验
        param.checkData();
        paramVO.param = param;
        return paramVO;
    }
}
