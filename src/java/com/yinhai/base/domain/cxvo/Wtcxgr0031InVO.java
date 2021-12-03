package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 人员银行账户信息
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0031InVO implements CdsiQueryParamVO, Serializable {

	private static final long serialVersionUID = 1L;

	private String aac001; // 个人编号

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getAac001() {
		return aac001;
	}


	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}


	/**
	 * toMap
	 * 
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001", this.aac001);
		return map;
	}

	public void checkData() {
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("个人编号不能为空!");
		}
	}
}
