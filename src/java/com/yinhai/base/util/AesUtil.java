package com.yinhai.base.util;


import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * @description: AES加密解密工具（单例模式调用）
 * @date:
 * @author:
 */
public class AesUtil {
    private static final String IV = "98516D446AF418112933CC64F9A98C05";
    private static final String SALT = "1D2F0B381038C6E1";
    private static final int keySize = 128;
    private static final int iterationCount = 1;

    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    public static final int HASH_BIT_SIZE = 128;         //生成密文的长度
    public static final int PBKDF2_ITERATIONS = 1000;        //迭代次数

    private AesUtil() {
    }

    private static AesUtil utils = new AesUtil();

    /**
     * 获取单例
     *
     * @return
     */
    public static AesUtil getInstance() {
        return utils;
    }

    /**
     * 加密函数
     *
     * @param content 待加密内容
     * @param key     密钥
     * @return
     */
    public byte[] encrypt(String content, String key) {
        byte[] encrypt = utils.encrypt(SALT, IV, key, content);
        return encrypt;
    }

    /**
     * 解密函数
     *
     * @param cipherContent
     * @param key
     * @return
     */
    public String decrypt(byte[] cipherContent, String key) {
        String decrypt = utils.decrypt(SALT, IV, key, cipherContent);
        return decrypt;
    }

    //解密调用
    private String decrypt(String salt, String iv, String passphrase, byte[] cipherContent) {
        try {
            SecretKey key = generateKey(salt, passphrase);
            byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, cipherContent);
            return new String(decrypted, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw fail(e);
        }
    }


    //加密调用
    private byte[] encrypt(String salt, String iv, String passphrase, String plaintext) {
        try {
            SecretKey key = generateKey(salt, passphrase);
            byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, plaintext.getBytes("UTF-8"));
            return encrypted;
        } catch (UnsupportedEncodingException e) {
            throw fail(e);
        }
    }

    //执行方法
    private byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
            return cipher.doFinal(bytes);
        } catch (InvalidKeyException e) {
            throw fail(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw fail(e);
        } catch (IllegalBlockSizeException e) {
            throw fail(e);
        } catch (BadPaddingException e) {
            throw fail(e);
        } catch (Exception e) {
            throw fail(e);
        }

    }

    //生成密钥
    private SecretKey generateKey(String salt, String passphrase) {
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterationCount, keySize);
            SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            //String keys = toHex(key.getEncoded());
            return key;
        } catch (NoSuchAlgorithmException e) {
            throw fail(e);
        } catch (InvalidKeySpecException e) {
            throw fail(e);
        }
    }


    private byte[] hex(String str) {
        try {
            return Hex.decodeHex(str.toCharArray());
        } catch (DecoderException e) {
            throw new IllegalStateException(e);
        }
    }

    private IllegalStateException fail(Exception e) {
        return new IllegalStateException(e);
    }

    private String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;

    }

    /**
     * @auther: Ragty
     * @describe: 十六进制字符串转二进制字符串
     * @param: [hex]
     * @return: byte[]
     * @date: 2018/11/2
     */
    private byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;

    }

    /**
     * @auther: Ragty
     * @describe: 生成密文
     * @param: [password(明文密码), salt(盐值)]
     * @return: java.lang.String
     * @date: 2018/11/2
     */
    public String getEncryptedPassword() {
        String password = getKey();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), fromHex(SALT), PBKDF2_ITERATIONS, HASH_BIT_SIZE);
        SecretKeyFactory f = null;
        try {
            f = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] array = new byte[0];
        try {
            array = f.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return toHex(array);
    }

    /**
     * 获取密钥明文
     *
     * @return
     * @throws Exception
     */
    private String getKey() {
        String[] data = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String res = "";
        for (int i = 0; i < 16; i++) {
            int id = (int) (Math.random() * 35);
            res += data[id];
        }
        return res;
    }

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        AesUtil aesUtil = AesUtil.getInstance();
        String pass = aesUtil.getEncryptedPassword();
        System.out.println(pass);
        byte[] encrypt = aesUtil.encrypt(SALT, IV, pass, "测试加解密");
        String encryptString = aesUtil.toHex(encrypt);
        System.out.println(encryptString);
        String decrypt = aesUtil.decrypt(SALT, IV, pass, encrypt);
        System.out.println(decrypt);
    }
}
