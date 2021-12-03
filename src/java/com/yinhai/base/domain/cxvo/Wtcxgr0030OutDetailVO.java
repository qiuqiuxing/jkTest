package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个人基本信息输出VO
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0030OutDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;// 征缴规则ID
	private String name;// 征缴规则名称
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map toMap() {
		Map map = new HashMap();
		map.put("id", this.id);
		map.put("name", this.name);
		return map;
	}
}
