package com.gouuse.goenginesample.base;

import android.support.annotation.StringRes;

/**
 * Created by reiserx on 2017/5/23.
 * View的基类
 */

public interface BaseView{


    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

}
