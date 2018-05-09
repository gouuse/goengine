package com.gouuse.goengine.utils.assist;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by reiserx on 2018/3/29.
 * desc :网络相关工具
 */
public class Network {

    /**
     * 获取ConnectivityManager
     */
    public static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    /**
     * 判断网络连接是否有效（此时可传输数据）。
     *
     * @return boolean 不管wifi，还是mobile net，只有当前在连接状态（可有效传输数据）才返回true,反之false。
     */
    public static boolean isConnected(Context context) {
        NetworkInfo net = getConnectivityManager(context).getActiveNetworkInfo();
        return net != null && net.isConnected();
    }


}