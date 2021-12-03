package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 天府市民云城居待遇测算接口
 *
 * @Author: cx
 */

public class ResSimulationSmyVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 缴费档次 01 一档50%， 02 二档40% ，03 三档30% ，04 四档20% ，05 五档10%
     */
    private String jfdc;
    /**
     * 个人编码
     */
    private String aac001;
    /**
     * 是否独子 0否 ，1是
     */
    private String yic489;
    /**
     * 已缴费年限
     */
    private Integer aae201_sj;
    /**
     * 需一次性缴费年限
     */
    private Integer aae201_ycx;
    /**
     * 兵役月数
     */
    private Integer byMonthes; // 兵役月数
    /**
     * 基础性养老金
     */
    private BigDecimal aic240;
    /**
     * 个人账户养老金
     */
    private BigDecimal aic242;
    /**
     * 基本养老金补贴
     */
    private BigDecimal aic240_015;

    private String aaz159;

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

    public Integer getAae201_sj() {
        return aae201_sj;
    }

    public void setAae201_sj(Integer aae201_sj) {
        this.aae201_sj = aae201_sj;
    }

    public Integer getAae201_ycx() {
        return aae201_ycx;
    }

    public void setAae201_ycx(Integer aae201_ycx) {
        this.aae201_ycx = aae201_ycx;
    }

    public String getAaz159() {
        return aaz159;
    }

    public void setAaz159(String aaz159) {
        this.aaz159 = aaz159;
    }
}
