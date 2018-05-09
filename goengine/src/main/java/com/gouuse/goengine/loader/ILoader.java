package com.gouuse.goengine.loader;

import android.content.Context;
import android.widget.ImageView;

import com.gouuse.goengine.common.GoConfig;

import java.io.File;

/**
 * Created by reiserx on 2018/3/29.
 * desc :图片加载接口
 */
public interface ILoader {
    void init(Context context);

    void load(ImageView target, String url, Options options);

    void load(ImageView target, int resId, Options options);

    void load(ImageView target, File file, Options options);

    void loadAssets(ImageView target, String assetName, Options options);

    void clearMemoryCache(Context context);

    void clearDiskCache(Context context);

    class Options {

        public static final int RES_NONE = -1;
        public int loadingResId = RES_NONE;//加载中的资源id
        public int loadErrorResId = RES_NONE;//加载失败的资源id

        public static Options defaultOptions() {
            return new Options(GoConfig.IL_LOADING_RES, GoConfig.IL_ERROR_RES);
        }

        public Options(int loadingResId, int loadErrorResId) {
            this.loadingResId = loadingResId;
            this.loadErrorResId = loadErrorResId;
        }
    }
}
