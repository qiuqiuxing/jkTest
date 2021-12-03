package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 获取地址输出
 */
public class AddressOutVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Map> mList;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<Map> getmList() {
        return mList;
    }

    public void setmList(List<Map> mList) {
        this.mList = mList;
    }
}
