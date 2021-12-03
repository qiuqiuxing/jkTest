package com.yinhai.base.exception;


import com.alibaba.fastjson.JSONObject;
import com.yinhai.base.result.Result;
import com.yinhai.base.result.ResultCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能描述: 全局异常处理器
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private static final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        log.error(exception.getMessage());
        exception.printStackTrace();
        // 判断是否ajax请求
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With") != null && request.getHeader(
                "X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            // 如果不是ajax，JSP格式返回
            // 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
            if (exception instanceof AppException) {
                //业务级异常
                return new ModelAndView("error", "errMsg", exception.getMessage());
            } else {
                //系统级异常
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            // 如果是ajax请求，JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                Result result;
                // 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
                if (exception instanceof AppException) {
                    ResultCode resultCode = ((AppException) exception).getResultCode();
                    if (resultCode != null) {
                        result = Result.failure(resultCode, resultCode.getMessage());
                    } else {
                        result = Result.failure(ResultCode.BUSINESS_ERROR, exception.getMessage());
                    }
                } else {
                    result = Result.failure(ResultCode.SYSTEM_INNER_ERROR);
                }
                writer.write(JSONObject.toJSONString(result));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
