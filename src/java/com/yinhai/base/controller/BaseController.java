package com.yinhai.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yinhai.base.appcode.CdsiAppCode;
import com.yinhai.base.appcode.CodeTableLocator;
import com.yinhai.base.domain.ImgDomain;
import com.yinhai.base.util.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础Controller
 */
public class BaseController {

    private static final ThreadLocal<Map<String, String>> paramThreadLocal = new NamedThreadLocal("BaseController_YHPARAM");

    /**
     * 获取参数
     * @return
     */
    protected Map getParams(){
        Map<String, Object> param = null;
        Map<String, String[]> parametermap = getRequest().getParameterMap();
        if(parametermap !=null && !parametermap.isEmpty()){
            param = new HashMap<>(parametermap.size());
            String[] tmp;
            for (String pkey : parametermap.keySet()) {
                tmp = parametermap.get(pkey);
                if(tmp!=null && tmp.length > 0){
                    if(pkey.startsWith("imgfile_")){//如果是图片
                        List<ImgDomain> imgList = new ArrayList();
                        for (String imgstring : tmp) {
                            ImgDomain imgDomain = JSON.parseObject(imgstring, ImgDomain.class);
                            imgList.add(imgDomain);
                        }
                        param.put(pkey.substring(8), imgList);
                    }else {
                        param.put(pkey, tmp[0]);
                    }
                }else{
                    param.put(pkey, "");
                }
            }
        }
        if(param == null){
            return null;
        }
        //参数去两边空格
        CommUtil.paramTrim(param);
        return param;
    }

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
    /**
     * 将map作为json字符串，异步返回
     * @param response
     * @param remap
     */
    protected void ajax(HttpServletResponse response, Map remap){
        try {
            //设置页面不缓存
            response.setContentType("application/json; charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(JSONObject.toJSONString(remap));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
    *
    * 获取码值
    *
    * @param aaa100
    */
    protected List getCodeList(String aaa100) throws Exception{
        return CodeTableLocator.getCodeList(aaa100);
    }
    /**
     * 获取码值的JSON格式
     *
     * @param aaa100
     * @return
     */
    protected String getCodeJson(String aaa100) throws Exception{
        String s = JSONObject.toJSONString(this.getCodeList(aaa100));
        return s;
    }

    /**
     * 获取码表（带过滤）
     * @param aaa100
     * @param filters 需要过滤的码值，多个值以“,”隔开
     * @param reverse true为正向过滤，false为反向过滤
     * @return
     */
    protected List getFilterCode(String aaa100, String filters, boolean reverse) throws Exception{
        return CodeTableLocator.getFilterCode(aaa100, filters, reverse);
    }

    /**
     * 获取码值的JSON格式
     *
     * @param aaa100
     * @return
     */
    protected String getFilterCodeJson(String aaa100, String filters, boolean reverse) throws Exception{
        String s = JSONObject.toJSONString(this.getFilterCode(aaa100, filters, reverse));
        return s;
    }

    /**
     * 查询码表对应键值对
     *
     * @param aaa100 码表
     * @param aaa102 键值
     * @return 码值，如果没有则为""
     */
    protected String getCodeDesc(String aaa100, String aaa102) throws Exception{
        return CodeTableLocator.getCodeDesc(aaa100, aaa102);
    }
}
