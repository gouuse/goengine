package com.gouuse.goengine.http.interceptor;

import android.support.annotation.NonNull;

import com.gouuse.goengine.http.body.UploadProgressRequestBody;
import com.gouuse.goengine.http.callback.UploadCallback;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by reiserx on 2018/3/29.
 * desc :上传进度拦截
 */
public class UploadProgressInterceptor implements Interceptor {

    private UploadCallback callback;

    public UploadProgressInterceptor(UploadCallback callback) {
        this.callback = callback;
        if (callback == null) {
            throw new NullPointerException("this callback must not null.");
        }
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (originalRequest.body() == null) {
            return chain.proceed(originalRequest);
        }
        Request progressRequest = originalRequest.newBuilder()
                .method(originalRequest.method(),
                        new UploadProgressRequestBody(originalRequest.body(), callback))
                .build();
        return chain.proceed(progressRequest);
    }
}
