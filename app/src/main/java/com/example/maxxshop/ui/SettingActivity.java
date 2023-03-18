package com.example.maxxshop.ui;

import androidx.fragment.app.FragmentContainerView;

import com.example.maxxshop.R;
import com.example.maxxshop.base.BaseActivity;

public class SettingActivity extends BaseActivity {

    private FragmentContainerView fragmentContainerView;

    @Override
    protected int getContentView() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {
        fragmentContainerView = findViewById(R.id.settings_container);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected void initData() {

    }
}
