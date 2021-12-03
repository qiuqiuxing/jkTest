package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个体欠缴单据明细信息
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0028InVO implements CdsiQueryParamVO,Serializable {

	private static final long serialVersionUID = 1L;

	private String aae076; //业务流水号
	private String aac001; //个人编码
	private boolean flag= true;
	private String errMsg;


	public String getAac001() {
		return aac001;
	}


	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}


	public String getAae076() {
		return aae076;
	}


	public void setAae076(String aae076) {
		this.aae076 = aae076;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public String getErrMsg() {
		return errMsg;
	}


	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


	/**
	 * toMap
	 * 
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001", this.aac001);
		map.put("aae076", this.aae076);
		map.put("flag", this.flag);
		map.put("errMsg", this.errMsg);
		return map;
	}

	public void checkData() {
		if(ValidateUtil.isEmpty(aae076)){
			throw new AppException("单据号不能为空!");
		}
	}

}
