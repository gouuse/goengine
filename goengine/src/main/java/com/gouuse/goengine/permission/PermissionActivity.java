
package com.gouuse.goengine.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public final class PermissionActivity extends Activity {

    private static final String KEY_INPUT_PERMISSIONS = "KEY_INPUT_PERMISSIONS";

    private static PermissionListener sPermissionListener;

    /**
     * Request for permissions.
     */
    public static void requestPermission(Context context, String[] permissions, PermissionListener permissionListener) {
        sPermissionListener = permissionListener;

        Intent intent = new Intent(context, PermissionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(KEY_INPUT_PERMISSIONS, permissions);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invasionStatusBar(this);

        Intent intent = getIntent();
        String[] permissions = intent.getStringArrayExtra(KEY_INPUT_PERMISSIONS);

        if (permissions != null && sPermissionListener != null) {
            requestPermissions(permissions, 1);
        } else {
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (sPermissionListener != null)
            sPermissionListener.onRequestPermissionsResult(permissions);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sPermissionListener = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * permission callback.
     */
    interface PermissionListener {
        void onRequestPermissionsResult(@NonNull String[] permissions);
    }

    /**
     * Set the content layout full the StatusBar, but do not hide StatusBar.
     */
    private static void invasionStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility()
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
