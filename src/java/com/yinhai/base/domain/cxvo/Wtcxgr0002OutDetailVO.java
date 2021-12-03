package com.yinhai.base.domain.cxvo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个人基本信息输出VO
 * 
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0002OutDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aae140;// 险种类型
	private String aab001;// 单位编码
	private String aab004;// 单位名称
	private String aac001;// 社保编码
	private String aac002;// 身份证
	private String aac003;// 姓名
	private String aac031;// 个人参保状态
	private String aac030;// 参保时间
	private String yac033;// 个人初次参保时间
	private String yac004;// 缴费基数
	private String aac040;// 缴费工资
	private String yae097;// 最大做帐期号
	private String yac211;// 人员缴费类别
	private String yac210;// 人员类别
	private String yab003;// 经办机构
	private String ync003;// 农保人员类别
	private String aac050;// 人员变更类型
	private String aae035;// 变更日期
	private String aaz136;// 档次
	private String yac084;// 退休标志
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAae140() {
		return aae140;
	}

	public String getYac210() {
		return yac210;
	}

	public void setYac210(String yac210) {
		this.yac210 = yac210;
	}

	public String getAab001() {
		return aab001;
	}

	public String getAab004() {
		return aab004;
	}

	public String getAac001() {
		return aac001;
	}

	public String getAac002() {
		return aac002;
	}

	public String getAac003() {
		return aac003;
	}

	public String getAac031() {
		return aac031;
	}

	public String getAac030() {
		return aac030;
	}

	public String getYac033() {
		return yac033;
	}

	public String getYac004() {
		return yac004;
	}

	public String getAac040() {
		return aac040;
	}

	public String getYae097() {
		return yae097;
	}

	public String getYac211() {
		return yac211;
	}

	public String getYab003() {
		return yab003;
	}

	public void setAae140(String aae140) {
		this.aae140 = aae140;
	}

	public void setAab001(String aab001) {
		this.aab001 = aab001;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	public void setAac031(String aac031) {
		this.aac031 = aac031;
	}

	public void setAac030(String aac030) {
		this.aac030 = aac030;
	}

	public void setYac033(String yac033) {
		this.yac033 = yac033;
	}

	public void setYac004(String yac004) {
		this.yac004 = yac004;
	}

	public void setAac040(String aac040) {
		this.aac040 = aac040;
	}

	public void setYae097(String yae097) {
		this.yae097 = yae097;
	}

	public void setYac211(String yac211) {
		this.yac211 = yac211;
	}

	public void setYab003(String yab003) {
		this.yab003 = yab003;
	}
	
	public String getYnc003() {
		return ync003;
	}

	public void setYnc003(String ync003) {
		this.ync003 = ync003;
	}

	public String getAac050() {
		return aac050;
	}

	public void setAac050(String aac050) {
		this.aac050 = aac050;
	}

	public String getAae035() {
		return aae035;
	}

	public void setAae035(String aae035) {
		this.aae035 = aae035;
	}

	public String getAaz136() {
		return aaz136;
	}

	public void setAaz136(String aaz136) {
		this.aaz136 = aaz136;
	}

	public String getYac084() {
		return yac084;
	}

	public void setYac084(String yac084) {
		this.yac084 = yac084;
	}

	public Map toMap() {
		Map map = new HashMap();
		map.put("aae140", this.aae140);
		map.put("aab001", this.aab001);
		map.put("aab004", this.aab004);
		map.put("aac001", this.aac001);
		map.put("aac002", this.aac002);
		map.put("aac003", this.aac003);
		map.put("aac031", this.aac031);
		map.put("aac030", this.aac030);
		map.put("yac033", this.yac033);
		map.put("yac004", this.yac004);
		map.put("aac040", this.aac040);
		map.put("yae097", this.yae097);
		map.put("yac211", this.yac211);
		map.put("yac210", this.yac210);
		map.put("yab003", this.yab003);
		map.put("ync003", this.ync003);
		map.put("aac050", this.aac050);
		map.put("aae035", this.aae035);
		map.put("aaz136", this.aaz136);
		map.put("yac084", this.yac084);
		return map;
	}
}
