package com.gouuse.goenginesample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gouuse.goenginesample.mvp.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by reiserx on 2017/5/23.
 * Activity基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IActivity {
    private Unbinder mUnbinder;

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        initVariables();
        try {
            int layoutResID = initContentView();
            //如果initView返回0,框架则不会调用setContentView(),当然也不会 Bind ButterKnife
            if (layoutResID != 0) {
                setContentView(layoutResID);
                //绑定到butterknife
                mUnbinder = ButterKnife.bind(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initViews(savedInstanceState);
        loadData(savedInstanceState);
    }


    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        this.mPresenter = null;
    }





}
