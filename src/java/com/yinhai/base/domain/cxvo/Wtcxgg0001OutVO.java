package com.yinhai.base.domain.cxvo;

import com.yinhai.base.domain.CdsiQueryReturnVO;

import java.io.Serializable;
import java.util.List;

/**
 * 查询码表输出VOList
 *
 */

public class Wtcxgg0001OutVO implements CdsiQueryReturnVO,Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Wtcxgg0001OutDetailVO> detailVOList; //码表

	public List<Wtcxgg0001OutDetailVO> getDetailVOList() {
		return detailVOList;
	}

	public void setDetailVOList(List<Wtcxgg0001OutDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
