package com.gouuse.goenginesample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gouuse.goenginesample.PhoneApplication;

/**
 * Created by reiserx on 2017/5/23.
 * Activity基类，封装了progressDialog和Toast
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PhoneApplication.pushActivity(this);
        initVariables();
        int layoutId = initContentView();
        if (layoutId != 0) {
            setContentView(layoutId);
        }
        initViews();
        loadData();
    }

    /**
     * 初始化变量,包括Intent数据
     */
    protected abstract void initVariables();

    /**
     * 设置layout资源
     *
     * @return 资源文件id
     */
    protected abstract int initContentView();

    /**
     * 初始化View和绑定事件
     */
    protected abstract void initViews();

    /**
     * 调用数据
     */
    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        PhoneApplication.popActivity(this);
        super.onDestroy();
    }

}
