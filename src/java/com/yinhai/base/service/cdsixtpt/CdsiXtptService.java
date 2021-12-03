package com.yinhai.base.service.cdsixtpt;

import com.yinhai.base.access.AccessAbstract;
import com.yinhai.base.cdsienum.AAA121;
import com.yinhai.base.domain.CdsiParamVO;
import com.yinhai.base.domain.CdsiReturnVO;

public interface CdsiXtptService {

    /**
     * 调用协调平台
     * @param aaa121 服务枚举项
     * @param param 参数
     * @param user
     * @return
     */
    public CdsiReturnVO doBusiness(AAA121 aaa121, CdsiParamVO param, AccessAbstract user);

    /**
     * 调用协调平台查询
     *
     * @param fwid  服务ID
     * @param param 参数
     * @param t 输出VO
     * @return
     */
    public <T> T doQuery(String fwid, Object param, Class<T> t);

}
