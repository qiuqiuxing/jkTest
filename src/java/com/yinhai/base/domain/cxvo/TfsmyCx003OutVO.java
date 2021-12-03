package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 受理查询结果信息
 * @author luomang
 * @date 2020年7月21日
 * @version 1.0
 */
public class TfsmyCx003OutVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TfsmyCx003OutDetailVO> detailList;
	private Integer total;//总条数

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<TfsmyCx003OutDetailVO> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TfsmyCx003OutDetailVO> detailList) {
		this.detailList = detailList;
	}
    
    
    
	
}
