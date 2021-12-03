package com.yinhai.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.Timestamp;
import java.util.*;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

public class Test {

    /*接口调用地址*/
    private static String host = "http://localhost:8099/index/test!";
    //    private static String host = "http://192.168.17.144:8086/yhbcp-engine/rest/";
    //    private static String host = "http://10.163.19.114:8099/index/test!YAA01WC00001";
    /*接入系统名称*/
    private static String accessKey = "CSWEB";
    /*签名私钥路径*/
    private static String privateKey = "consumer_private.keystore";
//    private static String privateKey = "E:/consumer_private.keystore";
    /*签名方式*/
    private static String signAlgorithms = "SHA256withRSA";
    /*序列化配置*/
    private static SerializeConfig serializeConfig = new SerializeConfig();

    static {
        SimpleDateFormatSerializer dateFormat = new SimpleDateFormatSerializer("yyyy-MM-dd"),
                dateTimeFormat = new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss");
        serializeConfig.put(java.sql.Date.class, dateFormat);
        serializeConfig.put(java.util.Date.class, dateFormat);
        serializeConfig.put(Timestamp.class, dateTimeFormat);
    }

    public static void main(String[] args) throws Exception {
        //接口所需参数
        Map param = new HashMap();
        String jsonStr = "{\"serviceNumber\":\"fw00001\",\"valideArray\":[{\"name\":\"张三丰\",\"idcard\":\"510521199002081323\",\"date\":\"20190611\",\"money\":\"1500\",\"family\":[{\"name\":\"张小丰\",\"idcard\":\"510521199002081323\"},{\"name\":\"王慧慧\",\"idcard\":\"510521199002081323\"}]},{\"name\":\"张三丰\",\"idcard\":\"510521199002081323\",\"date\":\"20190611\",\"money\":\"1500\",\"family\":[{\"name\":\"张小丰\",\"idcard\":\"510521199002081323\"},{\"name\":\"王慧慧\",\"idcard\":\"510521199002081323\"}]}]}";
        param.put("json_str", jsonStr);
        //起始行，默认1，查询大于200条的数据则必须
        String result = getData("YAA01WC00001", "1.0", param);
        System.out.println(result);

    }

    /**
     * 调用
     *
     * @param serviceKey 接口编号
     * @param version    接口版本
     * @param param      接口所需参数
     * @return
     * @throws Exception
     */
    public static String getData(String serviceKey, String version, Map param) throws Exception {
        String url = host + serviceKey;
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("access_key", accessKey);
        //接口所需参数
        paramMap.put("biz_content", JSON.toJSONString(param, serializeConfig, SerializerFeature.WriteMapNullValue));
        //返回数据格式，默认json，可选xml(若返回xml需另外编写doPost方法)
        paramMap.put("format", "json");
        //请求流水号，用于请求方标识，不需要可不传
        paramMap.put("request_id", String.valueOf(System.currentTimeMillis()));
        paramMap.put("version", version);
        //是否mock测试,1是0否，真实调用数据填0
        paramMap.put("mock", "0");
        //请求时间
        paramMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        //签名字符串，除了sign之外的所有请求参数签名
        paramMap.put("sign", sign(generateSignSource(paramMap), loadPrivateKeyFile(privateKey)));
        return doPost(url, paramMap);
    }

    /**
     * 加载私钥，根据需要改写加载方式
     *
     * @param keyFile 私钥路径
     * @return
     * @throws Exception
     */
    public static PrivateKey loadPrivateKeyFile(String keyFile) throws Exception {
//        InputStream in = new FileInputStream(keyFile);
        InputStream in = getResourceAsStream(keyFile);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        try {
            byte[] keyBytes = IOUtils.toByteArray(in);
            byte[] encodedKey = Base64.getDecoder().decode(keyBytes);
            KeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
            return keyFactory.generatePrivate(keySpec);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    /**
     * 签名
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(signAlgorithms);
        signature.initSign(privateKey);
        signature.update(data.getBytes("utf-8"));
        byte[] signed = signature.sign();
        return Base64.getEncoder().encodeToString(signed);
    }

    /**
     * 发起http post请求，获取数据
     *
     * @param url   请求地址
     * @param param 请求参数
     * @return 返回结果
     */
    public static String doPost(String url, Map param) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String resultStr = null;
        try {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = param.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String value = String.valueOf(param.get(name));
                nvps.add(new BasicNameValuePair(name, value));
            }
            post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                resultStr = EntityUtils.toString(res.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultStr;
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
}
