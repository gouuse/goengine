package com.gouuse.goengine.common;

import com.google.gson.Gson;

/**
 * Created by reiserx on 2018/3/29.
 * desc :Gson单例
 */
public class GsonUtil {
    private static Gson gson;

    public static Gson gson() {
        if (gson == null) {
            synchronized (Gson.class) {
                if (gson == null) {
                    gson = new Gson();
                }
            }
        }
        return gson;
    }
}
