package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CjPensionForecastInVO implements CdsiQueryParamVO, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 缴费档次 01 一档50%， 02 二档40% ，03 三档30% ，04 四档20% ，05 五档10%
     */
    private String jfdc;
    /**
     * 个人编码
     */
    String aac001;
    /**
     * 是否独子 0否 ，1是
     */
    String yic489;
    /**
     * 兵役月数
     */
    Integer byMonthes; // 兵役月数
    /**
     * 基础性养老金
     */
    BigDecimal aic240;
    /**
     * 个人账户养老金
     */
    BigDecimal aic242;
    /**
     * 基本养老金补贴
     */
    BigDecimal aic240_015;


    public String getJfdc() {
        return jfdc;
    }

    public void setJfdc(String jfdc) {
        this.jfdc = jfdc;
    }

    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public String getYic489() {
        return yic489;
    }

    public void setYic489(String yic489) {
        this.yic489 = yic489;
    }

    public Integer getByMonthes() {
        return byMonthes;
    }

    public void setByMonthes(Integer byMonthes) {
        this.byMonthes = byMonthes;
    }

    public BigDecimal getAic240() {
        return aic240;
    }

    public void setAic240(BigDecimal aic240) {
        this.aic240 = aic240;
    }

    public BigDecimal getAic242() {
        return aic242;
    }

    public void setAic242(BigDecimal aic242) {
        this.aic242 = aic242;
    }

    public BigDecimal getAic240_015() {
        return aic240_015;
    }

    public void setAic240_015(BigDecimal aic240_015) {
        this.aic240_015 = aic240_015;
    }
    public void checkData() {
//        if (ValidateUtil.isEmpty(jfdc)) throw new AppException("缴费档次为空！");
        if (ValidateUtil.isEmpty(aac001)) throw new AppException("个人编码为空！");
        if (ValidateUtil.isEmpty(yic489)) throw new AppException("是否独子为空！");
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("jfdc", this.jfdc);
        map.put("aac001", this.aac001);
        map.put("yic489", this.yic489);
        map.put("byMonthes", this.byMonthes);
        map.put("aic240", this.aic240);
        map.put("aic242", this.aic242);
        map.put("aic240_015", this.aic240_015);
        return map;
    }

}
