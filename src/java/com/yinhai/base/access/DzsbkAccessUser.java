package com.yinhai.base.access;

/**
 * 电子社保卡接入
 */
public class DzsbkAccessUser extends AccessAbstract {

    /**
     * 渠道号
     */
    private String channelNo;
    /**
     * 签发号
     */
    private String signNo;
    private String ak;
    private String sk;
    private String szmy;


    public DzsbkAccessUser(){
        setAccessType(AccessType.DZSBK);
    }

    public DzsbkAccessUser(String aac002, String aac003, String channelNo, String signNo,String ak,String sk,String szmy){
        this();
        this.aac002 = aac002;
        this.aac003 = aac003;
        this.channelNo = channelNo;
        this.signNo = signNo;
        this.ak = ak;
        this.sk = sk;
        this.szmy = szmy;
    }

    public DzsbkAccessUser(String aac147, String aac003, String channelNo, String signNo){
        setAccessType(AccessType.DZSBK);
        this.aac147 = aac147;
        this.aac003 = aac003;
        this.channelNo = channelNo;
        this.signNo = signNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    public String getChannelNo() {

        return channelNo;
    }

    public String getSignNo() {
        return signNo;
    }


    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getSzmy() {
        return szmy;
    }

    public void setSzmy(String szmy) {
        this.szmy = szmy;
    }
}
