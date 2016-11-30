package com.logistics.wuliuapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.logistics.wuliuapp.api.Api;
import com.logistics.wuliuapp.base.BaseActivity;
import com.logistics.wuliuapp.component.AppComponent;
import com.logistics.wuliuapp.component.DaggerMainComponent;
import com.logistics.wuliuapp.ui.adapter.ViewPagerAdapter;
import com.logistics.wuliuapp.ui.fragment.HomeFragment;
import com.logistics.wuliuapp.widget.ScrollControlViewPager;
import com.logistics.wuliuapp.widget.tabview.TabItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.viewPager)
    ScrollControlViewPager mViewPager;
    @Bind(R.id.actionbar_info)
    TabItem actionbarInfo;
    @Bind(R.id.actionbar_publish)
    TabItem actionbarPublish;
    @Bind(R.id.actionbar_attention)
    TabItem actionbarAttention;
    @Bind(R.id.actionbar_mine)
    TabItem actionbarMine;

    @Inject
    Api api;

    private int mIndex = 0;
    private List<TabItem> mTabItems;
    private int[] mTabItemsId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initBottomView();

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance(""));
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setScroll(false);
        mViewPager.addOnPageChangeListener(mViewPagerChangeListener);
        mViewPager.setCurrentItem(0);
    }

    private void initBottomView() {
        mTabItemsId = new int[]{};
        mTabItems = new ArrayList<>();
        for (int i = 0; i < mTabItemsId.length; i++) {
            TabItem tabItem = (TabItem) findViewById(mTabItemsId[i]);
            tabItem.setOnClickListener(mTabItemClickListener);
            mTabItems.add(tabItem);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent).build().inject(this);
    }

    private ViewPager.OnPageChangeListener mViewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (positionOffset > 0) {
                mTabItems.get(position).setTabAlpha(1 - positionOffset);
                mTabItems.get(position + 1).setTabAlpha(positionOffset);
            } else {
                mTabItems.get(position).setTabAlpha(1 - positionOffset);
            }
        }

        @Override
        public void onPageSelected(int position) {
            mIndex = position;
            // updateTitle();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private View.OnClickListener mTabItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = Integer.valueOf((String) v.getTag());
            if (mViewPager.getCurrentItem() == position) {
                return;
            }
            for (TabItem tabItem : mTabItems) {
                tabItem.setTabAlpha(0);
            }
            mTabItems.get(position).setTabAlpha(1);
            mViewPager.setCurrentItem(position, false);
        }
    };
}
