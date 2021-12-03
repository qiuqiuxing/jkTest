package com.yinhai.base.domain;

import java.io.Serializable;


public class CdsiReturnVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String recode;// 成功标志
	private String message;//提示信息
	private String aaz002;// 日志
	
	/**
	 * 判断业务是否成功
	 * @return
	 */
	public boolean isSuccess(){
		return "1".equals(recode);
	}

	public String getRecode() {
		return recode;
	}

	public void setRecode(String recode) {
		this.recode = recode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAaz002() {
		return aaz002;
	}

	public void setAaz002(String aaz002) {
		this.aaz002 = aaz002;
	}
}
