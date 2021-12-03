package com.yinhai.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yinhai.base.controller.BaseController;
import com.yinhai.base.util.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/index")
public class TestController extends BaseController {
    private static SerializeConfig serializeConfig = new SerializeConfig();
    private static final String PUBLIC_KEYFILE = "consumer_public.keystore";
    private static final String PRIVATE_KEYFILE = "consumer_private.keystore";

    @RequestMapping("/test")
    public String save(HttpServletRequest request, HttpServletResponse response) {

        return "/test/hello";
    }

    @RequestMapping("/test!YAA01WC00001")
    @ResponseBody
    public Map YAA01WC00001(@RequestParam Map params, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> returnMap = new HashMap<String, String>();
        boolean flag = false;
        try {
            checkParameterIsNotEmpty(params);
            String sign = (String) params.get("sign");
            flag = checkSign(params, sign);
            if (!flag) {
                throw new AppException(CodeMsg.DIGITAL_CERTIFICATE_SIGNATURE_VERIFICATION_FAILED);
            }
            String biz_content = (String) params.get("biz_content");
            Map map = JSON.parseObject(biz_content);
            String json_str = (String) map.get("json_str");
            if (ValidateUtil.isEmpty(json_str)) {
                throw new AppException(CodeMsg.THE_INPUT_PARAMETER_JSON_IS_PASSED_AS_NULL);
            }
            Map json_strMap = JSON.parseObject(json_str);
            String serviceNumber = (String) json_strMap.get("serviceNumber");
            if (ValidateUtil.isEmpty(serviceNumber)) {
                throw new AppException(CodeMsg.SERVICE_ITEM_NUMBER_IS_EMPTY);
            }
            List<Map> valideArray = (List<Map>) json_strMap.get("valideArray");
            if (ValidateUtil.isEmpty(valideArray)) {
                throw new AppException(CodeMsg.VALIDATION_OBJECT);
            }
            List<Map> elementthing = new ArrayList<>();
            for (Map person : valideArray) {
                Map elementthingMap = new HashMap();
                try {
                    String name = (String) person.get("name");
                    if (ValidateUtil.isEmpty(name)) {
                        throw new AppException(CodeMsg.THE_NAME_OF_A_VERIFICATION_OBJECT_IS_EMPTY);
                    }
                    String idcard = (String) person.get("idcard");
                    if (ValidateUtil.isEmpty(idcard)) {
                        throw new AppException(CodeMsg.THE_ID_NUMBER_OF_A_VALIDATION_OBJECT_IS_EMPTY);
                    }
                    String date = (String) person.get("date");
                    if (ValidateUtil.isEmpty(date)) {
                        throw new AppException(CodeMsg.THE_ISSUE_NUMBER_OF_A_VERIFICATION_OBJECT_IS_EMPTY);
                    }
                    String money = (String) person.get("money");
                    if (ValidateUtil.isEmpty(money)) {
                        throw new AppException(CodeMsg.THE_AMOUNT_OF_A_VERIFICATION_OBJECT_IS_EMPTY);
                    }
                    List<Map<String, String>> family = (List<Map<String, String>>) person.get("family");
                    for (Map<String, String> families : family) {
                        String fName = families.get("name");
                        String fIdcard = families.get("idcard");
//                        System.out.println(fName);
//                        System.out.println(fIdcard);
                    }
                    elementthingMap.put("idcard", idcard);
                    elementthingMap.put("name", name);
                    List<Map<String, String>> valideList = new ArrayList();
                    for (int i = 0; i < 1; i++) {
                        Map<String, String> validateMap = new HashMap();
                        validateMap.put("validenumber", "V00001");
                        validateMap.put("validestatus", "0");
                        validateMap.put("code", "Y0001");
                        valideList.add(validateMap);
                    }

                    Map valideArry = new HashMap();
                    elementthingMap.put("valideArry", valideList);
                    elementthing.add(elementthingMap);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new AppException(CodeMsg.AN_ERROR_OCCURRED_WHILE_VALIDATING_AN_OBJECT.getMsg() + "_" + e.getMessage());
                }

            }
            //响应内容
            Map returnParam = new HashMap();
            returnParam.put("success", "true");
            returnParam.put("messages", "校验成功");
            returnParam.put("elementthing", elementthing);
            returnMap.put("biz_data", JSON.toJSONString(returnParam, serializeConfig, SerializerFeature.WriteMapNullValue));
            returnMap.put("msg", CodeMsg.SUCCESS.getMsg());
            returnMap.put("code", CodeMsg.SUCCESS.getCode());
            //签名
            returnMap.put("sign", RsaUtil.sign(generateSignSource(returnMap), PRIVATE_KEYFILE));
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return returnMap;
    }


    /**
     * 判断参数不能为空
     *
     * @param params
     */
    public void checkParameterIsNotEmpty(Map params) {
        //请求参数
        if (ValidateUtil.isEmpty(params)) {
            throw new AppException("请求参数不能为空！");
        }
        if (ValidateUtil.isEmpty((String) params.get("sign"))) {
            throw new AppException("数据签名不能为空!");
        }
        if (ValidateUtil.isEmpty((String) params.get("biz_content"))) {
            throw new AppException("业务参数不能为空!");
        }
        if (ValidateUtil.isEmpty((String) params.get("access_key"))) {
            throw new AppException("接入系统标识不能为空!");
        }
        if (ValidateUtil.isEmpty((String) params.get("format"))) {
            throw new AppException("返回数据格式不能为空!");
        }
        if (ValidateUtil.isEmpty((String) params.get("timestamp"))) {
            throw new AppException("请求时间不能为空!");
        }

    }


    /**
     * 拼接请求参数得到签名字符串
     *
     * @param params
     * @return
     */
    public static String generateSignSource(Map<String, String> params) {
        Set<String> keySet = params.keySet();
        List<String> keys = new ArrayList<>();
        for (String key : keySet) {
            if (params.get(key) != null && StringUtils.isNotBlank(params.get(key))) {
                keys.add(key);
            }
        }
        Collections.sort(keys);
        StringBuilder builder = new StringBuilder();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.get(i);
            Object value = params.get(key);
            builder.append(key);
            builder.append("=");
            builder.append(value);
            if (i != size - 1) {
                builder.append("&");
            }
        }
        return builder.toString();
    }


    /**
     * 验签
     *
     * @param param
     * @param sign
     * @return
     */
    public boolean checkSign(Map param, String sign) throws Exception {
        Map<String, String> data = param;
        // map中key（键）的迭代器对象
        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {// 循环取键值进行判断
            String key = iterator.next();// 键
            if (ValidateUtil.areEqual(key, "sign")) {
                iterator.remove();// 移除map中以a字符开头的键对应的键值对
            }
        }
        return RsaUtil.verify(RsaUtil.strToPublicKey(PUBLIC_KEYFILE), generateSignSource(data), sign);
    }

}
