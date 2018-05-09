package com.gouuse.goengine.http.callback;


/**
 * Created by reiserx on 2018/3/29.
 * desc :包含下载进度回调的订阅者
 */
public abstract class DownCallback<T> extends NetCallback<T> {

    @Override
    public void onComplete() {
        super.onComplete();
        onSuccess(super.data);
    }

}
