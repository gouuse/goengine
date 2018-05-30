package com.gouuse.goenginesample.view.meizi;

import com.gouuse.goengine.http.GoHttp;
import com.gouuse.goenginesample.entity.Meizi;
import com.gouuse.goenginesample.mvp.BasePresenter;
import com.gouuse.goenginesample.net.ApiCallBack;


/**
 * Created by reiserx on 2018/3/29.
 * desc :登录LoginPresenter
 */
public class MeiziPresenter extends BasePresenter<MeiziView> {

    private int lastUserId = 1;

    MeiziPresenter(MeiziView view) {
        super(view);
    }

//    /**
//     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
//     * 使 {@code Presenter} 可以与 {@link SupportActivity} 和 {@link Fragment} 的部分生命周期绑定
//     */
//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    void onCreate() {
//        requestMeizi(true);
//    }

    /**
     * 获取妹子
     *
     * @param pullToRefresh 是否为下拉刷新
     */
    public void requestMeizi(boolean pullToRefresh) {
        if (pullToRefresh) {
            lastUserId = 1;
            mView.showLoading();
        }
        GoHttp.GET("/api/data/%E7%A6%8F%E5%88%A9/10/" + lastUserId)
                .tag("meizi")
                .request(new ApiCallBack<Meizi>() {
                    @Override
                    public void onSuccess(Meizi model) {
                        lastUserId++;
                        mView.requestMeiziSuccess(model.getResults(), pullToRefresh);
                    }

                    @Override
                    public void onFail(long code, String msg) {
                        mView.requestMeiziFail(code, msg);
                    }

                    @Override
                    protected void finish() {
                        if (pullToRefresh) {
                            mView.hideLoading();
                        } else {
                            mView.finishLoadMore();
                        }
                    }
                });
    }

    @Override
    public void detachView() {
        super.detachView();
        GoHttp.cancelTag("meizi");
    }
}
