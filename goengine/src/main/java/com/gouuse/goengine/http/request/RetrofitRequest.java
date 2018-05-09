package com.gouuse.goengine.http.request;

/**
 * Created by reiserx on 2018/3/29.
 * desc :传入自定义Retrofit接口的请求类型
 */
public class RetrofitRequest extends BaseRequest<RetrofitRequest> {

    public RetrofitRequest() {

    }

    public <T> T create(Class<T> cls) {
        generateGlobalConfig();
        generateLocalConfig();
        return retrofit.create(cls);
    }

}
