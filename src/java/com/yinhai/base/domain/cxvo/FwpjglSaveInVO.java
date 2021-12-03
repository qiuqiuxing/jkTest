package com.yinhai.base.domain.cxvo;

import com.yinhai.base.domain.CdsiQueryParamVO;

import java.io.Serializable;

/**
 * 好差评——办件接口保存
 *
 * @Author: gaoxiangyu
 */

public class FwpjglSaveInVO implements CdsiQueryParamVO, Serializable {

    private static final long serialVersionUID = 1L;

    private String pubKey;//秘钥

    private String bze014;//系统编码

    private String yaz001;

    private String yab003;//经办机构

    private String aae011;//经办人

    private String aae414;//经办人姓名

    private String username;//用户姓名

    private String usercard;//用户身份证号

    private String usertel;//用户手机号码

    private String aaa121;//业务类型

    private String aaz002;//业务日志流水

    private String proSource = "4";//办件来源  1	实体大厅2	网厅3	12333服务热线4	移动服务端5	自助服务端

    private String userId;//用户id（如果是网厅过来的数据）

    private String aaa028 = "2";//1单位  2个人

    private String EVALUATE_TYPE = "0";//评价方式0	不获取任何方式1	公众号推送评价连接2	获取评价链接

    private String EVALUATE_CHANNL = "2";//评价渠道1	PC端2	移动端3	二维码4	政务大厅平板电脑5	政务大厅其他终端6	电话7	短信

    private String csk084a1 = "208";//服务细项

    public String getEVALUATE_TYPE() {
        return EVALUATE_TYPE;
    }

    public void setEVALUATE_TYPE(String eVALUATE_TYPE) {
        EVALUATE_TYPE = eVALUATE_TYPE;
    }

    public String getEVALUATE_CHANNL() {
        return EVALUATE_CHANNL;
    }

    public void setEVALUATE_CHANNL(String eVALUATE_CHANNL) {
        EVALUATE_CHANNL = eVALUATE_CHANNL;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public String getBze014() {
        return bze014;
    }

    public void setBze014(String bze014) {
        this.bze014 = bze014;
    }

    public String getYaz001() {
        return yaz001;
    }

    public void setYaz001(String yaz001) {
        this.yaz001 = yaz001;
    }

    public String getYab003() {
        return yab003;
    }

    public void setYab003(String yab003) {
        this.yab003 = yab003;
    }

    public String getAae011() {
        return aae011;
    }

    public void setAae011(String aae011) {
        this.aae011 = aae011;
    }

    public String getAae414() {
        return aae414;
    }

    public void setAae414(String aae414) {
        this.aae414 = aae414;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercard() {
        return usercard;
    }

    public void setUsercard(String usercard) {
        this.usercard = usercard;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getAaa121() {
        return aaa121;
    }

    public void setAaa121(String aaa121) {
        this.aaa121 = aaa121;
    }

    public String getAaz002() {
        return aaz002;
    }

    public void setAaz002(String aaz002) {
        this.aaz002 = aaz002;
    }

    public String getProSource() {
        return proSource;
    }

    public void setProSource(String proSource) {
        this.proSource = proSource;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAaa028() {
        return aaa028;
    }

    public void setAaa028(String aaa028) {
        this.aaa028 = aaa028;
    }

    public String getCsk084a1() {
        return csk084a1;
    }

    public void setCsk084a1(String csk084a1) {
        this.csk084a1 = csk084a1;
    }

    @Override
    public void checkData() {

    }
}
