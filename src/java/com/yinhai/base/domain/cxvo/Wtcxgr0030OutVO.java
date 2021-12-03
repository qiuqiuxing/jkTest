package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 查询个人参保信息输出VO
 */
public class Wtcxgr0030OutVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Wtcxgr0030OutDetailVO> detailVOList;
	private boolean flag;
	private String errMsg;

	public List<Wtcxgr0030OutDetailVO> getDetailVOList() {
		return detailVOList;
	}
	public void setDetailVOList(List<Wtcxgr0030OutDetailVO> detailVOList) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}