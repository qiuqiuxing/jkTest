package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;

/**
 * 个人单据信息查询
 * @author luomang
 * @date 2020年9月8日
 * @version 1.0
 */
public class TfsmyCx007InVO  implements CdsiQueryParamVO,Serializable {

	private static final long serialVersionUID = 1L;

    private String dzbz; //到账标志：0 未到账，1 已到账
    private String aac001; //个人编号
    
	public void checkData(){
		if(ValidateUtil.isEmpty(aac001)){
			throw new AppException("个人编号不能为空");
    	}
    }
	public String getDzbz() {
		return dzbz;
	}
	public void setDzbz(String dzbz) {
		this.dzbz = dzbz;
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
}
