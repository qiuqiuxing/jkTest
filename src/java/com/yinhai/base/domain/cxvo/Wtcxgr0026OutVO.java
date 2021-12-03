package com.yinhai.base.domain.cxvo;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * 个体正常缴费查询
 * @Author: xmchen
 */
public class Wtcxgr0026OutVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Wtcxgr0026OutDetailVO> detailVOList;
	private boolean flag;
	private String errMsg;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Wtcxgr0026OutDetailVO> getDetailVOList() {
		return detailVOList;
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

	public void setDetailVOList(List<Wtcxgr0026OutDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
	}
	
}