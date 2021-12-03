package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个人参保信息输入VO
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Wtcxgr0030InVO implements CdsiQueryParamVO, Serializable {

    private static final long serialVersionUID = 1L;

    private String aae140; // 险种类型
    private String yab139; // 经办机构
    private String aac009; // 户口性质
    private boolean flag = true;
    private String errMsg;

    public void checkData() {
        if (ValidateUtil.isEmpty(aae140)) {
            throw new AppException("险种类型不能为空!");
        }
        if (ValidateUtil.isEmpty(yab139)) {
            throw new AppException("经办机构不能为空!");
        }
    }


    public String getAae140() {
        return aae140;
    }


    public void setAae140(String aae140) {
        this.aae140 = aae140;
    }


    public String getYab139() {
        return yab139;
    }


    public void setYab139(String yab139) {
        this.yab139 = yab139;
    }


    public String getAac009() {
        return aac009;
    }


    public void setAac009(String aac009) {
        this.aac009 = aac009;
    }


    public static long getSerialversionuid() {
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
        map.put("aae140", this.aae140);
        map.put("yab139", this.yab139);
        map.put("aac009", this.aac009);
        map.put("flag", this.flag);
        map.put("errMsg", this.errMsg);
        return map;
    }

}
