package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CzPensionForecastInVO implements CdsiQueryParamVO, Serializable {
    private static final long serialVersionUID = 1L;
    private String aac003;//姓名
    private String aac147;//身份证号码
    private String txgwlb_desc;//工作岗位
    private Timestamp aac007;// 参工时间
    private Integer aae200;// 视同缴费年限
    private Integer aae201;// 实际缴费年限
    private Timestamp aic162;//退休时间
    private String yic010;//是否独生子女
    private boolean flag = true;
    private String errMsg;

    @Override
    public void checkData() {
        if (ValidateUtil.isEmpty(aac003)) {
            throw new AppException("姓名不能为空!");
        }
        if (ValidateUtil.isEmpty(aac147)) {
            throw new AppException("身份证号不能为空!");
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public String getAac147() {
        return aac147;
    }

    public void setAac147(String aac147) {
        this.aac147 = aac147;
    }

    public String getTxgwlb_desc() {
        return txgwlb_desc;
    }

    public void setTxgwlb_desc(String txgwlb_desc) {
        this.txgwlb_desc = txgwlb_desc;
    }

    public Timestamp getAac007() {
        return aac007;
    }

    public void setAac007(Timestamp aac007) {
        this.aac007 = aac007;
    }

    public Integer getAae200() {
        return aae200;
    }

    public void setAae200(Integer aae200) {
        this.aae200 = aae200;
    }

    public Integer getAae201() {
        return aae201;
    }

    public void setAae201(Integer aae201) {
        this.aae201 = aae201;
    }

    public Timestamp getAic162() {
        return aic162;
    }

    public void setAic162(Timestamp aic162) {
        this.aic162 = aic162;
    }

    public String getyic010() {
        return yic010;
    }

    public void setyic010(String yic010) {
        this.yic010 = yic010;
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
        map.put("aac147", this.aac147);
        map.put("txgwlb_desc", this.txgwlb_desc);
        map.put("aac007", this.aac007);
        map.put("aae200", this.aae200);
        map.put("aae201", this.aae201);
        map.put("aic162", this.aic162);
        map.put("yic010", this.yic010);
        map.put("flag", this.flag);
        map.put("errMsg", this.errMsg);
        return map;
    }

}
