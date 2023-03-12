package com.example.maxxshop.ui;

import com.example.maxxshop.R;
import com.example.maxxshop.base.BaseFragment;

public class HomeFragment extends BaseFragment {


    @Override
    protected int getContentView() {
        return R.layout.layout_home_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean shouldShowDefaultActionBar() {
        return false;
    }

    @Override
    protected int getDemoTitleResId() {
        return R.string.shop_tabs_label_home;
    }
}
