package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 企业一般人员参保
 *
 * @Author: xmchen
 */
public class ReturnOutVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String recode;// 成功标志
    private String message;// 成功标志
    private String aaz002;// 日志
    private String aae416;//总复核级次
    private String dangans;//档案字符串

    /**
     * 判断业务是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return "1".equals(recode);
    }

    /**
     * 获取复核总级次
     *
     * @return
     */
    public String getAAE030() {
        return aae416;
    }

    /**
     * 判断业务是否需要复核
     *
     * @return
     */
    public boolean isCheck() {
        return !"0".equals(aae416);
    }

    /**
     * 是否及时办结
     *
     * @return
     */
    public boolean isJSBJ() {
        return isSuccess() && !isCheck();
    }

    public String getAaz002() {
        return aaz002;
    }

    public void setAaz002(String aaz002) {
        this.aaz002 = aaz002;
    }

    public String getRecode() {
        return recode;
    }

    public void setRecode(String recode) {
        this.recode = recode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getAae416() {
        return aae416;
    }

    public void setAae416(String aae416) {
        this.aae416 = aae416;
    }

    public String getDangans() {
        return dangans;
    }

    public void setDangans(String dangans) {
        this.dangans = dangans;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map toMap() {
        Map map = new HashMap();
        map.put("recode", this.recode);
        map.put("aaz002", this.aaz002);
        map.put("message", this.message);
        map.put("aae416", this.aae416);
        map.put("dangans", this.dangans);
        return map;
    }

}
