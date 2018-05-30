package com.gouuse.goenginesample.mvp;

import android.support.annotation.NonNull;

/**
 * Created by reiserx on 2017/5/23.
 * View的基类
 */

public interface IView {


    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示信息
     *
     * @param message 消息内容, 不能为 {@code null}
     */
    void showMessage(@NonNull String message);


}
