package com.logistics.wuliuapp.ui.fragment;

import android.os.Bundle;

import com.logistics.wuliuapp.R;
import com.logistics.wuliuapp.base.BaseRxFragment;
import com.logistics.wuliuapp.component.AppComponent;

public class HomeFragment extends BaseRxFragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
