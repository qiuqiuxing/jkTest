package com.yinhai.base.access;

/**
 * 天府市民云接入
 */
public class TfsmyAccessUser extends AccessAbstract {

    /**
     * 天府市民云的授权token信息
     */
    private String access_token;

    private String token_type;

    private Integer expires_in;

    private String user;


    public TfsmyAccessUser(String aac147, String aac003, String access_token, String token_type, Integer expires_in, String user){
        setAccessType(AccessType.TFSMY);
        this.aac147 = aac147;
        this.aac003 = aac003;
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.user = user;
    }

    public TfsmyAccessUser(String aac147, String aac003){
        setAccessType(AccessType.TFSMY);
        this.aac147 = aac147;
        this.aac003 = aac003;
    }

    public TfsmyAccessUser(String aac147){
        setAccessType(AccessType.TFSMY);
        this.aac147 = aac147;
    }

    public String getAccess_token() {
        return access_token;
    }
}
