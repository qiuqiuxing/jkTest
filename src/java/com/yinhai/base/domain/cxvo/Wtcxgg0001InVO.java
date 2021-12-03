package com.yinhai.base.domain.cxvo;


import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询码表输入Vo
 * 
 *
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgg0001InVO implements CdsiQueryParamVO, Serializable {

	private static final long serialVersionUID = 1L;

	private String aaa100;

	public String getAaa100() {
		return aaa100;
	}

	public void setAaa100(String aaa100) {
		this.aaa100 = aaa100;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * toMap
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aaa100", this.aaa100);
		return map;
	}
	
	public void checkData(){
		if(aaa100 == null){
			throw new AppException("码表名不能为空!");
		}
		aaa100 = aaa100.toUpperCase();
	}

}
