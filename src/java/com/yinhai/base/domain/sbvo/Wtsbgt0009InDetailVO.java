package com.yinhai.base.domain.sbvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiParamDetailVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 个体撤单
 * 
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtsbgt0009InDetailVO implements CdsiParamDetailVO,Serializable {

	private static final long serialVersionUID = 1L;
	private String aaz288;//单据号

	public String getAaz288() {
		return aaz288;
	}

	public void setAaz288(String aaz288) {
		this.aaz288 = aaz288;
	}

	/**
	 * toMap
	 * 
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aaz288", this.aaz288);
		return map;
	}

	@Override
	public void checkData() {
		if(ValidateUtil.isEmpty(aaz288)) throw new AppException("单据号为空");
	}
}
