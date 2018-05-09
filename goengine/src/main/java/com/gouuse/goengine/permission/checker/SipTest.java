
package com.gouuse.goengine.permission.checker;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class SipTest implements PermissionTest {

    private Context mContext;

    SipTest(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean test() throws Throwable {
        if (!SipManager.isApiSupported(mContext)) {
            return true;
        }
        SipManager manager = SipManager.newInstance(mContext);
        if (manager == null) {
            return true;
        }
        SipProfile.Builder builder = new SipProfile.Builder("Permission", "127.0.0.1");
        builder.setPassword("password");
        SipProfile profile = builder.build();
        manager.open(profile);
        manager.close(profile.getUriString());
        return true;
    }
}