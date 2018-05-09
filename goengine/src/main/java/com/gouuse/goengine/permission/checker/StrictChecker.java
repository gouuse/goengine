
package com.gouuse.goengine.permission.checker;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import java.util.List;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public final class StrictChecker implements PermissionChecker {

    public StrictChecker() {
    }

    @Override
    public boolean hasPermission(@NonNull Context context, @NonNull String... permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return true;

        for (String permission : permissions) {
            if (!hasPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasPermission(@NonNull Context context, @NonNull List<String> permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return true;

        for (String permission : permissions) {
            if (!hasPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean hasPermission(Context context, String permission) {
        try {
            switch (permission) {
                case Manifest.permission.READ_CALENDAR:
                    return checkReadCalendar(context);
                case Manifest.permission.WRITE_CALENDAR:
                    return checkWriteCalendar(context);
                case Manifest.permission.CAMERA:
                    return checkCamera(context);
                case Manifest.permission.READ_CONTACTS:
                    return checkReadContacts(context);
                case Manifest.permission.WRITE_CONTACTS:
                    return checkWriteContacts(context);
                case Manifest.permission.GET_ACCOUNTS:
                    return true;
                case Manifest.permission.ACCESS_COARSE_LOCATION:
                case Manifest.permission.ACCESS_FINE_LOCATION:
                    return checkLocation(context);
                case Manifest.permission.RECORD_AUDIO:
                    return checkRecordAudio();
                case Manifest.permission.READ_PHONE_STATE:
                    return checkReadPhoneState(context);
                case Manifest.permission.CALL_PHONE:
                    return true;
                case Manifest.permission.READ_CALL_LOG:
                    return checkReadCallLog(context);
                case Manifest.permission.WRITE_CALL_LOG:
                    return checkWriteCallLog(context);
                case Manifest.permission.ADD_VOICEMAIL:
                    return checkAddVoicemail(context);
                case Manifest.permission.USE_SIP:
                    return checkSip(context);
                case Manifest.permission.PROCESS_OUTGOING_CALLS:
                    return true;
                case Manifest.permission.BODY_SENSORS:
                    return checkSensors(context);
                case Manifest.permission.SEND_SMS:
                case Manifest.permission.RECEIVE_MMS:
                    return true;
                case Manifest.permission.READ_SMS:
                    return checkReadSms(context);
                case Manifest.permission.RECEIVE_WAP_PUSH:
                case Manifest.permission.RECEIVE_SMS:
                    return true;
                case Manifest.permission.READ_EXTERNAL_STORAGE:
                    return checkReadStorage();
                case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                    return checkWriteStorage();
            }
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    private static boolean checkReadCalendar(Context context) throws Throwable {
        PermissionTest test = new CalendarReadTest(context);
        return test.test();
    }

    private static boolean checkWriteCalendar(Context context) throws Throwable {
        PermissionTest test = new CalendarWriteTest(context);
        return test.test();
    }

    private static boolean checkCamera(Context context) throws Throwable {
        PermissionTest test = new CameraTest(context);
        return test.test();
    }

    private static boolean checkReadContacts(Context context) throws Throwable {
        PermissionTest test = new ContactsReadTest(context);
        return test.test();
    }

    private static boolean checkWriteContacts(Context context) throws Throwable {
        ContentResolver resolver = context.getContentResolver();
        PermissionTest test = new ContactsWriteTest(resolver);
        return test.test();
    }

    private static boolean checkLocation(Context context) throws Throwable {
        PermissionTest test = new LocationTest(context);
        return test.test();
    }

    private static boolean checkRecordAudio() throws Throwable {
        PermissionTest test = new RecordAudioTest();
        return test.test();
    }

    private static boolean checkReadPhoneState(Context context) throws Throwable {
        PermissionTest test = new PhoneStateReadTest(context);
        return test.test();
    }

    private static boolean checkReadCallLog(Context context) throws Throwable {
        PermissionTest test = new CallLogReadTest(context);
        return test.test();
    }

    private static boolean checkWriteCallLog(Context context) throws Throwable {
        PermissionTest test = new CallLogWriteTest(context);
        return test.test();
    }

    private static boolean checkAddVoicemail(Context context) throws Throwable {
        PermissionTest test = new AddVoicemailTest(context);
        return test.test();
    }

    private static boolean checkSip(Context context) throws Throwable {
        PermissionTest test = new SipTest(context);
        return test.test();
    }

    private static boolean checkSensors(Context context) throws Throwable {
        PermissionTest test = new SensorsTest(context);
        return test.test();
    }

    private static boolean checkReadSms(Context context) throws Throwable {
        PermissionTest test = new SmsReadTest(context);
        return test.test();
    }

    private static boolean checkReadStorage() throws Throwable {
        PermissionTest test = new StorageReadTest();
        return test.test();
    }

    private static boolean checkWriteStorage() throws Throwable {
        PermissionTest test = new StorageWriteTest();
        return test.test();
    }
}