package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个体欠缴单据明细信息
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0028OutDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aae140;//险种类型
	private String aae002;//缴费期号
	private String aae116;//缴费金额
	private String aac001;//个人编号
	
	
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


	public String getAae116() {
		return aae116;
	}


	public void setAae116(String aae116) {
		this.aae116 = aae116;
	}


	public Map toMap() {
		Map map = new HashMap();
		map.put("aae140", this.aae140);
		map.put("aae002", this.aae002);
		map.put("aae116", this.aae116);
		map.put("aac001", this.aac001);
		return map;
	}
}
