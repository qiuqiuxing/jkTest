package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationCalVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 个人编码
     */
    private String aac001;
    /**
     * 单位编码
     */
    private String aab001;
    /**
     * 险种
     */
    private String aae140;
    /**
     * 参保分中心
     */
    private String yab139;
    /**
     * 经办分中心
     */
    private String yab003;
    /**
     * 参保id
     */
    private String aaz159;
    /**
     * 离退休日期
     */
    private String aic162;
    /**
     * 参工日期
     */
    private String yic615;
    /**
     * 查询结果
     */
    private Map queryResultMap;
    /**
     * 增发
     */
    private List<Key> dgZfList;
    /**
     * aaz002
     */
    private String aaz002;
    /**
     * 粮价补贴
     */
    private BigDecimal yic477;
    /**
     * 视为实际缴费月数
     */
    private Integer stswsj;

    /**
     * 指数计算开始时间
     */
    private Integer zsjssj;
    /**
     * 建档日期 yyyyMMdd
     */
    private String yic487;
    /**
     * 人员身份
     */
    private String aac012;
    /**
     * 退休时岗位类别
     */
    private String txgwlb;
    /**
     * 性别
     */
    private String aac004;
    /**
     * 参工日期 yyyyyMMdd
     */
    private String aac007;
    /**
     * 视同缴费月数
     */
    private Integer aae200;
    /**
     * 实际缴费月数
     */
    private Integer aae201;
    /**
     * 累计缴费月数
     */
    private Integer ljjfys;
    /**
     * 其中转入月数
     */
    private Integer yic497;
    /**
     * 补实际缴费月数
     */
    private Integer yic510;
    /**
     * 账户本金
     */
    private BigDecimal aae238;
    /**
     * 账户利息
     */
    private BigDecimal aae239;
    /**
     * 账户总额
     */
    private BigDecimal aae240;
    /**
     * 档案出生日期 yyyyMMdd
     */
    private String yac516;
    /**
     * 离退休类别
     */
    private String aic161;
    /**
     * 待遇享受开始年月
     */
    private Integer aic160;
    /**
     * 孤寡类型
     */
    private String yac044;
    /**
     * 孤身补贴
     */
    private BigDecimal yic481;
    /**
     * 社平工资增长率
     */
    private BigDecimal spgzzzl;
    /**
     * 96年前实际缴费月数
     */
    private Integer yac151;
    /**
     * 96年（含）后实际缴费月数
     */
    private Integer yac152;
    /**
     * 征地倒推时间 yyyyMMdd
     */
    private String zddtsj;

    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public String getAab001() {
        return aab001;
    }

    public void setAab001(String aab001) {
        this.aab001 = aab001;
    }

    public String getAae140() {
        return aae140;
    }

    public void setAae140(String aae140) {
        this.aae140 = aae140;
    }

    public String getYab139() {
        return yab139;
    }

    public void setYab139(String yab139) {
        this.yab139 = yab139;
    }

    public String getYab003() {
        return yab003;
    }

    public void setYab003(String yab003) {
        this.yab003 = yab003;
    }

    public String getAaz159() {
        return aaz159;
    }

    public void setAaz159(String aaz159) {
        this.aaz159 = aaz159;
    }

    public String getAic162() {
        return aic162;
    }

    public void setAic162(String aic162) {
        this.aic162 = aic162;
    }

    public String getYic615() {
        return yic615;
    }

    public void setYic615(String yic615) {
        this.yic615 = yic615;
    }

    public Map getQueryResultMap() {
        return queryResultMap;
    }

    public void setQueryResultMap(Map queryResultMap) {
        this.queryResultMap = queryResultMap;
    }

    public List<Key> getDgZfList() {
        return dgZfList;
    }

    public void setDgZfList(List<Key> dgZfList) {
        this.dgZfList = dgZfList;
    }

    public String getAaz002() {
        return aaz002;
    }

    public void setAaz002(String aaz002) {
        this.aaz002 = aaz002;
    }

    public BigDecimal getYic477() {
        return yic477;
    }

    public void setYic477(BigDecimal yic477) {
        this.yic477 = yic477;
    }

    public Integer getStswsj() {
        return stswsj;
    }

    public void setStswsj(Integer stswsj) {
        this.stswsj = stswsj;
    }

    public Integer getZsjssj() {
        return zsjssj;
    }

    public void setZsjssj(Integer zsjssj) {
        this.zsjssj = zsjssj;
    }

    public String getYic487() {
        return yic487;
    }

    public void setYic487(String yic487) {
        yic487 = yic487;
    }

    public String getAac012() {
        return aac012;
    }

    public void setAac012(String aac012) {
        this.aac012 = aac012;
    }

    public String getTxgwlb() {
        return txgwlb;
    }

    public void setTxgwlb(String txgwlb) {
        this.txgwlb = txgwlb;
    }

    public String getAac004() {
        return aac004;
    }

    public void setAac004(String aac004) {
        this.aac004 = aac004;
    }

    public String getAac007() {
        return aac007;
    }

    public void setAac007(String aac007) {
        this.aac007 = aac007;
    }

    public Integer getAae200() {
        return aae200;
    }

    public void setAae200(Integer aae200) {
        this.aae200 = aae200;
    }

    public Integer getAae201() {
        return aae201;
    }

    public void setAae201(Integer aae201) {
        this.aae201 = aae201;
    }

    public Integer getLjjfys() {
        return ljjfys;
    }

    public void setLjjfys(Integer ljjfys) {
        this.ljjfys = ljjfys;
    }

    public Integer getYic497() {
        return yic497;
    }

    public void setYic497(Integer yic497) {
        this.yic497 = yic497;
    }

    public Integer getYic510() {
        return yic510;
    }

    public void setYic510(Integer yic510) {
        this.yic510 = yic510;
    }

    public BigDecimal getAae238() {
        return aae238;
    }

    public void setAae238(BigDecimal aae238) {
        this.aae238 = aae238;
    }

    public BigDecimal getAae239() {
        return aae239;
    }

    public void setAae239(BigDecimal aae239) {
        this.aae239 = aae239;
    }

    public BigDecimal getAae240() {
        return aae240;
    }

    public void setAae240(BigDecimal aae240) {
        this.aae240 = aae240;
    }

    public String getYac516() {
        return yac516;
    }

    public void setYac516(String yac516) {
        this.yac516 = yac516;
    }

    public String getAic161() {
        return aic161;
    }

    public void setAic161(String aic161) {
        this.aic161 = aic161;
    }

    public Integer getAic160() {
        return aic160;
    }

    public void setAic160(Integer aic160) {
        this.aic160 = aic160;
    }

    public String getYac044() {
        return yac044;
    }

    public void setYac044(String yac044) {
        this.yac044 = yac044;
    }

    public BigDecimal getYic481() {
        return yic481;
    }

    public void setYic481(BigDecimal yic481) {
        this.yic481 = yic481;
    }

    public BigDecimal getSpgzzzl() {
        return spgzzzl;
    }

    public void setSpgzzzl(BigDecimal spgzzzl) {
        this.spgzzzl = spgzzzl;
    }

    public Integer getYac151() {
        return yac151;
    }

    public void setYac151(Integer yac151) {
        this.yac151 = yac151;
    }

    public Integer getYac152() {
        return yac152;
    }

    public void setYac152(Integer yac152) {
        this.yac152 = yac152;
    }

    public String getZddtsj() {
        return zddtsj;
    }

    public void setZddtsj(String zddtsj) {
        this.zddtsj = zddtsj;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("aac001", this.aac001);
        map.put("aab001", this.aab001);
        map.put("aae140", this.aae140);
        map.put("yab139", this.yab139);
        map.put("yab003", this.yab003);
        map.put("aaz159", this.aaz159);
        map.put("aic162", this.aic162);
        map.put("yic615", this.yic615);
        map.put("queryResultMap", this.queryResultMap);
        map.put("dgZfList", this.dgZfList);
        map.put("aaz002", this.aaz002);
        map.put("yic477", this.yic477);
        map.put("stswsj", this.stswsj);
        map.put("zsjssj", this.zsjssj);
        map.put("yic487", this.yic487);
        map.put("aac012", this.aac012);
        map.put("txgwlb", this.txgwlb);
        map.put("aac004", this.aac004);
        map.put("aac007", this.aac007);
        map.put("aae200", this.aae200);
        map.put("aae201", this.aae201);
        map.put("ljjfys", this.ljjfys);
        map.put("yic497", this.yic497);
        map.put("yic510", this.yic510);
        map.put("aae238", this.aae238);
        map.put("aae239", this.aae239);
        map.put("aae240", this.aae240);
        map.put("yac516", this.yac516);
        map.put("aic161", this.aic161);
        map.put("aic160", this.aic160);
        map.put("yac044", this.yac044);
        map.put("yic481", this.yic481);
        map.put("spgzzzl", this.spgzzzl);
        map.put("yac151", this.yac151);
        map.put("yac152", this.yac152);
        map.put("zddtsj", this.zddtsj);

        return map;
    }


}
