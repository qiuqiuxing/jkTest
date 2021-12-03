package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

public class CjPensionForecastOutVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CjPensionForecastOutDtailVO> detailVOList;
    private boolean flag;
    private String errMsg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<CjPensionForecastOutDtailVO> getDetailVOList() {
        return detailVOList;
    }

    public void setDetailVOList(List<CjPensionForecastOutDtailVO> detailVOList) {
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
