package com.gouuse.goengine.utils.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class AppUtil {
    /**
     * 获取客户端版本号
     *
     * @param context 上线问
     * @return int    版本号
     */
    public static int getVersionCode(Context context) {
        int versionCode;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            versionCode = 999;
        }
        return versionCode;
    }
}
