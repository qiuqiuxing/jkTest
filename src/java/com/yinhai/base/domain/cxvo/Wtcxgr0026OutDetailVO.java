package com.yinhai.base.domain.cxvo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 个体正常缴费查询
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0026OutDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aac001;//个人编号
	private String aae140;//缴费险种
	private String aae002;//缴费期号
	private String aic020;//缴费基数
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getAac001() {
		return aac001;
	}


	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}


	public String getAae140() {
		return aae140;
	}


	public void setAae140(String aae140) {
		this.aae140 = aae140;
	}


	public String getAae002() {
		return aae002;
	}


	public void setAae002(String aae002) {
		this.aae002 = aae002;
	}


	public String getAic020() {
		return aic020;
	}


	public void setAic020(String aic020) {
		this.aic020 = aic020;
	}


	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001", this.aac001);
		map.put("aae140", this.aae140);
		map.put("aae002", this.aae002);
		map.put("aic020", this.aic020);
		return map;
	}
}
