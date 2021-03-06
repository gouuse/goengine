package com.gouuse.goenginesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gouuse.goenginesample.view.UploadDownActivity;
import com.gouuse.goenginesample.view.meizi.MeiziActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
//        //test Permission
//        GoPermission.with(this)
//                .permission(Manifest.permission.CALL_PHONE)
//                //if user denied the permission, you should explain why you need the permission
//                .rationale(new Rationale() {
//                    @Override
//                    public void showRationale(Context context, List<String> permissions, RequestExecutor executor) {
//                        DialogUtil.show(MainActivity.this, "why i need th permission", new DialogUtil.SingleButtonCallback() {
//                            @Override
//                            public void onClick(@NonNull DialogInterface dialog, @NonNull DialogAction dialogAction) {
//                                if (dialogAction == DialogAction.POSITIVE) {
//                                    //permission request continue
//                                    executor.execute();
//                                } else {
//                                    //permission request cancel
//                                    executor.cancel();
//                                }
//                            }
//                        });
//
//
//                    }
//                })
//                .onGranted(new Action() {
//                    @Override
//                    public void onAction(List<String> permissions) {
//                        //permission  request allowed
//                    }
//                })
//                .onDenied(new Action() {
//                    //permission  request denied
//                    @Override
//                    public void onAction(List<String> permissions) {
//                        //you can use this method check the permission is always denied
//                        if (GoPermission.hasAlwaysDeniedPermission(MainActivity.this, permissions)) {
//                            // ask to go to Settings open permission
//                            DialogUtil.show(MainActivity.this, "go to setting", new DialogUtil.SingleButtonCallback() {
//                                @Override
//                                public void onClick(@NonNull DialogInterface dialog, @NonNull DialogAction dialogAction) {
//                                    SettingService settingService = GoPermission.permissionSetting(MainActivity.this);
//                                    if (dialogAction == DialogAction.POSITIVE) {
//                                        //go to Settings
//                                        settingService.execute();
//                                    } else {
//                                        //cancel
//                                        settingService.cancel();
//                                    }
//                                }
//                            });
//
//
//                        }
//
//                    }
//                })
//                .start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, MeiziActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, UploadDownActivity.class));
                break;
        }
    }
}
