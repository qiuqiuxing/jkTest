package com.yinhai.base.domain.sbvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiParamDetailVO;
import com.yinhai.base.util.CommUtil;
import com.yinhai.base.util.Constant;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 人员新参保、续保
 * @author luomang
 * @date 2020年6月29日
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Tfsmy0001InDetailVO implements CdsiParamDetailVO, Serializable {

	private static final long serialVersionUID = 1L;
	private String aac147;//身份证号
	private String aac001;//个人编号 (存在个人编号，就是续保)
	private String aae006;//联系地址
	private String yae107;//移动电话
	private String aac004;//性别
	private String aac006;//出生年月  格式：yyyyMMdd
    private String aac003;//姓名  
    private String aae140s;//险种
    private String aaz136;
    private String yab003;//常住地
    private String yac119_110;//养老保险参保时间 yyyy-MM-dd
    private String yac119_310;//医疗保险参保时间 yyyy-MM-dd
    private String aac002;
    private String aac011;//学历
	/**
	 * toMap
	 * @return
	 */
	public Map toMap() {
		Map map = new HashMap();
		map.put("aac147",this.aac147);//身份证号 
		map.put("aac001",this.aac001);//个人编号 (存在个人编号，就是续保) 
		map.put("aae006",this.aae006);//联系地址 
		map.put("yae107",this.yae107);//移动电话 
		map.put("aac004",this.aac004);//性别 
		map.put("aac006",this.aac006);//出生年月  格式：yyyyMMdd 
		map.put("aac003",this.aac003);//姓名   
		map.put("aae140s",this.aae140s);//险种,
		map.put("aaz136",this.aaz136); 
		map.put("yab003",this.yab003);//常住地 
		map.put("yac119_110", this.yac119_110);//养老保险参保时间 yyyy-MM-dd
		map.put("yac119_310", this.yac119_310);//医疗保险参保时间 yyyy-MM-dd
		map.put("aac011", this.aac011);//学历
		return map;
	}
	
	public void checkData(){
		if(ValidateUtil.isEmpty(aac147)){
			throw new AppException("身份证号为空！");
		}
		if(ValidateUtil.isEmpty(aac003)){
			throw new AppException("姓名为空！");
		}
		if(ValidateUtil.isEmpty(yab003)){
			throw new AppException("常住地为空！");
		}
		if(ValidateUtil.isEmpty(aae140s)){
			throw new AppException("险种为空！");
		}
		if(aae140s.contains(Constant.AAE140_110) && ValidateUtil.isEmpty(aaz136)){
			throw new AppException("养老保险档次为空！");//养老保险档次判空
		}
		if(ValidateUtil.isEmpty(yae107)){
			throw new AppException("手机号码为空！");
		}
		if(!CommUtil.isTelePhone(yae107)){//验证手机号码
			throw new AppException("手机号码格式错误！");
		}
	}
	public String getAac147() {
		return aac147;
	}
	public void setAac147(String aac147) {
		this.aac147 = aac147;
	}
	public String getAac001() {
		return aac001;
	}
	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}
	public String getAae006() {
		return aae006;
	}
	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}
	public String getYae107() {
		return yae107;
	}
	public void setYae107(String yae107) {
		this.yae107 = yae107;
	}
	public String getAac004() {
		return aac004;
	}
	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}
	public String getAac006() {
		return aac006;
	}
	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}
	public String getAac003() {
		return aac003;
	}
	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
	public String getAae140s() {
		return aae140s;
	}
	public void setAae140s(String aae140s) {
		this.aae140s = aae140s;
	}
	public String getAaz136() {
		return aaz136;
	}
	public void setAaz136(String aaz136) {
		this.aaz136 = aaz136;
	}
	public String getYab003() {
		return yab003;
	}
	public void setYab003(String yab003) {
		this.yab003 = yab003;
	}
	public String getYac119_110() {
		return yac119_110;
	}
	public void setYac119_110(String yac119_110) {
		this.yac119_110 = yac119_110;
	}
	public String getYac119_310() {
		return yac119_310;
	}
	public void setYac119_310(String yac119_310) {
		this.yac119_310 = yac119_310;
	}
	public String getAac002() {
		return aac002;
	}
	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

    public String getAac011() {
        return aac011;
    }

    public void setAac011(String aac011) {
        this.aac011 = aac011;
    }
}
