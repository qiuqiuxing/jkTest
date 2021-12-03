package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 天府市民云养老金帐号及联系方式修改变更信息查询接口
 * 
 * @Author: cx
 * 
 */

public class ChangeInfoVO implements CdsiQueryParamVO, Serializable {
	private static final long serialVersionUID = 1L;
	private String aac001;
	private String aaz002;
	private List<Map> changeInfoList;

	public String getAac001() {
		return aac001;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public String getAaz002() {
		return aaz002;
	}

	public void setAaz002(String aaz002) {
		this.aaz002 = aaz002;
	}

	public List<Map> getChangeInfoList() {
		return changeInfoList;
	}

	public void setChangeInfoList(List<Map> changeInfoList) {
		this.changeInfoList = changeInfoList;
	}
	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("个人编码为空");
		}
		if(ValidateUtil.isEmpty(aaz002)){
			throw new AppException("业务日志id为空");
		}
	}

}
