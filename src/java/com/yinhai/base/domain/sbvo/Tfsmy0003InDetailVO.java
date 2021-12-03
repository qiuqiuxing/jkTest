package com.yinhai.base.domain.sbvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiParamDetailVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 人员新参保、续保
 * @author luomang
 * @date 2020年6月29日
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Tfsmy0003InDetailVO implements CdsiParamDetailVO,Serializable {

	private static final long serialVersionUID = 1L;
	private String aac001;//个人编号
	private String aaz136;// 档次

	/**
	 * toMap
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001",this.aac001);//个人编号
		map.put("aaz136",this.aaz136);//姓名  
		return map;
	}
	
	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("人员编号为空！");
		}
		if(ValidateUtil.isEmpty(aaz136)){
			throw new AppException("养老保险档次为空！");
		}
	}

	public String getAac001() {
		return aac001;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public String getAaz136() {
		return aaz136;
	}

	public void setAaz136(String aaz136) {
		this.aaz136 = aaz136;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
