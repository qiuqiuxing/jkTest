package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询养老待遇发放信息输出VO
 *
 * @Author:
 */
public class Wtcxgr0015OutDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String aae008;// 银行名称
    private String aae116;// 待遇发放状态
    private String aae160_zt;// 待遇发放暂停原因
    private String aae010;// 银行帐号
    private String yae098;// 移动电话
    private String yae245;// 固定电话
    private String aae006;// 通信地址
    private String aac001;// 个人编码
    private String aac002;// 身份证号码
    private String aac003;// 姓名
    private String yac214;// 人员身份
    private String aae140;// 险种
    private String yae222;//EMAIL


    public String getAae160_zt() {
        return aae160_zt;
    }

    public void setAae160_zt(String aae160_zt) {
        this.aae160_zt = aae160_zt;
    }

    public String getYae098() {
        return yae098;
    }

    public void setYae098(String yae098) {
        this.yae098 = yae098;
    }

    public String getYae245() {
        return yae245;
    }

    public void setYae245(String yae245) {
        this.yae245 = yae245;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("aae008", this.aae008);
        map.put("aae116", this.aae116);
        map.put("aae010", this.aae010);
        map.put("yae098", this.yae098);
        map.put("yae245", this.yae245);
        map.put("aae006", this.aae006);
        map.put("aac001", this.aac001);
        map.put("aac002", this.aac002);
        map.put("aac003", this.aac003);
        map.put("yac214", this.yac214);
        map.put("aae140", this.aae140);
        map.put("yae222", this.yae222);
        return map;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getYae222() {
        return yae222;
    }

    public void setYae222(String yae222) {
        this.yae222 = yae222;
    }

    public String getAae008() {
        return aae008;
    }

    public void setAae008(String aae008) {
        this.aae008 = aae008;
    }

    public String getAae116() {
        return aae116;
    }

    public void setAae116(String aae116) {
        this.aae116 = aae116;
    }

    public String getAae010() {
        return aae010;
    }

    public void setAae010(String aae010) {
        this.aae010 = aae010;
    }


    public String getAae006() {
        return aae006;
    }

    public void setAae006(String aae006) {
        this.aae006 = aae006;
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

    public String getYac214() {
        return yac214;
    }

    public void setYac214(String yac214) {
        this.yac214 = yac214;
    }

    public String getAae140() {
        return aae140;
    }

    public void setAae140(String aae140) {
        this.aae140 = aae140;
    }

}
