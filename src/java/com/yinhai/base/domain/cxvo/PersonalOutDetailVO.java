package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个人基本信息输出VO
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PersonalOutDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Timestamp  aac007;// 参工时间
	private Integer treatAs;// 视同缴费年限
	private Integer  actual;// 实际缴费年限

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Timestamp getAac007() {
		return aac007;
	}

	public void setAac007(Timestamp aac007) {
		this.aac007 = aac007;
	}

	public Integer getTreatAs() {
		return treatAs;
	}

	public void setTreatAs(Integer treatAs) {
		this.treatAs = treatAs;
	}

	public Integer getActual() {
		return actual;
	}

	public void setActual(Integer actual) {
		this.actual = actual;
	}

	public Map toMap() {
		Map map = new HashMap();
		map.put("aac007", this.aac007);
		map.put("treatAs", this.treatAs);
		map.put("actual", this.actual);
		return map;
	}
}
