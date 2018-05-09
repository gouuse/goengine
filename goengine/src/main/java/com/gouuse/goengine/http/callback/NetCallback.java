package com.gouuse.goengine.http.callback;


import com.gouuse.goengine.http.exception.ApiException;
import com.gouuse.goengine.http.subscriber.ApiSubscriber;


/**
 * Created by reiserx on 2018/3/29.
 * desc :包含回调的订阅者，如果订阅这个，上层在不使用订阅者的情况下可获得回调
 */
public abstract class NetCallback<T> extends ApiSubscriber<T> {

    T data;

    @Override
    public void onError(ApiException e) {
        if (e == null) {
            onFail(-1, "This ApiException is Null.");
            return;
        }
        onFail(e.getCode(), e.getMessage());
    }

    @Override
    public void onNext(T t) {
        this.data = t;
        onSuccess(t);
    }

    @Override
    public void onComplete() {
    }

    public T getData() {
        return data;
    }


    /**
     * 请求成功
     *
     * @param model 消费类型
     */
    public abstract void onSuccess(T model);

    /**
     * 请求失败
     *
     * @param code 状态码
     * @param msg  信息
     */
    public abstract void onFail(long code, String msg);

}
