package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;

/**
 * 受理查询结果信息
 * @author luomang
 * @date 2020年7月23日
 * @version 1.0
 */
public class TfsmyCx004OutVO  implements Serializable {

	private static final long serialVersionUID = 7599841753631932566L;
	private List<TfsmyCx004_1OutDetailVO> tfsmyCx004_1OutDetailVOs; //人员基本信息变更
	private List<TfsmyCx004_2OutDetailVO> tfsmyCx004_2OutDetailVOs; //参保信息变更
	private List<TfsmyCx004_3OutDetailVO> tfsmyCx004_3OutDetailVOs; //缴费信息变更
	
	public List<TfsmyCx004_1OutDetailVO> getTfsmyCx004_1OutDetailVOs() {
		return tfsmyCx004_1OutDetailVOs;
	}
	public void setTfsmyCx004_1OutDetailVOs(List<TfsmyCx004_1OutDetailVO> tfsmyCx004_1OutDetailVOs) {
		this.tfsmyCx004_1OutDetailVOs = tfsmyCx004_1OutDetailVOs;
	}
	public List<TfsmyCx004_2OutDetailVO> getTfsmyCx004_2OutDetailVOs() {
		return tfsmyCx004_2OutDetailVOs;
	}
	public void setTfsmyCx004_2OutDetailVOs(List<TfsmyCx004_2OutDetailVO> tfsmyCx004_2OutDetailVOs) {
		this.tfsmyCx004_2OutDetailVOs = tfsmyCx004_2OutDetailVOs;
	}
	public List<TfsmyCx004_3OutDetailVO> getTfsmyCx004_3OutDetailVOs() {
		return tfsmyCx004_3OutDetailVOs;
	}
	public void setTfsmyCx004_3OutDetailVOs(List<TfsmyCx004_3OutDetailVO> tfsmyCx004_3OutDetailVOs) {
		this.tfsmyCx004_3OutDetailVOs = tfsmyCx004_3OutDetailVOs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
