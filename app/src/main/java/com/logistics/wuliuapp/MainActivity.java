package com.logistics.wuliuapp;

import android.os.Bundle;

import com.logistics.wuliuapp.base.BaseActivity;
import com.logistics.wuliuapp.widget.ScrollControlViewPager;
import com.logistics.wuliuapp.widget.tabview.TabItem;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.viewPager)
    ScrollControlViewPager viewPager;
    @Bind(R.id.actionbar_info)
    TabItem actionbarInfo;
    @Bind(R.id.actionbar_publish)
    TabItem actionbarPublish;
    @Bind(R.id.actionbar_attention)
    TabItem actionbarAttention;
    @Bind(R.id.actionbar_mine)
    TabItem actionbarMine;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
