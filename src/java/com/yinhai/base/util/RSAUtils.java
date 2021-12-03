package com.yinhai.base.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * rsa 工具类
 **/
public class RSAUtils {
    private static final Map<String, PublicKey> PUBLIC_KEY_MAP = new ConcurrentHashMap<String, PublicKey>();
    private static final Map<String, PrivateKey> PRIVATE_KEY_MAP = new ConcurrentHashMap<String, PrivateKey>();
    private static final String SIGN_ALGORITHMS = "SHA256withRSA";
    public final static String ALGORITHM_AsymmerticEncrpytion = "RSA";  // 非对称
    public final static int ALGORITHM_AsymmerticEncrpytionKeySize = 1024;
    public static final Charset MSG_CHARSET = Charset.forName("UTF-8");

    public static KeyPair generateAsymmerticRandomKey() {
        KeyPairGenerator kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance(ALGORITHM_AsymmerticEncrpytion); // 创建‘密匙对’生成器
        } catch (Exception e) {
            throw new SecurityException("不支持的非对称加密算法", e);
        }
        kpg.initialize(ALGORITHM_AsymmerticEncrpytionKeySize, new SecureRandom()); // 指定密匙长度
        KeyPair kp = kpg.genKeyPair(); // 生成‘密匙对’，其中包含着一个公匙和一个私匙的信息
        return kp;
    }
    private static InputStream getKeyInputStream(String keyFile) throws Exception {
        InputStream in = null;
        // ClassLoader loader = RSAUtils.class.getClassLoader();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null) {
            in = loader.getResourceAsStream(keyFile);
        }
        if (in == null) {
            in = ClassLoader.getSystemResourceAsStream(keyFile);
        }
        if (in == null) {
            throw new Exception("请将密钥文件" + keyFile + "放到工程classpath目录！");
        }
        return in;
    }
    /**
     * 将pkcs8 base64 的byte数组转为私钥
     */
  /*  public static PrivateKey bytesToPrivateKey(byte[] bytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] encodedKey = Base64.getDecoder().decode(bytes);
        KeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_AsymmerticEncrpytion);
        return keyFactory.generatePrivate(keySpec);
    }

    *//**
     * 将x509 base64 byte数组转为公钥
     * @param bytes
     *//*
    public static PublicKey bytesToPublicKey(byte[] bytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] encodedKey = Base64.getDecoder().decode(bytes);
        KeySpec keySpec = new X509EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_AsymmerticEncrpytion);
        return keyFactory.generatePublic(keySpec);
    }

    *//**
     * 私钥签名-one
     * @param content   待签名数据
     * @param keyFile   私钥文件
     *//*
    public static String sign(String content, String keyFile) throws Exception {
        if (!PRIVATE_KEY_MAP.containsKey(keyFile)) {
            PRIVATE_KEY_MAP.put(keyFile, loadPrivateKeyFile(keyFile));
        }
        PrivateKey privateKey = PRIVATE_KEY_MAP.get(keyFile);
        return sign(content, privateKey);
    }
    *//**
     * 私钥签名-two
     * @param content   待签名数据
     * @param privateKey   私钥
     *//*
    private static String sign(String content, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initSign(privateKey);
        signature.update(content.getBytes("UTF-8"));
        byte[] signed = signature.sign();
       // return Base64.getEncoder().encodeToString(signed);
        //new BASE64Encoder().encode(signed);
        return BASE64Encoder().encode(signed);
    }

    *//**
     * 公钥验签-one
     * @param content   待验签数据
     * @param sign       签名数据
     * @param keyFile   公钥文件
     *//*
    public static boolean verify(String content, String sign, String keyFile) throws Exception {
        if (!PUBLIC_KEY_MAP.containsKey(keyFile)) {
            PUBLIC_KEY_MAP.put(keyFile, loadPublicKeyFile(keyFile));
        }
        PublicKey publicKey = PUBLIC_KEY_MAP.get(keyFile);
        if (publicKey != null) {
            return verify(content, sign, publicKey);
        }
        return false;
    }
    *//**
     * 公钥验签-two
     * @param content   待验签数据
     * @param sign       签名数据
     * @param publicKey 公钥
     *//*
    public static boolean verify(String content, String sign, PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(publicKey);
            signature.update(content.getBytes("UTF-8"));
            byte[] signData = Base64.getDecoder().decode(sign);
            return signature.verify(signData);
        } catch (Exception e) {
        }
        return false;
    }
    *//**
     * 读取私钥文件转换成PrivateKey对象
     * @param keyFile
     *//*
    private static PrivateKey loadPrivateKeyFile(String keyFile) throws Exception {
        InputStream in = getKeyInputStream(keyFile);
        try {
            byte[] keyBytes = IOUtils.toByteArray(in);
            byte[] encodedKey = Base64.getDecoder().decode(keyBytes);
            KeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(keySpec);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
    *//**
     * 读取公钥文件转换成PublicKey对象
     * @param keyFile
     *//*
    private static PublicKey loadPublicKeyFile(String keyFile) throws Exception {
        InputStream in = getKeyInputStream(keyFile);
        try {
            byte[] keyBytes = IOUtils.toByteArray(in);
            byte[] encodedKey = Base64.getDecoder().decode(keyBytes);
            KeySpec keySpec = new X509EncodedKeySpec(encodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_AsymmerticEncrpytion);
            return keyFactory.generatePublic(keySpec);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }*/
    /**
     * 加密数据处理-自定义
     */
    /*public static String generateSignSource(Map<String, String> params) {
        Set<String> keySet = params.keySet();
        List<String> keys = new ArrayList<>();
        for (String key : keySet) {
            if (StringUtils.isNotBlank(params.get(key)) && !SdkConstant.SIGN.equals(params.get(key))) {
                keys.add(key);
            }
        }
        Collections.sort(keys);
        StringBuilder builder = new StringBuilder();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.get(i);
            String value = params.get(key);
            builder.append(key);
            builder.append("=");
            builder.append(value);
            //拼接时，不包括最后一个&字符
            if (i != size - 1) {
                builder.append("&");
            }
        }
        return builder.toString();
    }*/
    /**
     * RSA公钥加密
     * @param str 加密字符串
     * @param publicKey 公钥
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = new BASE64Decoder().decodeBuffer(publicKey); 
        //byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_AsymmerticEncrpytion).generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance(ALGORITHM_AsymmerticEncrpytion);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);

        BASE64Encoder encoder = new BASE64Encoder();
        String outStr = encoder.encode(cipher.doFinal(str.getBytes("UTF-8")));
        //String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     * @param str 加密字符串
     * @param privateKey 私钥
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM_AsymmerticEncrpytion).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance(ALGORITHM_AsymmerticEncrpytion);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    public static void main(String[] args) {

    }
}