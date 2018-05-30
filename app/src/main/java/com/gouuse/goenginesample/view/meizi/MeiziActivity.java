package com.gouuse.goenginesample.view.meizi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gouuse.goenginesample.R;
import com.gouuse.goenginesample.adapter.MeiziAdapter;
import com.gouuse.goenginesample.base.BaseActivity;
import com.gouuse.goenginesample.entity.Meizi;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MeiziActivity extends BaseActivity<MeiziPresenter> implements MeiziView {
    @BindView(R.id.rv_main)
    RecyclerView mRvMain;
    @BindView(R.id.srl_main)
    SmartRefreshLayout mSrlMain;

    private MeiziAdapter mAdapter;


    @Override
    protected MeiziPresenter createPresenter() {
        return new MeiziPresenter(this);
    }

    @Override
    public void initVariables() {

    }

    @Override
    public int initContentView() {
        return R.layout.activity_meizi;
    }

    @Override
    public void initViews(@Nullable Bundle savedInstanceState) {
        mAdapter = new MeiziAdapter(new ArrayList<>());
        mRvMain.setAdapter(mAdapter);
        mRvMain.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter.bindToRecyclerView(mRvMain);
        mSrlMain.setOnLoadmoreListener(refreshlayout -> mPresenter.requestMeizi(false));
        mSrlMain.setOnRefreshListener(refreshlayout -> mPresenter.requestMeizi(true));
    }

    @Override
    public void loadData(@Nullable Bundle savedInstanceState) {
        mSrlMain.autoRefresh();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
        mSrlMain.finishRefresh();
    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void requestMeiziSuccess(List<Meizi.ResultsBean> datas, boolean addNew) {
        if (addNew) {
            mAdapter.setNewData(datas);
        } else {
            mAdapter.addData(datas);
        }

    }

    @Override
    public void requestMeiziFail(long code, String str) {

    }

    @Override
    public void finishLoadMore() {
        mSrlMain.finishLoadMore(true);
    }

}
