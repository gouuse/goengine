
package com.gouuse.goengine.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public class AppActivitySource extends Source {

    private Activity mActivity;

    public AppActivitySource(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    public void startActivity(Intent intent) {
        mActivity.startActivity(intent);
    }
}
