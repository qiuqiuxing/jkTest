package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个人基本信息输出VO
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class AddressOutDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String yae913;//市
    private String yae914;//区(市)县
    private String yae915;//街道(乡镇)
    private String yae916;//社区(村)

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getYae913() {
        return yae913;
    }

    public void setYae913(String yae913) {
        this.yae913 = yae913;
    }

    public String getYae914() {
        return yae914;
    }

    public void setYae914(String yae914) {
        this.yae914 = yae914;
    }

    public String getYae915() {
        return yae915;
    }

    public void setYae915(String yae915) {
        this.yae915 = yae915;
    }

    public String getYae916() {
        return yae916;
    }

    public void setYae916(String yae916) {
        this.yae916 = yae916;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("aac007", this.yae913);
        map.put("treatAs", this.yae914);
        map.put("actual", this.yae915);
        map.put("actual", this.yae916);
        return map;
    }
}
