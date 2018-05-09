package com.gouuse.goengine.log;

import android.text.TextUtils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;



/**
 * Created by reiserx on 2017/6/5.
 * desc :日志工具
 */

public class GoLog {
    /**
     * 日志工具类，不允许初始化
     */
    private GoLog() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * @param openLog 是否开启log
     */
    public static void init(final boolean openLog) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("Gouuse")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return openLog;
            }
        });


    }

    /**
     * 带标签的Debug级日志
     *
     * @param tag 标签
     * @param str 日志内容
     */
    public static void d(String tag, String str) {
        if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(str)) {
            Logger.t(tag).d(str);
        }
    }

    /**
     * debug级日志
     *
     * @param str 日志内容
     */
    public static void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            Logger.d(str);
        }
    }

    /**
     * debug级日志，打印集合等对象
     *
     * @param object 日志内容可以为：MAP、SET、LIST、ARRAY
     */
    public static void d(Object object) {
        if (object != null) {
            Logger.d(object);
        }
    }

    /**
     * 打印json的日志
     *
     * @param json json格式的String
     */
    public static void json(String json) {
        if (!TextUtils.isEmpty(json)) {
            Logger.json(json);
        }
    }

    /**
     * 打印xml的日志
     *
     * @param xml xml格式的String
     */
    public static void xml(String xml) {
        if (!TextUtils.isEmpty(xml)) {
            Logger.xml(xml);
        }
    }


    /**
     * Error级日志
     *
     * @param str 日志内容
     */
    public static void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            Logger.e(str);
        }
    }

    /**
     * Error级日志
     *
     * @param e 错误
     */
    public static void e(Exception e) {
        if (e != null) {
            Logger.e(e.getCause(), e.getMessage());
        }
    }

    /**
     * 带标签的Error级日志
     *
     * @param tag 标签
     * @param str 日志内容
     */
    public static void e(String tag, String str) {
        if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(str)) {
            Logger.t(tag).e(str);
        }
    }

    /**
     * warn级日志
     *
     * @param str 日志内容
     */
    public static void w(String str) {
        if (!TextUtils.isEmpty(str)) {
            Logger.w(str);
        }
    }

    /**
     * verbose级日志
     *
     * @param str 日志内容
     */
    public static void v(String str) {
        if (!TextUtils.isEmpty(str)) {
            Logger.v(str);
        }
    }

    /**
     * info级日志
     *
     * @param str 日志内容
     */
    public static void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            Logger.i(str);
        }
    }

    /**
     * 异常日志打印
     *
     * @param e    异常
     * @param str  tag
     * @param args 其它参数信息
     */
    public static void e(Throwable e, String str, Object... args) {
        if (e != null && !TextUtils.isEmpty(str)) {
            Logger.e(e, str, args);
        }
    }

}
