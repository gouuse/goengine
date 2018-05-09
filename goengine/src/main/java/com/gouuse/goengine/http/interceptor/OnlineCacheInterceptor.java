package com.gouuse.goengine.http.interceptor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.gouuse.goengine.common.GoConfig;
import com.gouuse.goengine.log.GoLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


/**
 * Created by reiserx on 2018/3/29.
 * desc :在线缓存拦截
 */
public class OnlineCacheInterceptor implements Interceptor {
    private String cacheControlValue;

    public OnlineCacheInterceptor() {
        this(GoConfig.MAX_AGE_ONLINE);
    }

    public OnlineCacheInterceptor(int cacheControlValue) {
        this.cacheControlValue = String.format("max-age=%d", cacheControlValue);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        String cacheControl = originalResponse.header("Cache-Control");
        if (TextUtils.isEmpty(cacheControl) || cacheControl.contains("no-store") || cacheControl.contains("no-cache") || cacheControl
                .contains("must-revalidate") || cacheControl.contains("max-age") || cacheControl.contains("max-stale")) {
            GoLog.d(originalResponse.headers());
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, " + cacheControlValue)
                    .removeHeader("Pragma")
                    .build();

        } else {
            return originalResponse;
        }
    }
}
