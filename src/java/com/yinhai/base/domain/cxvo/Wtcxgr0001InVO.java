package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 查询个人基本信息输入VO
 * 
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0001InVO implements CdsiQueryParamVO, Serializable {

	private static final long serialVersionUID = 1L;

	private String aac001;
	
	private String aac002;
	
	private String aac147;

	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)&&ValidateUtil.isEmpty(aac002)&&ValidateUtil.isEmpty(aac147)){
			throw new AppException("个人编号和身份证号不能同时为空！");
		}
	}
	
	public String getAac001() {
		return aac001;
	}

	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public String getAac147() {
		return aac147;
	}

	public void setAac147(String aac147) {
		this.aac147 = aac147;
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
		map.put("aac002", this.aac002);
		map.put("aac147", this.aac147);
		return map;
	}

}
