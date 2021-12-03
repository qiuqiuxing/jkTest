package com.yinhai.test;

public class AppException extends RuntimeException {
    private String errorMessage;
    private String fieldName;
    private CodeMsg codeMsg;

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

    public AppException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.errorMessage = codeMsg.getMsg();
        this.codeMsg = codeMsg;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
