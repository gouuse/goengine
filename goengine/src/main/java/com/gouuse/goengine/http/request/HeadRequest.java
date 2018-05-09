package com.gouuse.goengine.http.request;


import com.gouuse.goengine.http.GoHttp;
import com.gouuse.goengine.http.core.ApiManager;
import com.gouuse.goengine.http.mode.CacheResult;
import com.gouuse.goengine.http.callback.NetCallback;

import java.lang.reflect.Type;

import io.reactivex.Observable;


/**
 * Created by reiserx on 2018/3/29.
 * desc :Head请求
 */
public class HeadRequest extends BaseHttpRequest<HeadRequest> {
    public HeadRequest(String suffixUrl) {
        super(suffixUrl);
    }

    @Override
    protected <T> Observable<T> execute(Type type) {
        return apiService.head(suffixUrl, params).compose(this.<T>norTransformer(type));
    }

    @Override
    protected <T> Observable<CacheResult<T>> cacheExecute(Type type) {
        return this.<T>execute(type).compose(GoHttp.getApiCache().<T>transformer(cacheMode, type));
    }

    @Override
    protected  void execute(NetCallback callback) {
        if (super.tag != null) {
            ApiManager.get().add(super.tag, callback);
        }
        if (isLocalCache) {
            this.cacheExecute(getSubType(callback)).subscribe(callback);
        } else {
            this.execute(getType(callback)).subscribe(callback);
        }
    }
}
