
package com.gouuse.goengine.permission.checker;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.CallLog;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;


/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class CallLogReadTest implements PermissionTest {

    private ContentResolver mResolver;

    CallLogReadTest(Context context) {
        mResolver = context.getContentResolver();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @RequiresPermission(Manifest.permission.READ_CALL_LOG)
    @Override
    public boolean test() throws Throwable {
        String[] projection = new String[]{CallLog.Calls._ID, CallLog.Calls.NUMBER, CallLog.Calls.TYPE};
        Cursor cursor = mResolver.query(CallLog.Calls.CONTENT_URI, projection, null, null, null);
        if (cursor != null) {
            try {
                CursorTest.read(cursor);
            } finally {
                cursor.close();
            }
            return true;
        } else {
            return false;
        }
    }
}