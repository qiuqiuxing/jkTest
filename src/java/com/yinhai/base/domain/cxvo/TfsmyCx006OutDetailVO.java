package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 核定明细信息
 * @author luomang
 * @date 2020年8月26日
 * @version 1.0
 */
public class TfsmyCx006OutDetailVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aac001;//个人编号
	private String aae140;//险种
	private Integer aae003;//期号
	private BigDecimal yad001;//应缴金额
	private String aaz288;//单据
	
	public String getAac001() {
		return aac001;
	}
	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}
	public String getAae140() {
		return aae140;
	}
	public void setAae140(String aae140) {
		this.aae140 = aae140;
	}
	public Integer getAae003() {
		return aae003;
	}
	public void setAae003(Integer aae003) {
		this.aae003 = aae003;
	}
	public BigDecimal getYad001() {
		return yad001;
	}
	public void setYad001(BigDecimal yad001) {
		this.yad001 = yad001;
	}
	public String getAaz288() {
		return aaz288;
	}
	public void setAaz288(String aaz288) {
		this.aaz288 = aaz288;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
