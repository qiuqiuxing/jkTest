package com.yinhai.base.domain.cxvo;


import java.io.Serializable;
import java.util.List;

/**
 * 查询个人基本信息输出VO
 *
 * @Author: xmchen
 */
public class Wtcxgr0001OutVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Wtcxgr0001OutDetailVO> detailVOList;
	public List<Wtcxgr0001OutDetailVO> getDetailVOList() {
		return detailVOList;
	}
	public void setDetailVOList(List<Wtcxgr0001OutDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}