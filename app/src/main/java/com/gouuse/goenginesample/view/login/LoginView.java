package com.gouuse.goenginesample.view.login;

import com.gouuse.goenginesample.base.BaseView;

/**
 * Created by reiserx on 2018/4/2.
 * desc :
 */
public interface LoginView extends BaseView {
    /**
     * 登录成功
     *
     * @return
     */
    void loginSuccess(String loginName);

    /**
     * 登录失败
     *
     * @param code 失败code
     * @param str  失败信息
     */
    void loginFail(long code, String str);

}
