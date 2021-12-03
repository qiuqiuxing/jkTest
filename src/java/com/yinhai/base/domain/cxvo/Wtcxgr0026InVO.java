package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 个体正常缴费查询
 *
 * @Author: xmchen
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Wtcxgr0026InVO implements CdsiQueryParamVO, Serializable {

	private static final long serialVersionUID = 1L;

	private String aac001; // 单位编码
	private String aae041; // 开始年份
	private String aae042; // 结束年份
	private String jfdc;   // 缴费档次


	public String getAac001() {
		return aac001;
	}


	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}


	public String getAae041() {
		return aae041;
	}


	public String getJfdc() {
		return jfdc;
	}


	public void setJfdc(String jfdc) {
		this.jfdc = jfdc;
	}


	public String getAae042() {
		return aae042;
	}


	public void setAae042(String aae042) {
		this.aae042 = aae042;
	}


	public void setAae041(String aae041) {
		this.aae041 = aae041;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * toMap
	 *
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001", this.aac001);
		map.put("aae041", this.aae041);
		map.put("aae042", this.aae042);
		map.put("jfdc", this.jfdc);
		return map;
	}

	public void checkData() {
		if (ValidateUtil.isEmpty(aac001)) {
			throw new AppException("个人编号不能为空!");
		}
		if (ValidateUtil.isEmpty(aae041)) {
			throw new AppException("开始期号不能为空!");
		}
		if (ValidateUtil.isEmpty(aae042)) {
			throw new AppException("开始期号不能为空!");
		}
	}

}
