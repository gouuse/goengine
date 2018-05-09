
package com.gouuse.goengine.permission.source;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public class SupportFragmentSource extends Source {

    private Fragment mFragment;

    public SupportFragmentSource(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Override
    public Context getContext() {
        return mFragment.getContext();
    }

    @Override
    public void startActivity(Intent intent) {
        mFragment.startActivity(intent);
    }
}
