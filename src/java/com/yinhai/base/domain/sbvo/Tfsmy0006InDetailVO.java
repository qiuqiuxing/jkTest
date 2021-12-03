package com.yinhai.base.domain.sbvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiParamDetailVO;
import com.yinhai.base.util.Constant;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 个体缴费
 * @author luomang
 * @date 2020年7月23日
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Tfsmy0006InDetailVO implements CdsiParamDetailVO,Serializable {

	private static final long serialVersionUID = 1L;
	private String aac001;//个人编号
	
	private String aae041;// 开始期号
	private String aae042;// 结束期号
	private String aae140;// 缴费险种串
	private String paytype;// 缴费档次
	
	private String aab033;//缴费方式 20200826新增，可以选择经办机构自收
	 
	private String aae010;//银行账号
	private String aaz003;//当事人银行账号ID
	//20200901 新增
	private String dkyh;//代扣方式 ：shbzk 社保卡，dyyh 银行托收
	private String aaz065;//银行类别
	
	/**
	 * toMap
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001",this.aac001);//个人编号
		map.put("aae041",this.aae041);//开始期号
		map.put("aae042",this.aae042);//结束期号
		map.put("aae140",this.aae140);//缴费险种串
		map.put("paytype",this.paytype);//缴费档次
		
		map.put("aab033",this.aab033);//缴费方式
		
		map.put("aae010",this.aae010);//银行账号
		map.put("aaz003",this.aaz003);//当事人银行账号ID
		
		map.put("dkyh",this.dkyh);//代扣方式 ：shbzk 社保卡，dyyh 银行托收
		map.put("aaz065",this.aaz065);//银行类别
		return map;
	}
	
	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("人员编号为空！");
		}
		if(ValidateUtil.isEmpty(aae041)){
			throw new AppException("缴费开始期号为空！");
		}
		if(ValidateUtil.isEmpty(aae042)){
			throw new AppException("缴费结束期号为空！");
		}
		if(ValidateUtil.isEmpty(aae140)){
			throw new AppException("缴费险种为空！");
		}
		if(aae140.contains(Constant.AAE140_110) && ValidateUtil.isEmpty(paytype)){
			throw new AppException("缴费档次为空！");
		}
		if(ValidateUtil.isEmpty(aab033)){
			throw new AppException("缴费方式为空！");
		}else if("1".equals(aab033)){
			if(ValidateUtil.isEmpty(aae010)){
				throw new AppException("银行账号为空！");
			}
			if(ValidateUtil.isEmpty(aaz003)){//为空表示需要新增银行
				if(ValidateUtil.isEmpty(dkyh)){
					throw new AppException("代扣方式为空！");
				}
				if(ValidateUtil.isEmpty(aaz065)){
					throw new AppException("银行类别为空！");
				}
			}
		}
	}

	public String getAac001() {
		return aac001;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public String getAae041() {
		return aae041;
	}

	public void setAae041(String aae041) {
		this.aae041 = aae041;
	}

	public String getAae042() {
		return aae042;
	}

	public void setAae042(String aae042) {
		this.aae042 = aae042;
	}

	public String getAae140() {
		return aae140;
	}

	public void setAae140(String aae140) {
		this.aae140 = aae140;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getAae010() {
		return aae010;
	}

	public void setAae010(String aae010) {
		this.aae010 = aae010;
	}

	public String getAaz003() {
		return aaz003;
	}

	public void setAaz003(String aaz003) {
		this.aaz003 = aaz003;
	}

	public String getAab033() {
		return aab033;
	}

	public void setAab033(String aab033) {
		this.aab033 = aab033;
	}

	public String getDkyh() {
		return dkyh;
	}

	public void setDkyh(String dkyh) {
		this.dkyh = dkyh;
	}

	public String getAaz065() {
		return aaz065;
	}

	public void setAaz065(String aaz065) {
		this.aaz065 = aaz065;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
