package com.gouuse.goenginesample.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gouuse.goenginesample.R;

import java.io.File;

/**
 * Created by reiserx on 2018/3/29.
 * desc :上传下载
 */
public class UploadDownActivity extends AppCompatActivity {

    private Button mDownload_btn;
    private ProgressBar mDownload_progress;
    private TextView mDownload_progress_desc;
    private Button mUpload_btn;
    private ProgressBar mUpload_progress;
    private TextView mUpload_progress_desc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_test);

        mDownload_btn = findViewById(R.id.download_btn);
        mDownload_progress = findViewById(R.id.download_progress);
        mDownload_progress_desc = findViewById(R.id.download_progress_desc);
        mUpload_btn = findViewById(R.id.upload_btn);
        mUpload_progress = findViewById(R.id.upload_progress);
        mUpload_progress_desc = findViewById(R.id.upload_progress_desc);


        mDownload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });

        mUpload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
            }
        });


    }


    private void upload() {
        mUpload_btn.setClickable(false);
//        GoHttp.UPLOAD("v1/web/cms/skinStrategy/addOrUpdateSkinStrategy", new UploadCallback() {
//            @Override
//            public void onProgress(long currentLength, long totalLength, float percent) {
//                if (percent == 100) {
//                    mUpload_btn.setClickable(true);
//                }
//                mUpload_progress.setProgress((int) percent);
//                mUpload_progress_desc.setText(percent + "%");
//            }
//
//            @Override
//            public void onFail(int errCode, String errMsg) {
//                mUpload_btn.setClickable(true);
//            }
//        }).addParam("strategyId", "41")
//                .addParam("title", "初秋美白养成计划")
//                .addParam("tagIds", "95,96,208")
//                .addParam("content", "夏天晒黑了？初秋正是美白的好时机，快快行动起来。")
//                .addParam("status", "1")
//                .addFile("androidPicFile", getUploadFile(this, "test.jpg"))
//                .baseUrl("https://200.200.200.50/")
//                .request(new ApiCallback<Object>() {
//                    @Override
//                    public void onSuccess(Object data) {
//                        GoLog.i("upload success:" + data);
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        mUpload_btn.setClickable(true);
//                        GoLog.i("upload errorCode:" + errCode + ",errorMsg:" + errMsg);
//                    }
//                });
    }

    private void download() {
        mDownload_btn.setClickable(false);
        String saveName = "weixin.apk";
        //http://dldir1.qq.com/weixin/android/weixin6330android920.apk
        //http://imtt.dd.qq.com/16891/1A8EA15110A5DA113EBD2F955615C7EC.apk?fsname=com.moji.mjweather_7.0103.02_7010302.apk&csr=1bbd
//        GoHttp.DOWNLOAD("16891/1A8EA15110A5DA113EBD2F955615C7EC.apk?fsname=com.moji.mjweather_7.0103.02_7010302.apk&csr=1bbd")
//                .baseUrl("http://imtt.dd.qq.com/")
//                .setFileName(saveName)
//                .request(new ApiCallback<DownProgress>() {
//                    @Override
//                    public void onSuccess(DownProgress downProgress) {
//                        if (downProgress == null) {
//                            return;
//                        }
//                        mDownload_progress.setProgress((int) (downProgress.getDownloadSize() * 100 / downProgress.getTotalSize()));
//                        mDownload_progress_desc.setText(downProgress.getPercent());
//                        if (downProgress.isDownComplete()) {
//                            mDownload_btn.setClickable(true);
//                        }
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        mDownload_btn.setClickable(true);
//                    }
//                });
    }

    private File getUploadFile(Context context, String fileName) {
        String cachePath;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())
                && context.getExternalCacheDir() != null) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + fileName);
    }
}
