package com.gouuse.goenginesample.base;

import android.os.Bundle;

import com.gouuse.goenginesample.mvp.BasePresenter;
import com.gouuse.goenginesample.mvp.IView;

/**
 * Created by reiserx on 2018/4/2.
 * desc :
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity implements IView {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

}
