package com.gouuse.goengine.utils.cipher;

/**
 * Created by reiserx on 2018/3/29.
 * desc :密码类型
 */public enum CipherType {
    SHA("SHA"),
    MD5("MD5"),
    Hmac_MD5("HmacMD5"),
    Hmac_SHA1("HmacSHA1"),
    Hmac_SHA256("HmacSHA256"),
    Hmac_SHA384("HmacSHA384"),
    Hmac_SHA512("HmacSHA512"),
    DES("DES"),
    RSA("RSA");

    private String type;

    CipherType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
