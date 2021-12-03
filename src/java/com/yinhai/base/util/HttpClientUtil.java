package com.yinhai.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http调用协同平台的工具类
 * @author zengqt
 * @since 1.0
 * @date 2018/9/26
 */
public class HttpClientUtil {

    /**
     * 协同平台的地址
     */
    /*private static final String BCPURL = PropertyUtil.getBcpConfig("bcpurl");

    *//**
     * 调用系统在业务协同管理平台上面注册的系统标识
     *//*
    private static final String SYSFLAG = PropertyUtil.getBcpConfig("sysflag");

    *//**
     * 私钥文件名称
     *//*
    private static final String PRIVATEKEY = PropertyUtil.getBcpConfig("privatekey");

    *//**
     * 连接池最大并发连接数
     *//*
    private static final int MAXTOTAL = PropertyUtil.getBcpConfigToInteger("maxTotal", 3000);

    *//**
     * 单路由最大并发数
     *//*
    private static final int MAXPERROUTE = PropertyUtil.getBcpConfigToInteger("maxPerRoute", 50);

    *//**
     * 数据传输处理超时时间
     *//*
    private static final int SOCKETTIMEOUT = PropertyUtil.getBcpConfigToInteger("socketTimeout", 60000);

    *//**
     * 建立连接的超时时间
     *//*
    private static final int CONNECTTIMEOUT = PropertyUtil.getBcpConfigToInteger("connectTimeout", 5000);

    *//**
     * 从连接池获取连接的超时时间
     *//*
    private static final int CONNECTREQUSTTIMEOUT = PropertyUtil.getBcpConfigToInteger("connectionRequestTimeout", 5000);*/

    /**
     * 连接池
     */
    private static PoolingHttpClientConnectionManager cm;
    /**
     * 请求对象
     */
    private static RequestConfig config;

    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    static {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(300);
        cm.setDefaultMaxPerRoute(60);
        config = RequestConfig.custom().setConnectTimeout(5*1000)
                .setSocketTimeout(60*1000)
                .setConnectionRequestTimeout(1000).build();
    }


    /**
     * 调用协同平台
     * @param bcpParamVo 协同入参
     * @return 协同返回的字符串
     * @throws ClientException 异常信息
     */
    /*public static String httpRequestForBusiness(BcpParamVo bcpParamVo) throws ClientException {
        //协同平台地址
        String bcpurl = BCPURL;
        if(!ValidateUtil.isEmpty(bcpParamVo.getBcpVo()) && !ValidateUtil.isEmpty(bcpParamVo.getBcpVo().getBcpUrl())) {
            bcpurl = bcpParamVo.getBcpVo().getBcpUrl();
        }
        //系统标识
        String sysflag = SYSFLAG;
        if(!ValidateUtil.isEmpty(bcpParamVo.getBcpVo()) && !ValidateUtil.isEmpty(bcpParamVo.getBcpVo().getSysFlag())) {
            sysflag = bcpParamVo.getBcpVo().getSysFlag();
        }
        //私钥文件名称
        String privateKey = PRIVATEKEY;
        if(!ValidateUtil.isEmpty(bcpParamVo.getBcpVo()) && !ValidateUtil.isEmpty(bcpParamVo.getBcpVo().getPrivateKey())) {
            privateKey = bcpParamVo.getBcpVo().getPrivateKey();
        }
        if(ValidateUtil.isEmpty(privateKey)) {
            privateKey = RSAUtils.DEFAULT_KEY_FILE;
        }
        DefaultCdsiClient.setMaxTotal(MAXTOTAL);
        DefaultCdsiClient.setMaxPerRoute(MAXPERROUTE);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKETTIMEOUT).setConnectTimeout(CONNECTTIMEOUT).setConnectionRequestTimeout(CONNECTREQUSTTIMEOUT).build();
        DefaultCdsiClient.setRequestConfig(requestConfig);
        CdsiRequest request = new CdsiRequest();

        Map<String,Object> param = bcpParamVo.getParam();
        //添加分页数据
        xtptParamToInput(param);

        request.setInput(param.get("bizcontent").toString());
        //设置连接参数
        IClientProfile profile = DefaultProfile.getProfile(bcpurl, sysflag, String.valueOf(System.currentTimeMillis()), bcpParamVo.getBusinessNo(), "xml", privateKey);
        //建立连接
        ICdsiClient client = new DefaultCdsiClient(profile, request);
        return client.getResponseString();
    }*/

    /**
     * http方式调用协同平台时强制对请求参数中添加分页数据
     * @param param 入参数据
     * @return 返回添加分页数据后的数据
     */
    /*private static Map<String,Object> xtptParamToInput(Map<String,Object> param){
        Integer pageNo = 1;
        Integer pageSize = 20000;
        if(!ValidateUtil.isEmpty(param.get(BcpConstant.PAGENO)) && !ValidateUtil.isEmpty(param.get(BcpConstant.PAGESIZE))) {
            pageNo = Integer.valueOf(String.valueOf(param.get(BcpConstant.PAGENO)));
            pageSize = Integer.valueOf(String.valueOf(param.get(BcpConstant.PAGESIZE)));
        }
        param.put(BcpConstant.STARTROW, ((pageNo - 1) * pageSize) + 1);
        param.put(BcpConstant.ENDROW, pageNo * pageSize);
        return param;
    }*/

    /**
     * 获取默认的Client对象
     * @return
     */
    public static CloseableHttpClient getHttpClient(){
        return getHttpClient(config);
    }

    /**
     * 根据参数获取Client对象
     * @param cg 配置参数
     * @return
     */
    public static CloseableHttpClient getHttpClient(RequestConfig cg){
        if(ValidateUtil.isEmpty(cg)){
            cg = config;
        }
        return HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(cg).build();
    }
    /**
     *
     * @param url 请求地址
     * @param headers 请求头参数
     * @param params 业务参数
     * @param config 参数配置
     * @return
     */
    public static String get(String url, Map<String,Object> headers, Map<String,Object> params, RequestConfig config){
        URIBuilder uriBuilder = new URIBuilder().setPath(url);
        uriBuilder.setParameters(coverParam2NVPS(params));
        try {
            URI uri = uriBuilder.build();
            HttpGet httpGet = new HttpGet(uri);
            parseHttpHeader(headers,httpGet);
            return getResult(httpGet,config);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 参数格式为Map的post请求
     * @param url 请求地址
     * @param headers 请求头参数
     * @param param 业务参数
     * @param config 请求配置
     * @return
     * @throws
     */
    public static String post(String url, Map<String,Object> headers, Map<String,Object> param, RequestConfig config) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> paramList = coverParam2NVPS(param);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
        httpPost.setEntity(entity);
        parseHttpHeader(headers,httpPost);
        return getResult(httpPost,config);

    }

    /**
     * 以json格式进行请求调用
     * @param url 请求地址
     * @param header 请求头中的参数
     * @param param json格式的业务参数
     * @param config 配置类
     * @return
     */
    public static String doPostJson(String url, Map<String,Object> header, String param, RequestConfig config) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        parseHttpHeader(header,httpPost);
        //StringEntity entity = new StringEntity(param,Charset.forName("UTF-8"));
        StringEntity entity = new StringEntity(param, "UTF-8");
        //StringEntity entity = new StringEntity(param,StandardCharsets.UTF_8);
        entity.setContentType("text/json");
        entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(entity);
        return getResult(httpPost,config);
    }

    /**
     * 组装url上的参数
     * @param param
     * @return
     */
    private static ArrayList<NameValuePair> coverParam2NVPS(Map<String,Object> param){
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if(!ValidateUtil.isEmpty(param)){
            for (String key : param.keySet()) {
                pairs.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
            }
        }
        return pairs;
    }

    /**
     * 组装http请求header上的参数
     * @param header
     * @return
     */
    private static HttpRequestBase parseHttpHeader(Map<String,Object> header, HttpRequestBase requestBase){
        if(!ValidateUtil.isEmpty(header)){
            for (String key :header.keySet()){
                requestBase.addHeader(key,String.valueOf(header.get(key)));
            }
        }
        return requestBase;
    }

    /**
     *
     * @param requestBase 连接对象
     * @param config 配置参数
     * @return
     */
    private static String getResult(HttpRequestBase requestBase, RequestConfig config){
        HttpEntity httpEntity = null;
        //CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        CloseableHttpClient httpClient = getHttpClient(config);
        //HttpResponse response = httpClient.execute(requestBase);
        CloseableHttpResponse response;
		try {
			response = httpClient.execute(requestBase);
			System.out.println(response.getStatusLine());
			// try(CloseableHttpResponse response = httpClient.execute(requestBase)) {
            httpEntity = response.getEntity();
            //return EntityUtils.toString(httpEntity, StandardCharsets.UTF_8.toString());
            return EntityUtils.toString(httpEntity, Charset.forName("UTF-8").toString());
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
            consume(httpEntity);
        }
     /*   try {
        // try(CloseableHttpResponse response = httpClient.execute(requestBase)) {
            httpEntity = response.getEntity();
            //Charset.forName("UTF-8")
            //return EntityUtils.toString(httpEntity, StandardCharsets.UTF_8.toString());
            return EntityUtils.toString(httpEntity, Charset.forName("UTF-8").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            consume(httpEntity);
        }*/
        return "";
    }

    /**
     * 释放连接
     * @param entity 返回实体对象
     */
    private static void consume(HttpEntity entity){
        try {
            EntityUtils.consume(entity);
        } catch (IOException e) {
            log.error("释放http连接的时候发生异常", e);
        }
    }
    public static JSONObject sendHttpPost(String body, String uri, Map<String,Object> header) throws Exception {
        //CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getHttpClient(config);
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        parseHttpHeader(header,httpPost);
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Connection", "Keep-Alive");
        StringEntity entity = new StringEntity(body, "UTF-8");
        entity.setContentType("text/json");
        entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(entity);//指定发送数据的编码方式（关键）
        //设置连接超时时间，设置从connect Manager获取Connection 超时时间，请求获取数据的超时时间，单位毫秒。
        // 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entitys = response.getEntity();
        if(entitys!=null)
        {
        	System.out.println(response.getStatusLine());
             String responseContent = EntityUtils.toString(entitys, "UTF-8");
        JSONObject object = JSON.parseObject(responseContent);
        System.out.println(object);
        response.close();
        httpClient.close();
        return object;
        }
        return null;
    }

}
