package com.yinhai.base.exception;


import com.yinhai.base.result.ResultCode;

/**
 * @author qiurong
 * @version 1.0.0
 * @Description 业务异常类
 * @ClassName AppException.java
 * @createTime 2020年12月02日 18:20:00
 */
public class AppException extends RuntimeException{
    private String errorMessage;
    private String fieldName;
    private ResultCode resultCode;

    AppException() {
    }

    public AppException(String msg) {
        super(msg);
        this.errorMessage = msg;
    }

    public AppException(String msg, String fieldName) {
        super(msg);
        this.errorMessage = msg;
        this.fieldName = fieldName;
    }

    public AppException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errorMessage = resultCode.getMessage();
        this.resultCode = resultCode;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
