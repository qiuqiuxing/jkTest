package com.yinhai.base.domain.sbvo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 个体撤单
 * 
 * @Author: xmchen
 * 
 */

public class Wtsbgt0009InVO implements Serializable {

	private static final long serialVersionUID = 1L;

    private String aac001; // 社保编码
    private String aae011;// 经办人
    private String aae414;// 经办人姓名
    
    private Date aae036;// 经办时间
    private String yab003;// 经办机构
    private String sibpmbz;// 启动流程标志
	private List<Wtsbgt0009InDetailVO> detailVOList; // 个体正常缴费
	private String oldAaz002;// 老系统aaz002
	public String getOldAaz002() {
		return oldAaz002;
	}

	public void setOldAaz002(String oldAaz002) {
		this.oldAaz002 = oldAaz002;
	}
  
	public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public String getAae011() {
        return aae011;
    }

    public void setAae011(String aae011) {
        this.aae011 = aae011;
    }

    public String getAae414() {
        return aae414;
    }

    public void setAae414(String aae414) {
        this.aae414 = aae414;
    }

    public Date getAae036() {
        return aae036;
    }

    public void setAae036(Date aae036) {
        this.aae036 = aae036;
    }

    public String getYab003() {
        return yab003;
    }

    public void setYab003(String yab003) {
        this.yab003 = yab003;
    }

    public List<Wtsbgt0009InDetailVO> getDetailVOList() {
		return detailVOList;
	}

	public void setDetailVOList(List<Wtsbgt0009InDetailVO> detailVOList) {
		this.detailVOList = detailVOList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSibpmbz() {
		return sibpmbz;
	}

	public void setSibpmbz(String sibpmbz) {
		this.sibpmbz = sibpmbz;
	}

	
}
