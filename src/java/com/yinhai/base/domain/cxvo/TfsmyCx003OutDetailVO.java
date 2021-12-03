package com.yinhai.base.domain.cxvo;

import java.io.Serializable;

/**
 * 受理查询明细信息
 * @author luomang
 * @date 2020年7月21日
 * @version 1.0
 */
public class TfsmyCx003OutDetailVO  implements Serializable {

	private static final long serialVersionUID = 1L;

	
    private String aaz002; //业务日志号
    private String yaz001;//业务受理号
    private String aaa121;//业务类型编码
    private String aaa122;//业务类型名称
    private String create_time;//创建时间
	public String getAaz002() {
		return aaz002;
	}
	public void setAaz002(String aaz002) {
		this.aaz002 = aaz002;
	}
	public String getYaz001() {
		return yaz001;
	}
	public void setYaz001(String yaz001) {
		this.yaz001 = yaz001;
	}
	public String getAaa121() {
		return aaa121;
	}
	public void setAaa121(String aaa121) {
		this.aaa121 = aaa121;
	}
	public String getAaa122() {
		return aaa122;
	}
	public void setAaa122(String aaa122) {
		this.aaa122 = aaa122;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
	
}
