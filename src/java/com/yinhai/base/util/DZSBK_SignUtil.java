package com.yinhai.base.util;

import com.alibaba.csb.sdk.security.DefaultSignServiceImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 电子社保卡前台签名
 */
public class DZSBK_SignUtil {
    /**
     * 获取签名串
     * @return
     */
    public static String getSignature(String sk, String api_access_key, String security, String return_url) {
        String _api_timestamp = String.valueOf(System.currentTimeMillis());
        String _api_name = "get_token";
        String _api_version = "1.0.0";
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("api_access_key",api_access_key);
        params.put("security", security);
        params.put("return_url", return_url);
        params.put("_api_timestamp", _api_timestamp);
        params.put("_api_name", _api_name);
        params.put("_api_version", _api_version);
        params.put("_api_access_key", api_access_key);
        String res = DefaultSignServiceImpl.getInstance().sign(params, sk);
        StringBuilder paramStr = new StringBuilder();
        try {
            paramStr.append("_api_timestamp=").append(_api_timestamp).append("&")
                .append("security=").append(URLEncoder.encode(security, "UTF-8")).append("&")
                .append("_api_name=").append(_api_name).append("&")
                .append("_api_signature=").append(URLEncoder.encode(res,  "UTF-8")).append("&")
                .append("return_url=").append(URLEncoder.encode(return_url, "UTF-8")).append("&")
                .append("_api_version=").append("1.0.0").append("&")
                .append("_api_access_key=").append(api_access_key).append("&")
                .append("api_access_key=").append(api_access_key);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return paramStr.toString();
    }
}
