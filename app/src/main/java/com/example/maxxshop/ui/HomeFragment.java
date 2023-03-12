package com.example.maxxshop.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.maxxshop.R;
import com.example.maxxshop.base.BaseFragment;

public class HomeFragment extends BaseFragment {


    @Override
    protected int getContentView() {
        return R.layout.layout_home_fragment;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = mRootView.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Home");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void initData() {

    }
}
