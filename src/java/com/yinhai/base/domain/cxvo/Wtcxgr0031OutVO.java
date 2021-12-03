package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 人员银行账户信息
 * @Author: xmchen
 */
public class Wtcxgr0031OutVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Wtcxgr0031OutDetailVO> detailVOList;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Wtcxgr0031OutDetailVO> getDetailVOList() {
		return detailVOList;
	}

	public void setDetailVOList(List<Wtcxgr0031OutDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
	}

	
}