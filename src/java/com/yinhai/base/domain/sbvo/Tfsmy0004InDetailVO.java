package com.yinhai.base.domain.sbvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiParamDetailVO;
import com.yinhai.base.util.CommUtil;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 人员信息变更
 * @author luomang
 * @date 2020年6月29日
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Tfsmy0004InDetailVO implements CdsiParamDetailVO, Serializable {

	private static final long serialVersionUID = 1L;
	private String aac001;//个人编号
	private String aab033;//缴费方式
	private String dkyh  ;//代扣银行 ：shbzk 社保卡，dyyh 银行托收
	
	private String aae010;//银行账号
	private String aae009;//银行户名
	private String aaz065;//银行类别
	private String aaz003;//当事人银行账号ID 银行托收时，如果没有aaz003，则会新增银行信息
	
	private String yae107;//移动电话
	private String aae006;//联系地址

    

	
	/**
	 * toMap
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001",this.aac001);//个人编号
		map.put("aab033",this.aab033);//缴费方式
		map.put("dkyh",this.dkyh);//缴费方式
		map.put("aae010",this.aae010);//银行账号
		map.put("aae009",this.aae009);//银行户名
		map.put("aaz065",this.aaz065);//银行类别
		map.put("aaz003",this.aaz003);//当事人银行账号ID
		map.put("yae107",this.yae107);//移动电话
		map.put("aae006",this.aae006);//联系地址
		return map;
	}
	
	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("人员编号为空！");
		}
        if(ValidateUtil.isNotEmpty(yae107) && !CommUtil.isTelePhone(yae107)){
            throw new AppException("联系电话格式错误！");
        }
		if(ValidateUtil.isNotEmpty(aab033) && "1".equals(aab033)){
			if(ValidateUtil.isEmpty(dkyh)){
				throw new AppException("代扣类别为空！");
			}
			if(ValidateUtil.isEmpty(aaz065)){
				throw new AppException("银行类别为空！");
			}
			if(ValidateUtil.isEmpty(aae010)){
				throw new AppException("银行账号为空！");
			}
			if(ValidateUtil.isEmpty(aae009)){
				throw new AppException("银行户名为空！");
			}
		}
	}

	public String getAac001() {
		return aac001;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public String getAab033() {
		return aab033;
	}

	public void setAab033(String aab033) {
		this.aab033 = aab033;
	}

	public String getAae010() {
		return aae010;
	}

	public void setAae010(String aae010) {
		this.aae010 = aae010;
	}

	public String getAae009() {
		return aae009;
	}

	public void setAae009(String aae009) {
		this.aae009 = aae009;
	}

	public String getAaz065() {
		return aaz065;
	}

	public void setAaz065(String aaz065) {
		this.aaz065 = aaz065;
	}

	public String getAaz003() {
		return aaz003;
	}

	public void setAaz003(String aaz003) {
		this.aaz003 = aaz003;
	}

	public String getYae107() {
		return yae107;
	}

	public void setYae107(String yae107) {
		this.yae107 = yae107;
	}

	public String getAae006() {
		return aae006;
	}

	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDkyh() {
		return dkyh;
	}

	public void setDkyh(String dkyh) {
		this.dkyh = dkyh;
	}
}
