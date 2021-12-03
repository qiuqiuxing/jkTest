package com.yinhai.base.domain.cxvo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 单据信息
 * @author luomang
 * @date 2020年9月9日
 * @version 1.0
 */
public class TfsmyCx007OutDetailVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String aaz288 ;    //征缴通知ID
	private Integer yad182 ;    //单据所属期
	private String yad112 ;    //收付方式
	private String aaz010 ;    //当事人ID
	private String ape008 ;    //当事人名称
	private String aaa039 ;    //收支类型
	private String aaa028 ;    //当事人类别
	private BigDecimal yad001 ;    //应处理金额
	private String yad060 ;    //业务类型
	private String yae060 ;    //单据有效期
	private String yad005 ;    //业务处理标志
	private String yad006 ;    //财务处理标志
	private String aaf200 ;    //银行行别代码
	private String aaf002 ;    //金融机构行号
	private String aae008 ;    //银行编号
	private String aae009 ;    //银行户名
	private String aae010 ;    //银行账号
	private BigDecimal yad003 ;    //实处理金额
	private Integer aab191 ;    //到账日期
	private String aae036 ;    //经办时间
	private String yab003 ;    //经办所属机构
	private String flag_gq;    //过期标志：0 已过期，1 未过期
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAaz288() {
		return aaz288;
	}

	public void setAaz288(String aaz288) {
		this.aaz288 = aaz288;
	}

	public Integer getYad182() {
		return yad182;
	}

	public void setYad182(Integer yad182) {
		this.yad182 = yad182;
	}

	public String getYad112() {
		return yad112;
	}

	public void setYad112(String yad112) {
		this.yad112 = yad112;
	}

	public String getAaz010() {
		return aaz010;
	}

	public void setAaz010(String aaz010) {
		this.aaz010 = aaz010;
	}

	public String getApe008() {
		return ape008;
	}

	public void setApe008(String ape008) {
		this.ape008 = ape008;
	}

	public String getAaa039() {
		return aaa039;
	}

	public void setAaa039(String aaa039) {
		this.aaa039 = aaa039;
	}

	public String getAaa028() {
		return aaa028;
	}

	public void setAaa028(String aaa028) {
		this.aaa028 = aaa028;
	}

	public BigDecimal getYad001() {
		return yad001;
	}

	public void setYad001(BigDecimal yad001) {
		this.yad001 = yad001;
	}

	public String getYad060() {
		return yad060;
	}

	public void setYad060(String yad060) {
		this.yad060 = yad060;
	}

	public String getYae060() {
		return yae060;
	}

	public void setYae060(String yae060) {
		this.yae060 = yae060;
	}

	public String getYad005() {
		return yad005;
	}

	public void setYad005(String yad005) {
		this.yad005 = yad005;
	}

	public String getYad006() {
		return yad006;
	}

	public void setYad006(String yad006) {
		this.yad006 = yad006;
	}

	public String getAaf200() {
		return aaf200;
	}

	public void setAaf200(String aaf200) {
		this.aaf200 = aaf200;
	}

	public String getAaf002() {
		return aaf002;
	}

	public void setAaf002(String aaf002) {
		this.aaf002 = aaf002;
	}

	public String getAae008() {
		return aae008;
	}

	public void setAae008(String aae008) {
		this.aae008 = aae008;
	}

	public String getAae009() {
		return aae009;
	}

	public void setAae009(String aae009) {
		this.aae009 = aae009;
	}

	public String getAae010() {
		return aae010;
	}

	public void setAae010(String aae010) {
		this.aae010 = aae010;
	}

	public BigDecimal getYad003() {
		return yad003;
	}

	public void setYad003(BigDecimal yad003) {
		this.yad003 = yad003;
	}

	public Integer getAab191() {
		return aab191;
	}

	public void setAab191(Integer aab191) {
		this.aab191 = aab191;
	}

	public String getAae036() {
		return aae036;
	}

	public void setAae036(String aae036) {
		this.aae036 = aae036;
	}

	public String getYab003() {
		return yab003;
	}

	public void setYab003(String yab003) {
		this.yab003 = yab003;
	}

	public String getFlag_gq() {
		return flag_gq;
	}

	public void setFlag_gq(String flag_gq) {
		this.flag_gq = flag_gq;
	}
	
}
