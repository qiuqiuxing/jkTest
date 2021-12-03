package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 获取参工时间，视同缴费年限，实际缴费年限输出
 */
public class PersonalInfoOutVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<PersonalOutDetailVO> detailVOList;
    private boolean flag;
    private String errMsg;

    public List<PersonalOutDetailVO> getDetailVOList() {
        return detailVOList;
    }

    public void setDetailVOList(List<PersonalOutDetailVO> detailVOList) {
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
