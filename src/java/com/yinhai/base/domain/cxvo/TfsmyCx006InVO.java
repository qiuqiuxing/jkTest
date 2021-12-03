package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 核定信息查询
 * @author luomang
 * @date 2020年8月26日
 * @version 1.0
 */
public class TfsmyCx006InVO  implements CdsiQueryParamVO,Serializable {

	private static final long serialVersionUID = 1L;

    private String aaz002; //业务日志ID
    private String aac001; //个人编号
    private String aaz288; //单据编号（个体）
	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)){
    		throw new AppException("个人编号为空");
    	}
    	if(ValidateUtil.isEmpty(aaz002) && ValidateUtil.isEmpty(aaz288)){
    		throw new AppException("业务日志ID与单据编号不能同时为空");
    	}
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map toMap(){
    	Map map = new HashMap<>();
    	map.put("aaz002", aaz002);
    	map.put("aac001", aac001);
    	map.put("aaz288", aaz288);
    	return map;
    }
	public String getAaz002() {
		return aaz002;
	}
	public void setAaz002(String aaz002) {
		this.aaz002 = aaz002;
	}
	public String getAac001() {
		return aac001;
	}
	public void setAac001(String aac001) {
		this.aac001 = aac001;
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
