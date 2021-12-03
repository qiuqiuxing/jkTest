package com.yinhai.test.yan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class TestY {
    public static void main(String[] args) throws IOException {
//        final BASE64Encoder encoder = new BASE64Encoder();
//        final BASE64Decoder decoder = new BASE64Decoder();
//        final String text = "字串文字";
//        final byte[] textByte = text.getBytes("UTF-8");
////编码
//        final String encodedText = encoder.encode(textByte);
//        System.out.println(encodedText);
//        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
//        final Base64.Decoder decoder = Base64.getDecoder();
//        final Base64.Encoder encoder = Base64.getEncoder();
//        final String text = "字串文字";
//        final byte[] textByte = text.getBytes("UTF-8");
////编码
//        final String encodedText = encoder.encodeToString(textByte);
//        System.out.println(encodedText);
////解码
//        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));


        StringBuilder biz_content = new StringBuilder();

        biz_content.append("{\"serviceNumber\":\"").append("000")
                .append("\",\"date\":\"").append("000").append("\",\"valideArray\":[");
        biz_content.append("{\"name\":\"").append("000")
                .append("\",\"idcard\":\"").append("000").append("\"");
        biz_content.append(",\"family\": [");
        biz_content.append("{\"name\": \"").append("000").append("\",\"idcard\": \"")
                .append("000").append("\"}");
        biz_content.append("]");
        biz_content.append("}");
        biz_content.append("]}");
        String biz_content1 = biz_content.toString();
        System.out.println(biz_content1);
        System.out.println("-----------------------------------------");
        Map param = new HashMap();
        param.put("json_str", biz_content1);
        biz_content1 = JSON.toJSONString(param, SerializerFeature.WriteMapNullValue);
        System.out.println(biz_content1);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair(" biz_content", biz_content1));
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8099/index/test!YAA01WC00001");
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            } else {
            }
        } catch (IOException e) {
        } finally {
            try {
                client.close();
            } catch (IOException e) {
            }
        }


    }

}
