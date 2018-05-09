
package com.gouuse.goengine.permission.checker;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;


/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class CallLogWriteTest implements PermissionTest {

    private ContentResolver mResolver;

    CallLogWriteTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @RequiresPermission(Manifest.permission.WRITE_CALL_LOG)
    @Override
    public boolean test() throws Throwable {
        try {
            ContentValues content = new ContentValues();
            content.put(CallLog.Calls.TYPE, CallLog.Calls.INCOMING_TYPE);
            content.put(CallLog.Calls.NUMBER, "1");
            content.put(CallLog.Calls.DATE, 20080808);
            content.put(CallLog.Calls.NEW, "0");
            Uri resourceUri = mResolver.insert(CallLog.Calls.CONTENT_URI, content);
            return ContentUris.parseId(resourceUri) > 0;
        } finally {
            mResolver.delete(CallLog.Calls.CONTENT_URI, CallLog.Calls.NUMBER + "=?", new String[]{"1"});
        }
    }
}