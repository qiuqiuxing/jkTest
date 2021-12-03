package com.yinhai.controller;

import com.yinhai.base.controller.BaseController;
import com.yinhai.base.domain.cxvo.Wtcxgr0001InVO;
import com.yinhai.base.domain.cxvo.Wtcxgr0001OutDetailVO;
import com.yinhai.base.exception.AppException;
import com.yinhai.base.result.Result;
import com.yinhai.base.result.ResultCode;
import com.yinhai.base.service.cdsixtpt.QueryXtptService;
import com.yinhai.base.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author qiurong
 * @version 1.0.0
 * @Description 异常测试
 * @ClassName ExceptionDemoController.java
 * @createTime 2021年03月05日 11:04:00
 */
@Controller
@RequestMapping("/")
public class AjaxAndExceptionController extends BaseController {
    @Autowired
    QueryXtptService queryXtptService;

    @RequestMapping("/ajaxAndException.do")
    public Object excute() throws Exception {
        /*if (1==1) {
            throw new Exception("同步异常");
        }*/
        return "ajaxAndException";
    }
    @RequestMapping("/ajaxAndException!query.do")
    @ResponseBody
    public Object query(){
        Map params = getParams();
        if ("1".equals(params.get("aac001"))) {
            throw new AppException(ResultCode.PARAM_IS_INVALID);
        }
        //返回错误
        if (ValidateUtil.isEmpty(params.get("aac001"))) {
            return Result.failure(ResultCode.PARAM_IS_BLANK,"社保编码为空！");
        }
        Wtcxgr0001InVO wtcxgr0001InVO = new Wtcxgr0001InVO();
        wtcxgr0001InVO.setAac001(String.valueOf(params.get("aac001")));
        List<Wtcxgr0001OutDetailVO> ac01List = queryXtptService.wtcxgr0001(wtcxgr0001InVO);
        //返回错误
        if(ValidateUtil.isEmpty(ac01List)){
            return Result.failure("未查询到此人信息！");
        }
        //抛异常（被全局异常处理器GlobalExceptionHandler处理）
        if (ac01List.size() > 1) {
            throw new AppException("此人有多个社保编号！");
        }
        //返回成功
        return Result.success(ac01List.get(0));
    }
}
