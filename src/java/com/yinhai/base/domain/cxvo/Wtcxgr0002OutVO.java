package com.yinhai.base.domain.cxvo;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * 查询个人参保信息输出VO
 * @Author: xmchen
 */
public class Wtcxgr0002OutVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Wtcxgr0002OutDetailVO> detailVOList;
	public List<Wtcxgr0002OutDetailVO> getDetailVOList() {
		return detailVOList;
	}
	public void setDetailVOList(List<Wtcxgr0002OutDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}