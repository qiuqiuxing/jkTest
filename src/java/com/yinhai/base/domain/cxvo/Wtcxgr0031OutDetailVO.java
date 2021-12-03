package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 人员银行账户信息
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0031OutDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aaz003;//单据编号
	private String aac001;//收付方式
	private String aaz065;//单据所属期
	private String aae009;//收支类型
	private String aae010;//应处理金额
	private String yab003;//业务处理标志
	private String aae100;//财务处理标志
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public String getAaz003() {
		return aaz003;
	}


	public void setAaz003(String aaz003) {
		this.aaz003 = aaz003;
	}


	public String getAac001() {
		return aac001;
	}


	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}


	public String getAaz065() {
		return aaz065;
	}


	public void setAaz065(String aaz065) {
		this.aaz065 = aaz065;
	}


	public String getAae009() {
		return aae009;
	}


	public void setAae009(String aae009) {
		this.aae009 = aae009;
	}


	public String getAae010() {
		return aae010;
	}


	public void setAae010(String aae010) {
		this.aae010 = aae010;
	}


	public String getYab003() {
		return yab003;
	}


	public void setYab003(String yab003) {
		this.yab003 = yab003;
	}


	public String getAae100() {
		return aae100;
	}


	public void setAae100(String aae100) {
		this.aae100 = aae100;
	}


	public Map toMap() {
		Map map = new HashMap();
		map.put("aaz003", this.aaz003);
		map.put("aac001", this.aac001);
		map.put("aaz065", this.aaz065);
		map.put("aae009", this.aae009);
		map.put("aae010", this.aae010);
		map.put("yab003", this.yab003);
		map.put("aae100", this.aae100);
		return map;
	}
}
