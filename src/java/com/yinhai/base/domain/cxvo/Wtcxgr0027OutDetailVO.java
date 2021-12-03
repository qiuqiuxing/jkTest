package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询个体欠缴单据信息
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Wtcxgr0027OutDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aaz288;//单据编号
	private String djlx;  //单据类型
	private String yad112;//收付方式
	private String yad182;//单据所属期
	private String aaa039;//收支类型
	private String yad001;//应处理金额
	private String yad005;//业务处理标志
	private String yad006;//财务处理标志
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAaz288() {
		return aaz288;
	}

	public void setAaz288(String aaz288) {
		this.aaz288 = aaz288;
	}

	public String getDjlx() {
		return djlx;
	}

	public void setDjlx(String djlx) {
		this.djlx = djlx;
	}

	public String getYad112() {
		return yad112;
	}


	public void setYad112(String yad112) {
		this.yad112 = yad112;
	}


	public String getYad182() {
		return yad182;
	}


	public void setYad182(String yad182) {
		this.yad182 = yad182;
	}


	public String getAaa039() {
		return aaa039;
	}


	public void setAaa039(String aaa039) {
		this.aaa039 = aaa039;
	}

	public String getYad001() {
		return yad001;
	}

	public void setYad001(String yad001) {
		this.yad001 = yad001;
	}

	public String getYad005() {
		return yad005;
	}

	public void setYad005(String yad005) {
		this.yad005 = yad005;
	}

	public String getYad006() {
		return yad006;
	}

	public void setYad006(String yad006) {
		this.yad006 = yad006;
	}

	public Map toMap() {
		Map map = new HashMap();
		map.put("aaz288", this.aaz288);
		map.put("djlx", this.djlx);
		map.put("yad112", this.yad112);
		map.put("yad182", this.yad182);
		map.put("aaa039", this.aaa039);
		map.put("yad001", this.yad001);
		map.put("yad005", this.yad005);
		map.put("yad006", this.yad006);
		return map;
	}
}
