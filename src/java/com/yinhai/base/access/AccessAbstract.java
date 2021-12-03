package com.yinhai.base.access;

import java.util.List;

/**
 * 允许接入用户
 */
public abstract class AccessAbstract {

    /**
     * 个人编码
     */
    protected String aac001;
    /**
     * 社会保障号
     */
    protected String aac002;
    /**
     * 证件号码
     */
    protected String aac147;
    /**
     * 姓名
     */
    protected String aac003;
    /**
     * 接入端类别
     */
    private AccessType accessType;
    /**
     * 所属经办机构
     */
    protected String yab003;
    /**
     * 手机号码
     */
    protected String yae098;
    /**
     * 用户角色
     */
    private List<AccessRole> roles;

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public String getAac147() {
        return aac147;
    }

    public String getAac001() {
        return aac001;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public void setAac147(String aac147) {
        this.aac147 = aac147;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    protected void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public List<AccessRole> getRoles() {
        return roles;
    }

    public String getYab003() {
        return yab003;
    }

    public void setYab003(String yab003) {
        this.yab003 = yab003;
    }

    public void setRoles(List<AccessRole> roles) {
        this.roles = roles;
    }

    public String getYae098() {
        return yae098;
    }

    public void setYae098(String yae098) {
        this.yae098 = yae098;
    }
}