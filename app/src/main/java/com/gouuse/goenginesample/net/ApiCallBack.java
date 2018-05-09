package com.gouuse.goenginesample.net;

import com.gouuse.goengine.http.callback.NetCallback;
import com.gouuse.goengine.http.exception.ApiException;

/**
 * Created by reiserx on 2018/4/9.
 * desc :
 */
public abstract class ApiCallBack<T> extends NetCallback<T> {


    @Override
    public void onNext(T t) {
        super.onNext(t);
//        if (ResponseHelper.isSuccess(t)) {
//
//        } else {
//            onFail(t.getCode(), t.getMessage());
//        }
    }

    @Override
    public void onError(ApiException e) {
        super.onError(e);
    }

    @Override
    public void onComplete() {
        super.onComplete();
    }

    protected abstract void finish();
}
