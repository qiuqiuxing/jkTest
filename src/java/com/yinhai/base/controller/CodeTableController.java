package com.yinhai.base.controller;

import com.yinhai.base.appcode.CodeTableLocator;
import com.yinhai.base.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 社保码表加载
 */
@Controller
@RequestMapping("/codeTable")
public class CodeTableController extends BaseController{

    @RequestMapping(value = "codeTable!query.do")
    @ResponseBody
    public Object query(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, List> codeAll = CodeTableLocator.getAllCodeList();
        return Result.success(codeAll);
    }
}
