package com.yinhai.base.domain.cxvo;

import java.io.Serializable;

/**
 * 城居养老-缴费月数查询
 *
 * @author gaoxiangyu
 * @version 1.0
 * @date 2020年8月5日
 */
public class Wtcxqy0066InVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String aac001; //个人编号

    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
