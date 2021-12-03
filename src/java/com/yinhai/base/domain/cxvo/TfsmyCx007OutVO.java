package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 个体单据查询
 * @author luomang
 * @date 2020年9月9日
 * @version 1.0
 */
public class TfsmyCx007OutVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TfsmyCx007OutDetailVO> detailList;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TfsmyCx007OutDetailVO> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<TfsmyCx007OutDetailVO> detailList) {
		this.detailList = detailList;
	}
	
    
    
    
	
}
