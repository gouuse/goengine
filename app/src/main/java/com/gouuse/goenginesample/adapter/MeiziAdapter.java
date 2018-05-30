package com.gouuse.goenginesample.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gouuse.goengine.loader.LoaderManager;
import com.gouuse.goenginesample.R;
import com.gouuse.goenginesample.entity.Meizi;

import java.util.List;

/**
 * Created by reiserx on 2018/5/30.
 * desc : RecycerView 适配器
 */
public class MeiziAdapter extends BaseQuickAdapter<Meizi.ResultsBean, BaseViewHolder> {


    public MeiziAdapter(@Nullable List<Meizi.ResultsBean> data) {
        super(R.layout.cell_meizi_recycle_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Meizi.ResultsBean item) {
        ImageView view = helper.getView(R.id.iv_avatar);
        LoaderManager.getLoader().load(view, item.getUrl(), null);
    }
}
