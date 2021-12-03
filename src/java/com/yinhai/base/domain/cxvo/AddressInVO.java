package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AddressInVO implements CdsiQueryParamVO, Serializable {

    private static final long serialVersionUID = 1L;
    private String yxb005; // yxb005：00省     yxb005：01市      yxb005：02县      yxb005：03镇      yxb005：04社区
    private String yab003; //

    public void checkData() {
        if (ValidateUtil.isEmpty(yxb005)) {
            throw new AppException(yxb005);
        }
//        if (ValidateUtil.isEmpty(yab003)) {
//            throw new AppException(yab003);
//        }
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getYxb005() {
        return yxb005;
    }

    public void setYxb005(String yxb005) {
        this.yxb005 = yxb005;
    }

    public String getYab003() {
        return yab003;
    }

    public void setYab003(String yab003) {
        this.yab003 = yab003;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("yxb005", this.yxb005);
        map.put("yab003", this.yab003);
        return map;
    }
}



