package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *天府市民云查询联系信息（养老）
 * 
 * @Author: cx
 * 
 */

public class Wtcxsmy002InVO implements CdsiQueryParamVO,Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 身份证号
	 */
	private String aac002;
	/**
	 * 姓名
	 */
	private String aac003;
	/**
	 * 个人编号
	 */
	private String aac001;

	/**
	 * 返回联系信息
	 */
	private Map resultMap;

	public void checkData() {
		if(ValidateUtil.isEmpty(aac002)){
			throw new AppException("身份证不能为空");
		}
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("个人编号不能为空");
		}
		if(ValidateUtil.isEmpty(aac003)){
			throw new AppException("姓名不能为空");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac002", getAac002());
		map.put("aac001", getAac001());
		map.put("aac003", getAac003());
 		return map;
	}

	public String getAac002() {
		return aac002;
	}

	public String getAac003() {
		return aac003;
	}

	public String getAac001() {
		return aac001;
	}

	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}

	public Map getResultMap() {
		return resultMap;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

 }
