package com.gouuse.goengine.http.callback;

/**
 * Created by reiserx on 2018/3/29.
 * desc :文件上传回调
 */
public interface UploadCallback {
    void onProgress(long currentLength, long totalLength, float percent);

    void onFail(int errCode, String errMsg);
}
