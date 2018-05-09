package com.gouuse.goenginesample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gouuse.goenginesample.R;
import com.gouuse.goenginesample.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageListActivity extends AppCompatActivity {

    private RecyclerView mRvMain;
    private List<String> mImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        mRvMain = findViewById(R.id.rv_main);
        mImageList.add("http://img.juemei.com/album/2017-12-04/5a2500a964063.jpg");
        mImageList.add("http://img.juemei.com/album/2017-12-04/5a2500ab84d6c.jpg");
        ImageAdapter mAdapter = new ImageAdapter(mImageList);
        mRvMain.setLayoutManager(new GridLayoutManager(this, 2));
        mRvMain.setAdapter(mAdapter);
    }
}
