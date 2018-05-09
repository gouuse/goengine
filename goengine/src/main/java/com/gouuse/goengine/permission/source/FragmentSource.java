
package com.gouuse.goengine.permission.source;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public class FragmentSource extends Source {

    private Fragment mFragment;

    public FragmentSource(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Override
    public Context getContext() {
        return mFragment.getActivity();
    }

    @Override
    public void startActivity(Intent intent) {
        mFragment.startActivity(intent);
    }
}
