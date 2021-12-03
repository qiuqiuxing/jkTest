package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取参工时间，视同缴费年限，实际缴费年限输入
 */
public class PersonalInfoInVO implements CdsiQueryParamVO, Serializable {
    private static final long serialVersionUID = 1L;
    private String aac003;//姓名
    private String aac002;//社会保障号
    private boolean flag = true;
    private String errMsg;

    public void checkData() {
        if (ValidateUtil.isEmpty(aac003)) {
            throw new AppException("姓名不能为空!");
        }
        if (ValidateUtil.isEmpty(aac002)) {
            throw new AppException("社会保障号不能为空!");
        }
    }


    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    /**
     * toMap
     *
     * @return
     */
    public Map toMap() {
        Map map = new HashMap();
        map.put("aac003", this.aac003);
        map.put("aac002", this.aac002);
        map.put("flag", this.flag);
        map.put("errMsg", this.errMsg);
        return map;
    }
}



