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
public class Wtcxgr0029OutDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aae140;// 险种类型
	private String aab001;// 单位编码
	private String aab004;// 单位名称
	private String aac001;// 社保编码
	private String aab033;//征缴方式
	private String aac002;// 身份证
	private String aac003;// 姓名
	private String aac031;// 个人参保状态
	private String aac030;// 参保时间
	private String yac033;// 个人初次参保时间
	private String yae097;// 最大做帐期号
	private String yac211;// 人员缴费类别
	private String yac210;// 人员类别
	private String aaz136;// 核定基数规则
	private String yab003;// 经办机构
	private String yac095;//代扣开始期号

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

	public void setYae097(String yae097) {
		this.yae097 = yae097;
	}

	public void setYac211(String yac211) {
		this.yac211 = yac211;
	}

	public void setYab003(String yab003) {
		this.yab003 = yab003;
	}

	public String getAaz136() {
		return aaz136;
	}

	public void setAaz136(String aaz136) {
		this.aaz136 = aaz136;
	}
	public String getAab033() {
		return aab033;
	}

	public void setAab033(String aab033) {
		this.aab033 = aab033;
	}

	public String getYac095() {
		return yac095;
	}

	public void setYac095(String yac095) {
		this.yac095 = yac095;
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
		map.put("yae097", this.yae097);
		map.put("yac211", this.yac211);
		map.put("yac210", this.yac210);
		map.put("yab003", this.yab003);
		map.put("aab033", this.aab033);
		map.put("aaz136", this.aaz136);
		map.put("yac095", this.yac095);
		return map;
	}
}
