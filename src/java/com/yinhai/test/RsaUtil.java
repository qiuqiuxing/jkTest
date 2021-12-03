package com.yinhai.test;

import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RsaUtil {
    //    private static final String PRIVATE_KEYFILE = "E:/consumer_private.keystore";
//        private static final String PUBLIC_KEYFILE = "E:/consumer_public.keystore";
        private static final String PUBLIC_KEYFILE = "consumer_public.keystore";
        private static final String PRIVATE_KEYFILE = "consumer_private.keystore";
    /**
     * 定义加密方式
     */
    public static final String KEY_RSA = "RSA";
    /**
     * 定义签名算法
     */
    private final static String KEY_RSA_SIGNATURE = "SHA256withRSA";
    /**
     * 字符集
     */
    static final String CHARSET = "utf-8";

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyFile 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public static PublicKey strToPublicKey(String publicKeyFile) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource(publicKeyFile);
        publicKeyFile = classPathResource.getFile().getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(publicKeyFile));
        try {
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                sb.append(readLine);
            }
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] keyBytes = IOUtils.toByteArray(sb.toString());
            byte[] encodedKey = Base64.getDecoder().decode(keyBytes);
            KeySpec keySpec = new X509EncodedKeySpec(encodedKey);
            return keyFactory.generatePublic(keySpec);
        } finally {
            br.close();
        }
    }


    /**
     * 从字符串中加载私钥
     *
     * @param privateKeyFile 私钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public static PrivateKey strToPrivateKey(String privateKeyFile) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource(privateKeyFile);
        InputStream in = new FileInputStream(classPathResource.getFile().getPath());
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] keyBytes = IOUtils.toByteArray(in);
            byte[] encodedKey = Base64.getDecoder().decode(keyBytes);
            KeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
            return keyFactory.generatePrivate(keySpec);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }


    public static String sign(String data, String privateKeyFile) {
        try {
            Signature signature = Signature.getInstance(KEY_RSA_SIGNATURE);
            signature.initSign(strToPrivateKey(privateKeyFile));
            signature.update(data.getBytes(CHARSET));
            return Base64.getEncoder().encodeToString(signature.sign());
        } catch (Exception e) {
            throw new AppException("签名异常-" + e.getMessage());
        }
    }


    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true，失败返回false
     */
    public static boolean verify(PublicKey publicKey, String data, String sign) {
        boolean flag = false;
        try {
            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey.getEncoded());
            // 指定的加密算法
            KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
            // 取公钥对象
            PublicKey key = factory.generatePublic(keySpec);
            // 用公钥验证数字签名
            Signature signature = Signature.getInstance(KEY_RSA_SIGNATURE);
            signature.initVerify(key);
            signature.update(data.getBytes(CHARSET));
            flag = signature.verify(Base64.getDecoder().decode(sign.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        //获取秘要对
        PrivateKey pk= strToPrivateKey(PRIVATE_KEYFILE);
        System.out.println(pk.toString());
        strToPublicKey(PUBLIC_KEYFILE);


    }
}
