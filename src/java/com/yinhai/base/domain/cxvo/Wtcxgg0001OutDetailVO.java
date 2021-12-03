package com.yinhai.base.domain.cxvo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询码表输出VO
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgg0001OutDetailVO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String aaa102;  //键值
	private String aaa103;  //码值
	
	
	/**
	 * toMap
	 * 
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("id", this.aaa102);
		map.put("name", this.aaa103);
		return map;
	}


	public String getAaa102() {
		return aaa102;
	}



	public void setAaa102(String aaa102) {
		this.aaa102 = aaa102;
	}



	public String getAaa103() {
		return aaa103;
	}


	public void setAaa103(String aaa103) {
		this.aaa103 = aaa103;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
