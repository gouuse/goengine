package com.gouuse.goenginesample.utils;

import com.gouuse.goenginesample.BuildConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by reiserx on 2018/4/2.
 * desc :
 */
public class AppUtil {

    /**
     * 语言环境 默认zh_cn
     */
    private static final String APP_LANG = "app_lang";
    /**
     * 客户端来源 1.web、2.iOS、3.Android
     */
    private static final String SOURCE = "source";
    /**
     * 设备唯一标示
     */
    private static final String DEVICE_SN = "sn";
    /**
     * 软件版本号
     */
    private static final String APP_VERSION = "version";
    /**
     * 设备类型 iPhone 华为 魅族 小米
     */
    private static final String DEVICE_TYPE = "device_type";
    /**
     * 设备版本 MI3
     */
    private static final String DEVICE_VERSION = "device_version";
    /**
     * 设备系统版本
     */
    private static final String SYS_VERSION = "device_system_version";


    private static final String SOURCE_ANDROID = "3";



    /**
     * 请求头token的key
     */
    public static final String TOKEN_KEY = "Authorization";
    /**
     * 请求头token的value前半部
     */
    public static final String TOKEN_VALUE_START = "Authorization: bearer ";

    /**
     * 统一的body
     *
     * @return body信息
     */
    public static Map<String, String> appBody() {
        Map<String, String> preperty = new HashMap<>();
//        preperty.put(APP_LANG, SPUtils.getInstance().getString(LanguageUtil.LANGUAGE, "zh_cn"));
        preperty.put(SOURCE, SOURCE_ANDROID);
//        preperty.put(DEVICE_SN, AppUtils.getSN(PhoneApplication.getInstances()));
        preperty.put(APP_VERSION, BuildConfig.VERSION_NAME);
        preperty.put(DEVICE_TYPE, android.os.Build.BRAND);
        preperty.put(DEVICE_VERSION, android.os.Build.MODEL);
        preperty.put(SYS_VERSION, android.os.Build.VERSION.SDK_INT + "");
        return preperty;
    }

}
