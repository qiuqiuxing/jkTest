package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 变更信息查询
 * @author luomang
 * @date 2020年7月23日
 * @version 1.0
 */
public class TfsmyCx004InVO  implements CdsiQueryParamVO,Serializable {

	private static final long serialVersionUID = 1L;

    private String aaz002; //业务日志id
    private String aac001;//个人编号
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void checkData(){
    	if(ValidateUtil.isEmpty(aac001)){
    		throw new AppException("个人编码为空");
    	}
    	if(ValidateUtil.isEmpty(aaz002)){
    		throw new AppException("业务日志id为空");
    	}
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map toMap(){
    	Map map = new HashMap<>();
    	map.put("aac001", aac001);
    	map.put("aaz002", aaz002);
    	return map;
    }
}
