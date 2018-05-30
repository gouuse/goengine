/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gouuse.goenginesample.mvp;

/**
 * Created by reiserx on 2017/5/23.
 * Presenter的基类，绑定View，注册和取消Rxjava，添加订阅
 * <p>
 * // * @param <V> MVP中的View
 */

public abstract class BasePresenter<V> {
    protected V mView;

    public BasePresenter(V view) {
        attachView(view);
    }


    /**
     * 初始化操作
     *
     * @param mvpView view
     */
    private void attachView(V mvpView) {
        this.mView = mvpView;
    }


    /**
     * 页面销毁时会调用
     */
    public void detachView() {
        this.mView = null;
    }
}