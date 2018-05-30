package com.gouuse.goenginesample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by reiserx on 2018/5/29.
 * desc :
 */
public interface IActivity {

    /**
     * 初始化变量,包括Intent数据
     */
    void initVariables();

    /**
     * 设置layout资源
     *
     * @return 资源文件id
     */
    int initContentView();

    /**
     * 初始化View和绑定事件
     */
    void initViews(@Nullable Bundle savedInstanceState);

    /**
     * 调用数据
     */
    void loadData(@Nullable Bundle savedInstanceState);
}
