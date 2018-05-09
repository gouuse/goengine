package com.gouuse.goenginesample.view.login;

import com.gouuse.goengine.common.GsonUtil;
import com.gouuse.goengine.http.GoHttp;
import com.gouuse.goengine.log.GoLog;
import com.gouuse.goenginesample.base.BasePresenter;
import com.gouuse.goenginesample.engine.Friend;
import com.gouuse.goenginesample.net.ApiCallBack;


/**
 * Created by reiserx on 2018/3/29.
 * desc :登录LoginPresenter
 */
public class LoginPresenter extends BasePresenter<LoginView> {


    LoginPresenter(LoginView view) {
        super(view);
    }

    public void login(String userName, String passWord, String companyId) {
        GoHttp.POST("friend/json")
                .tag("login")
                .addParam("account", userName)
                .addParam("password", passWord)
//                .addParam("company_id", companyId)
                .request(new ApiCallBack<Friend>() {
                    @Override
                    public void onSuccess(Friend model) {
                        GoLog.json(GsonUtil.gson().toJson(model));
                    }

                    @Override
                    public void onFail(long code, String msg) {
                        GoLog.d(msg);
                    }
                    @Override
                    protected void finish() {

                    }
                });

    }

    @Override
    public void detachView() {
        super.detachView();
        GoHttp.cancelTag("login");
    }
}
