package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

public class CzPensionForecastOutVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CzPensionForecastOutDtailVO> detailVOList;
    private boolean flag;
    private String errMsg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<CzPensionForecastOutDtailVO> getDetailVOList() {
        return detailVOList;
    }

    public void setDetailVOList(List<CzPensionForecastOutDtailVO> detailVOList) {
        this.detailVOList = detailVOList;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
