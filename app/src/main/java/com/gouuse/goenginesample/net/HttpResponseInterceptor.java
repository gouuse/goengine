package com.gouuse.goenginesample.net;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @Description: Http响应拦截
 * @author: <a href="http://www.xiaoyaoyou1212.com">DAWI</a>
 * @date: 2017-04-08 15:15
 */
public abstract class HttpResponseInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private IResponseState responseState;

    public HttpResponseInterceptor() {
        this(new DefaultResponseState());
    }

    public HttpResponseInterceptor(IResponseState responseState) {
        this.responseState = responseState;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        return process(chain);
    }

    private Response process(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            return response;
        }
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        if (charset == null) {
            return response;
        }
        String bodyString = buffer.clone().readString(charset);
        boolean isText = isText(contentType);
        if (!isText) {
            return response;
        }

//        if (!TextUtils.isEmpty(bodyString)) {
//            HttpStatus apiResult = GsonUtil.gson().fromJson(bodyString, HttpStatus.class);
//            if (apiResult != null) {
//                String d = GsonUtil.gson().toJson(apiResult.getData());
//                if (d == null) {
//                    d = "";
//                }
//
//                buffer.writeString(d, charset);
//                if (!ResponseHelper.isSuccess(apiResult)) {
//                    if (apiResult.getCode() == responseState.accessTokenExpired()) {//AccessToken错误或已过期
//                        return processAccessTokenExpired(chain, request);
//                    }
//                    throw new AppException(apiResult.getCode(), bodyString, apiResult.getMessage());
//                }
//            }
//        }
        return response;
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        return mediaType.subtype() != null && mediaType.subtype().equals("json");
    }

    /**
     * AccessToken错误或已过期
     *
     * @param chain
     * @param request
     * @return
     */
    abstract Response processAccessTokenExpired(Chain chain, Request request);


    private class AppException extends RuntimeException {
        public AppException(int code, String bodyString, String message) {
            super(message);
        }
    }
}
