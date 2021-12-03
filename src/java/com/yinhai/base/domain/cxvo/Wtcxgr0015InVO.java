package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询养老待遇发放信息输入VO
 *
 * @Author:
 */
public class Wtcxgr0015InVO implements CdsiQueryParamVO,Serializable {
    private static final long serialVersionUID = 1L;
    private String aac002;// 身份证号
    private String aac003;// 姓名
    private String aac001;// 单位编码

    public void checkData() {
        if (ValidateUtil.isEmpty(aac002)) {
            throw new AppException("身份证号不能为空!");
        }
        if (ValidateUtil.isEmpty(aac003)) {
            throw new AppException("姓名不能为空!");
        }
    }

    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * toMap
     *
     * @return
     */
    public Map toMap() {
        Map map = new HashMap();
        map.put("aac002", this.aac002);
        map.put("aac003", this.aac003);
        map.put("aac001", this.aac001);
        return map;
    }


}
