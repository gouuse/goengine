package com.gouuse.goenginesample.net;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by reiserx on 2018/4/8.
 * desc :
 */
public class Inter extends HttpResponseInterceptor{
    @Override
    Response processAccessTokenExpired(Chain chain, Request request) {
        return null;
    }
}
