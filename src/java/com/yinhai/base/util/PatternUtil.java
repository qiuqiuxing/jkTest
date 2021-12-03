package com.yinhai.base.util;
public interface PatternUtil {
    //电话
    final String PHONE_REG = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
    //邮箱
    final String EMAIL_REG = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    //银行账户
    final String BANK_CARD_NUMBER = "^([1-9]{1})(\\d{14}|\\d{18})$";
    //身份证
    final String ID_CARD = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
    //邮编
    final String ZIP_CODE = "[1-9]\\d{5}(?!\\d)";
    //姓名
    final String FIULLNAME = "^[\u4e00-\u9fa5]{0,4}$";
}