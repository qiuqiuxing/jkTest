package com.yinhai.base.domain.cxvo;

import java.io.Serializable;


/**
 * 城居养老-缴费月数查询
 *
 * @author gaoxiangyu
 * @version 1.0
 * @date 2020年8月5日
 */
public class Wtcxqy0045OutVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg;//错误信息

    private Integer aae201;//已缴费月数

    private Integer aae202;//还需缴费月数

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getAae201() {
        return aae201;
    }

    public void setAae201(Integer aae201) {
        this.aae201 = aae201;
    }

    public Integer getAae202() {
        return aae202;
    }

    public void setAae202(Integer aae202) {
        this.aae202 = aae202;
    }


}
