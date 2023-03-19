package com.example.maxxshop.ui;

import androidx.viewpager.widget.ViewPager;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.TabsPagerAdapter;
import com.example.maxxshop.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

public class ClassFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected int getContentView() {
        return R.layout.layout_class_fragment;
    }

    @Override
    protected void initView() {
        mTabLayout = mRootView.findViewById(R.id.tab_class);
        mViewPager = mRootView.findViewById(R.id.viewpager_class);
    }

    @Override
    protected void initData() {
        //initTabs();
        setupViewPager();
    }

    private void initTabs() {
        mTabLayout.addTab(mTabLayout.newTab().setText("全部"));
        mTabLayout.addTab(mTabLayout.newTab().setText("男生"));
        mTabLayout.addTab(mTabLayout.newTab().setText("女生"));
    }

    private void setupViewPager() {
        mViewPager.setAdapter(new TabsPagerAdapter(getChildFragmentManager(), mContext, 3));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected boolean shouldShowDefaultActionBar() {
        return true;
    }

    @Override
    protected int getDemoTitleResId() {
        return R.string.shop_tabs_label_class;
    }
}
