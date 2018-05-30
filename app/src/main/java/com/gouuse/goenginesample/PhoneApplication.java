package com.gouuse.goenginesample;

/**
 * Created by reiserx on 2018/3/29.
 * desc :
 */


import android.app.Application;

import com.gouuse.goengine.http.GoHttp;
import com.gouuse.goengine.http.interceptor.HttpLogInterceptor;

/**
 * Created by reiserx on 2017/5/23.
 * PhoneApplication处理程序初始化
 */
public class PhoneApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initNet();
    }

    /**
     * 初始化网络
     */
    private void initNet() {
        GoHttp.init(this);
        GoHttp.CONFIG()
                //配置请求主机地址
                .baseUrl("http://gank.io/")
                //配置应用级拦截器
                .interceptor(new HttpLogInterceptor().setLevel(HttpLogInterceptor.Level.BODY))
//                .interceptor(new Inter())
//                //配置全局请求头
//                .globalHeaders(globalHeaders)
//                //配置全局请求参数
//                .globalParams(globalParams)
//                //配置读取超时时间，单位秒
//                .readTimeout(30)
//                //配置写入超时时间，单位秒
//                .writeTimeout(30)
//                //配置连接超时时间，单位秒
//                .connectTimeout(30)
//                //配置请求失败重试次数
//                .retryCount(3)
//                //配置请求失败重试间隔时间，单位毫秒
//                .retryDelayMillis(1000)
//                //配置是否使用cookie
//                .setCookie(true)
//                //配置自定义cookie
//                .apiCookie(new ApiCookie(this))
//                //配置是否使用OkHttp的默认缓存
//                .setHttpCache(true)

        ;


    }

}
