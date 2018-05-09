
package com.gouuse.goengine.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.VoicemailContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class AddVoicemailTest implements PermissionTest {

    private ContentResolver mResolver;

    AddVoicemailTest(Context context) {
        mResolver = context.getContentResolver();
    }

    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public boolean test() throws Throwable {
        try {
            Uri mBaseUri = VoicemailContract.Voicemails.CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put(VoicemailContract.Voicemails.DATE, System.currentTimeMillis());
            contentValues.put(VoicemailContract.Voicemails.NUMBER, "1");
            contentValues.put(VoicemailContract.Voicemails.DURATION, 1);
            contentValues.put(VoicemailContract.Voicemails.SOURCE_PACKAGE, "permission");
            contentValues.put(VoicemailContract.Voicemails.SOURCE_DATA, "permission");
            contentValues.put(VoicemailContract.Voicemails.IS_READ, 0);
            Uri newVoicemailUri = mResolver.insert(mBaseUri, contentValues);
            long id = ContentUris.parseId(newVoicemailUri);
            int count = mResolver.delete(mBaseUri, VoicemailContract.Voicemails._ID + "=?", new String[]{Long.toString(id)});
            return count > 0;
        } catch (Exception e) {
            String message = e.getMessage();
            if (!TextUtils.isEmpty(message)) {
                message = message.toLowerCase();
                return !message.contains("add_voicemail");
            }
            return false;
        }
    }
}