package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CzPensionForecastOutDtailVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String monthlyPension;// 您每月的基本养老金
    private String basicPension;// 基础养老金
    private String individualAccountPension;// 个人账户养老金
    private String transitionalPension;// 过渡性养老金

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMonthlyPension() {
        return monthlyPension;
    }

    public void setMonthlyPension(String monthlyPension) {
        this.monthlyPension = monthlyPension;
    }

    public String getBasicPension() {
        return basicPension;
    }

    public void setBasicPension(String basicPension) {
        this.basicPension = basicPension;
    }

    public String getIndividualAccountPension() {
        return individualAccountPension;
    }

    public void setIndividualAccountPension(String individualAccountPension) {
        this.individualAccountPension = individualAccountPension;
    }

    public String getTransitionalPension() {
        return transitionalPension;
    }

    public void setTransitionalPension(String transitionalPension) {
        this.transitionalPension = transitionalPension;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("monthlyPension", this.monthlyPension);
        map.put("basicPension", this.basicPension);
        map.put("individualAccountPension", this.individualAccountPension);
        map.put("transitionalPension", this.transitionalPension);
        return map;
    }

}
