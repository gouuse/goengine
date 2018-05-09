
package com.gouuse.goengine.permission.source;

import android.content.Context;
import android.content.Intent;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public class ContextSource extends Source {

    private Context mContext;

    public ContextSource(Context context) {
        this.mContext = context;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void startActivity(Intent intent) {
        mContext.startActivity(intent);
    }
}
