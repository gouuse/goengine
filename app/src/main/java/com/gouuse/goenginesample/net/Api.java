package com.gouuse.goenginesample.net;

import com.gouuse.goengine.http.GoHttp;
import com.gouuse.goengine.http.request.BaseHttpRequest;

/**
 * Created by reiserx on 2018/5/15.
 * desc :
 */
public class Api {


    public static BaseHttpRequest login(String userName, String passWord) {
        return GoHttp.POST("friend/json")
                .tag("login")
                .addParam("account", userName)
                .addParam("password", passWord);
    }
}
