package com.gouuse.goengine.http.interceptor;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by reiserx on 2018/3/29.
 * desc :无缓存拦截
 */
public class NoCacheInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder().header("Cache-Control", "no-cache").build();
        Response originalResponse = chain.proceed(request);
        originalResponse = originalResponse.newBuilder().header("Cache-Control", "no-cache").build();
        return originalResponse;
    }
}
