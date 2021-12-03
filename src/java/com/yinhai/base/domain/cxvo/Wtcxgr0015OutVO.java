package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.util.List;


/**
 * 查询养老待遇发放信息输出VO
 *
 * @Author:
 */
public class Wtcxgr0015OutVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Wtcxgr0015OutDetailVO> detailVOList;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<Wtcxgr0015OutDetailVO> getDetailVOList() {
        return detailVOList;
    }

    public void setDetailVOList(List<Wtcxgr0015OutDetailVO> detailVOList) {
        this.detailVOList = detailVOList;
    }

}
