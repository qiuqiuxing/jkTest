package com.yinhai.base.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiurong
 * @version 1.0.0
 * @Description 接口数据返回VO
 * @ClassName Result.java
 * @createTime 2020年12月02日 16:13:00
 */
public class Result implements Serializable {
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private Object data;

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }


    /**
     * 成功返回
     * @return
     */
    public static Result success(){
        Result result = new Result(ResultCode.SUCCESS, null);
        return result;
    }

    /**
     * 成功返回
     * @param data 数据
     * @return
     */
    public static Result success(Object data){
        Result result = new Result(ResultCode.SUCCESS, data);
        return result;
    }

    /**
     * 失败返回（默认业务异常）
     * @param data 数据
     * @return
     */
    public static Result failure(Object data){
        Result result = new Result(ResultCode.BUSINESS_ERROR, data);
        return result;
    }

    /**
     * 失败返回
     * @param resultCode 状态码
     * @return
     */
    public static Result failure(ResultCode resultCode){
        Result result = new Result(resultCode, null);
        return result;
    }

    /**
     * 失败返回
     * @param resultCode 状态码
     * @param data 数据
     * @return
     */
    public static Result failure(ResultCode resultCode, Object data){
        Result result = new Result(resultCode, data);
        return result;
    }

    /**
     * 设置成功提示消息
     * @param msg 内容
     * @param type 类型 info，warn，error
     * @return
     */
    public static Result successMsg(String msg,String type){
        Map map = new HashMap();
        map.put("msg", msg);
        map.put("msgType", type);
        Result result = new Result(ResultCode.SUCCESS, map);
        return result;
    }
    /**
     * 设置提示消息
     * @param msg 内容
     * @return
     */
    public static Result successMsg(String msg){
        return successMsg(msg, "info");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map toMap(){
        Map map = new HashMap();
        map.put("code", this.code);
        map.put("message", this.message);
        map.put("data", this.data);
        return map;
    }
}
