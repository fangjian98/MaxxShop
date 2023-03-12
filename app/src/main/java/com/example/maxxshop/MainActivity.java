package com.example.maxxshop;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.example.maxxshop.base.BaseActivity;
import com.example.maxxshop.ui.AccountFragment;
import com.example.maxxshop.ui.CartFragment;
import com.example.maxxshop.ui.ClassFragment;
import com.example.maxxshop.ui.HomeFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity {

    FrameLayout mFragment;

    TabLayout mTabLayout;

    SparseArray<Fragment> mAllFragment = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mFragment = findViewById(R.id.container);
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mAllFragment.get(tab.getPosition())).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        mAllFragment.put(0, new HomeFragment());
        mAllFragment.put(1, new ClassFragment());
        mAllFragment.put(2, new CartFragment());
        mAllFragment.put(3, new AccountFragment());
        getSupportFragmentManager().beginTransaction().add(R.id.container, mAllFragment.get(0)).commit();
    }
}