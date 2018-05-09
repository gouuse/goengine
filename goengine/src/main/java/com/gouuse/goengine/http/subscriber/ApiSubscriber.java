package com.gouuse.goengine.http.subscriber;


import com.gouuse.goengine.http.exception.ApiException;
import com.gouuse.goengine.http.mode.ApiCode;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by reiserx on 2018/3/29.
 * desc :API统一订阅者
 */
public abstract class ApiSubscriber<T> extends DisposableObserver<T> {

    public  ApiSubscriber() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            onError((ApiException) e);
        } else {
            onError(new ApiException(e, ApiCode.Request.UNKNOWN));
        }
    }

    protected abstract void onError(ApiException e);
}
