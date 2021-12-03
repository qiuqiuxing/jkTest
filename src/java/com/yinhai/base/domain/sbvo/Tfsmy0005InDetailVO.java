package com.yinhai.base.domain.sbvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiParamDetailVO;
import com.yinhai.base.util.CommUtil;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 养老金帐号及联系方式修改
 *
 * @Author: xmchen
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Tfsmy0005InDetailVO implements CdsiParamDetailVO,Serializable {

	private static final long serialVersionUID = 1L;

	private String aac001;// 社保编码
	private String aac002;// 身份证号码
	private String aac003;// 姓名
	private String aae008;// 银行帐号
	private String aae010;// 银行名称
	private String yae098;// 联系电话
	private String aae006;// 通信地址
	private String yae222;// EMAIL
	private String yae245;// 固定电话
	private String yae911;// 地区
	private String yae915;// 省
	private String yae916;// 市
	private String yae912;// 区
	private String yae913;// 街道
	private String yae914;// 社区
	private String accountModifyFlag = "0";//银行信息修改标志 0 不修改，1 修改
	private String addressModifyFlag = "0";//地址信息修改标志 0 不修改，1 修改

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getYae098() {
		return yae098;
	}

	public void setYae098(String yae098) {
		this.yae098 = yae098;
	}

	public String getYae245() {
		return yae245;
	}

	public void setYae245(String yae245) {
		this.yae245 = yae245;
	}

	public String getAac001() {
		return aac001;
	}

	public String getAac002() {
		return aac002;
	}

	public String getAac003() {
		return aac003;
	}

	public String getAae008() {
		return aae008;
	}

	public String getAae010() {
		return aae010;
	}

	

	public String getAae006() {
		return aae006;
	}

	public String getYae222() {
		return yae222;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	public void setAae008(String aae008) {
		this.aae008 = aae008;
	}

	public void setAae010(String aae010) {
		this.aae010 = aae010;
	}

	
	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}

	public void setYae222(String yae222) {
		this.yae222 = yae222;
	}

	public String getYae911() {
		return yae911;
	}

	public void setYae911(String yae911) {
		this.yae911 = yae911;
	}

	public String getYae915() {
		return yae915;
	}

	public void setYae915(String yae915) {
		this.yae915 = yae915;
	}

	public String getYae916() {
		return yae916;
	}

	public void setYae916(String yae916) {
		this.yae916 = yae916;
	}

	public String getYae912() {
		return yae912;
	}

	public void setYae912(String yae912) {
		this.yae912 = yae912;
	}

	public String getYae913() {
		return yae913;
	}

	public void setYae913(String yae913) {
		this.yae913 = yae913;
	}

	public String getYae914() {
		return yae914;
	}

	public void setYae914(String yae914) {
		this.yae914 = yae914;
	}

	public String getAccountModifyFlag() {
		return accountModifyFlag;
	}

	public void setAccountModifyFlag(String accountModifyFlag) {
		this.accountModifyFlag = accountModifyFlag;
	}

	public String getAddressModifyFlag() {
		return addressModifyFlag;
	}

	public void setAddressModifyFlag(String addressModifyFlag) {
		this.addressModifyFlag = addressModifyFlag;
	}

	/**
	 * toMap
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac001", this.aac001);
		map.put("aac002", this.aac002);
		map.put("aac003", this.aac003);
		map.put("aae008", this.aae008);
		map.put("aae010", this.aae010);
		map.put("yae098", this.yae098);
		map.put("aae006", this.aae006);
		map.put("yae222", this.yae222);
		map.put("yae245", this.yae245);
		map.put("yae911", this.yae911);
		map.put("yae915", this.yae915);
		map.put("yae916", this.yae916);
		map.put("yae912", this.yae912);
		map.put("yae913", this.yae913);
		map.put("yae914", this.yae914);
		map.put("accountModifyFlag", this.accountModifyFlag);
		map.put("addressModifyFlag", this.addressModifyFlag);
		return map;
	}

	@Override
	public void checkData() {
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("人员编号为空！");
		}
		if(ValidateUtil.isNotEmpty(yae098) && !CommUtil.isTelePhone(yae098)){
			throw new AppException("移动电话格式错误！");
		}
		if(ValidateUtil.isNotEmpty(yae222) && !ValidateUtil.isEmail(yae222)){
			throw new AppException("电子邮箱格式错误！");
		}

	}
}