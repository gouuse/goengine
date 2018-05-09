package com.gouuse.goengine.http.core;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.disposables.Disposable;

/**
 * Created by reiserx on 2018/3/29.
 * desc :请求管理，方便中途取消请求
 */
public class ApiManager {
    private static ApiManager sInstance;

    private ConcurrentHashMap<Object, Disposable> arrayMaps;

    public static ApiManager get() {
        if (sInstance == null) {
            synchronized (ApiManager.class) {
                if (sInstance == null) {
                    sInstance = new ApiManager();
                }
            }
        }
        return sInstance;
    }

    private ApiManager() {
        arrayMaps = new ConcurrentHashMap<>();
    }

    public void add(Object tag, Disposable disposable) {
        arrayMaps.put(tag, disposable);
    }

    public void remove(Object tag) {
        if (!arrayMaps.isEmpty()) {
            arrayMaps.remove(tag);
        }
    }

    public void removeAll() {
        if (!arrayMaps.isEmpty()) {
            arrayMaps.clear();
        }
    }

    public void cancel(Object tag) {
        if (arrayMaps.isEmpty()) {
            return;
        }
        if (arrayMaps.get(tag) == null) {
            return;
        }
        if (!arrayMaps.get(tag).isDisposed()) {
            arrayMaps.get(tag).dispose();
            arrayMaps.remove(tag);
        }
    }

    public void cancelAll() {
        if (arrayMaps.isEmpty()) {
            return;
        }
        Set<Object> keys = arrayMaps.keySet();
        for (Object apiKey : keys) {
            cancel(apiKey);
        }
    }
}
