package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 核定信息查询
 * @author luomang
 * @date 2020年8月26日
 * @version 1.0
 */
public class TfsmyCx006OutVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TfsmyCx006OutDetailVO> detailList;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<TfsmyCx006OutDetailVO> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TfsmyCx006OutDetailVO> detailList) {
		this.detailList = detailList;
	}
    
    
    
	
}
