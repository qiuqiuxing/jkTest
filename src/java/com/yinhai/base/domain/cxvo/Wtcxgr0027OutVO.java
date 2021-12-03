package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 查询个体欠缴单据信息
 * @Author: xmchen
 */
public class Wtcxgr0027OutVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Wtcxgr0027OutDetailVO> detailVOList;
	private boolean flag;
	private String errMsg;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Wtcxgr0027OutDetailVO> getDetailVOList() {
		return detailVOList;
	}

	public void setDetailVOList(List<Wtcxgr0027OutDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
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
	
}