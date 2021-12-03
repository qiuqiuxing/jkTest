package com.yinhai.test;

public enum CodeMsg {
    SUCCESS("1", "成功"),
    PARAMETER_ERROR("-101", "参数错误"),
    DIGITAL_CERTIFICATE_SIGNATURE_VERIFICATION_FAILED("-102", "数字证书签名验证失败"),
    THE_ACCESS_SYSTEM_DOES_NOT_EXIST_OR_HAS_BEEN_DISABLED("-103", "接入系统不存在或已被禁用"),
    THIS_IP_IS_NOT_ALLOWED_TO_ACCESS_THE_SERVICE("-104", "此IP未被允许访问服务"),
    SYSTEM_INNER_ERROR("-105", "服务器繁忙，请稍后重试"),
    NON_PLATFORM_PROTOCOL_SERVICES_NEED_TO_BE_ACCESSED_THROUGH_THE_CONFIGURED_INTERFACE_ADDRESS("-106", "非平台协议服务需要通过配置的接口地址访问"),
    SERVICE_NOT_DEFINED_OR_OFFLINE("-107", "服务未定义或已下线"),
    SERVICE_UNAVAILABLE("-108", "服务不可用"),
    NO_ACCESS_TO_SERVICE("-201", "无访问服务权限"),
    NO_SERVICE_FIELD_PERMISSION("-202", "无服务字段权限"),
    EXECUTION_ERROR("-300", "执行错误"),
    THE_SERVICE_IS_IN_A_FUSING_STATE("-400", "服务处于熔断状态，请稍后再试"),
    BATCH_VERIFICATION_SUCCESSFUL("Y00001", "批次校验成功"),
    BATCH_VERIFICATION_FAILED("E00060", "批次校验失败"),
    THE_INPUT_PARAMETER_JSON_IS_PASSED_AS_NULL("E00061", "入参JSON传递为空"),
    SERVICE_ITEM_NUMBER_IS_EMPTY("E00062", "服务事项编号为空"),
    VALIDATION_OBJECT("E00063", "验证对象为空"),
    THE_CHECK_RESULT_IS_EMPTY("E00064", "校验返回结果为空"),
    AN_ERROR_OCCURRED_WHILE_VALIDATING_AN_OBJECT("E00065", "某一验证对象时出错"),
    THE_ID_NUMBER_OF_A_VALIDATION_OBJECT_IS_EMPTY("E00067", "某一验证对象身份证号为空"),
    THE_NAME_OF_A_VERIFICATION_OBJECT_IS_EMPTY("E00068", "某一验证对象姓名为空"),
    THE_ISSUE_NUMBER_OF_A_VERIFICATION_OBJECT_IS_EMPTY("E00069", "某一验证对象期号为空"),
    THE_AMOUNT_OF_A_VERIFICATION_OBJECT_IS_EMPTY("E00070", "某一验证对象金额为空");
    private String code;
    private String msg;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    CodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
