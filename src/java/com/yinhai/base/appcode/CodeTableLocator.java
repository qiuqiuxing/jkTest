package com.yinhai.base.appcode;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Description 码表加载类
 * @ClassName CodeTableLocator.java
 */
public class CodeTableLocator {
    private static CdsiAppCode cdsiAppCode;

    /**
     *
     * 获取所有码值
     *
     */
    public static Map<String, List> getAllCodeList() throws Exception {
        return cdsiAppCode.getCodeAll();
    }
    /**
     *
     * 获取码值
     *
     * @param aaa100
     */
    public static List getCodeList(String aaa100) throws Exception {
        return cdsiAppCode.getCodeAll(aaa100);
    }
    /**
     * 获取码值的JSON格式
     *
     * @param aaa100
     * @return
     */
    public static String getCodeJson(String aaa100) throws Exception {
        String s = JSONObject.toJSONString(getCodeList(aaa100));
        return s;
    }

    /**
     * 获取码表（带过滤）
     * @param aaa100
     * @param filters 需要过滤的码值，多个值以“,”隔开
     * @param reverse true为正向过滤，false为反向过滤
     * @return
     */
    public static List getFilterCode(String aaa100, String filters, boolean reverse) throws Exception {
        return cdsiAppCode.getFilterCode(aaa100, filters, reverse);
    }

    /**
     * 获取码值的JSON格式
     *
     * @param aaa100
     * @return
     */
    public static String getFilterCodeJson(String aaa100, String filters, boolean reverse) throws Exception {
        String s = JSONObject.toJSONString(getFilterCode(aaa100, filters, reverse));
        return s;
    }

    /**
     * 查询码表对应键值对
     *
     * @param aaa100 码表
     * @param aaa102 键值
     * @return 码值，如果没有则为""
     */
    public static String getCodeDesc(String aaa100, String aaa102) throws Exception {
        return cdsiAppCode.getCodeDesc(aaa100, aaa102);
    }

    public CdsiAppCode getCdsiAppCode() {
        return cdsiAppCode;
    }

    public void setCdsiAppCode(CdsiAppCode cdsiAppCode) {
        this.cdsiAppCode = cdsiAppCode;
    }
}
