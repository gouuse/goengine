package com.gouuse.goenginesample.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gouuse.goengine.loader.LoaderManager;
import com.gouuse.goenginesample.R;

import java.util.List;

/**
 * Created by reiserx on 2018/4/4.
 * desc :图片加载适配器
 */
public class ImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ImageAdapter(@Nullable List data) {
        super(R.layout.cell_image_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView view = helper.getView(R.id.iv_main);
        LoaderManager.getLoader().load(view, item, null);
    }

}
