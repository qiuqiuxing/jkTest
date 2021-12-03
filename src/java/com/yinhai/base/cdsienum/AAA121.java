package com.yinhai.base.cdsienum;


import com.yinhai.base.service.cdsixtpt.FwidConstant;

/**
 * @Description 申报业务类型枚举
 * @ClassName AAA121.java
 * @createTime 2020年11月24日 16:27:00
 */
public enum AAA121 {
    SMY0001("A01200", "个人参保", FwidConstant.SMY0001),
    SMY0002(null, "个人停保", FwidConstant.SMY0002),//不评价 A01300
    SMY0003("A00600", "变更养老档次", FwidConstant.SMY0003),
    SMY0004("A00600", "联系方式变更", FwidConstant.SMY0004),
    SMY0005("A10800", "变更养老金账号和联系方式", FwidConstant.SMY0005);

    private String id;
    private String value;
    private String fwid;

    AAA121(String id, String value, String fwid) {
        this.id = id;
        this.value = value;
        this.fwid = fwid;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getFwid() {
        return fwid;
    }

}
