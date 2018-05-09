package com.gouuse.goengine.http.core;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gouuse.goengine.http.mode.CookiesStore;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;


/**
 * Created by reiserx on 2018/3/29.
 * desc :Cookie
 */
public class ApiCookie implements CookieJar {

    private CookiesStore cookieStore;

    public ApiCookie(Context context) {
        if (cookieStore == null) {
            cookieStore = new CookiesStore(context);
        }
    }

    @Override
    public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        if (cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies != null ? cookies : new ArrayList<Cookie>();
    }

}
