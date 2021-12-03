package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *天府市民云查询银行信息
 * 
 * @Author: cx
 * 
 */

public class Wtcxsmy001InVO implements CdsiQueryParamVO, Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 身份证号
	 */
	private String aac002;
	/**
	 * 姓名
	 */
	private String aac003;
	/**
	 * 个人编号
	 */
	private String aac001;
	/**
	 * 查询标志 查询待遇使用社保卡银行信息，默认不传，如果查询公共业务使用社保卡银行信息，传 'ggyw'
	 */
	private String qqbz;
	/**
	 * 银行id
	 */
	private String aaz065;
	/**
	 *联系电话
	 */
	private String aac067;
	/**
	 * 金融机构行号
	 */
	private String aaf002;
	/**
	 * 银行账号
	 */
	private String aae010;
	/**
	 * 返回银行信息
	 */
	private Map resultMap;

	public Wtcxsmy001InVO() {
	}

	public Wtcxsmy001InVO(String aac002, String aac001, String aac003, String qqbz){
		this.aac002 = aac002;
		this.aac001 = aac001;
		this.aac003 = aac003;
		this.qqbz = qqbz;
	}
	public void checkData() {
		if(ValidateUtil.isEmpty(aac002)){
			throw new AppException("身份证不能为空");
		}
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("个人编号不能为空");
		}
		if(ValidateUtil.isEmpty(aac003)){
			throw new AppException("姓名不能为空");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac002", getAac002());
		map.put("aac001", getAac001());
		map.put("aac003", getAac003());
		map.put("qqbz",getQqbz());
		map.put("resultMap", getResultMap());
		return map;
	}

	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public String getAac003() {
		return aac003;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	public String getAac001() {
		return aac001;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public String getQqbz() {
		return qqbz;
	}

	public void setQqbz(String qqbz) {
		this.qqbz = qqbz;
	}

	public String getAaz065() {
		return aaz065;
	}

	public void setAaz065(String aaz065) {
		this.aaz065 = aaz065;
	}

	public String getAac067() {
		return aac067;
	}

	public void setAac067(String aac067) {
		this.aac067 = aac067;
	}

	public String getAaf002() {
		return aaf002;
	}

	public void setAaf002(String aaf002) {
		this.aaf002 = aaf002;
	}

	public String getAae010() {
		return aae010;
	}

	public void setAae010(String aae010) {
		this.aae010 = aae010;
	}

	public Map getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}
}
