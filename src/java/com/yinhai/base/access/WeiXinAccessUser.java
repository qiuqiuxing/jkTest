package com.yinhai.base.access;

/**
 * 微信接入用户
 */
public class WeiXinAccessUser extends AccessAbstract {

    /**
     * 微信用户的授权token信息
     */
    private String access_token;

    private Integer expires_in;


    public WeiXinAccessUser(String aac147, String aac003){
        setAccessType(AccessType.WX);
        this.aac147 = aac147;
        this.aac003 = aac003;
    }

    public WeiXinAccessUser(String aac147, String aac003, String access_token, Integer expires_in){
        setAccessType(AccessType.WX);
        this.aac147 = aac147;
        this.aac003 = aac003;
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }
}
