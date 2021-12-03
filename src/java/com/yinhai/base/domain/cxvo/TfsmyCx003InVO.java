package com.yinhai.base.domain.cxvo;

import com.yinhai.base.exception.AppException;
import com.yinhai.base.domain.CdsiQueryParamVO;
import com.yinhai.base.util.ValidateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 受理信息查询
 * @author luomang
 * @date 2020年7月21日
 * @version 1.0
 */
public class TfsmyCx003InVO  implements CdsiQueryParamVO,Serializable {

	private static final long serialVersionUID = 1L;

    private String aac002; //社会保障号
    private String aac001;//个人编号
    private String aae041;//开始时间
    private String aae042;//结束时间
    private Integer start;//开始位置
    private Integer limit;//每页条数
	private String acpt_source = "51,52,53,54";//渠道

	public String getAac002() {
		return aac002;
	}
	public void setAac002(String aac002) {
		this.aac002 = aac002;
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

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getAcpt_source() {
		return acpt_source;
	}

	public void setAcpt_source(String acpt_source) {
		this.acpt_source = acpt_source;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    public void checkData(){
    	if(ValidateUtil.isEmpty(aae041)){
			this.aae041 = "2020-08-01";
    	}
    	if(ValidateUtil.isEmpty(aac001)){
    		throw new AppException("个人编码为空");
    	}
    	if(ValidateUtil.isEmpty(aac002)){
    		throw new AppException("社会保障号为空");
    	}
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map toMap(){
    	Map map = new HashMap<>();
    	map.put("aac001", aac001);
    	map.put("aac002", aac002);
    	return map;
    }
}
