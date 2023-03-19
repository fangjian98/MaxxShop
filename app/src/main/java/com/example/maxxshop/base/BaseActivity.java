package com.example.maxxshop.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.maxxshop.R;
import com.google.android.material.appbar.AppBarLayout;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewGroup demoContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_base_fragment);
        toolbar = findViewById(R.id.toolbar);
        demoContainer = findViewById(R.id.fragment_container);
        View view = LayoutInflater.from(this).inflate(getContentView(), demoContainer, false /* attachToRoot */);
        demoContainer.addView(view);

        initDemoActionBar();
        initView();
        initData();
    }

    private void initDemoActionBar() {
        if (shouldShowDefaultActionBar()) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(getDemoTitleResId());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            toolbar.setVisibility(View.GONE);
        }
    }

    /**
     * 获取布局文件的id
     */
    protected abstract int getContentView();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    protected abstract boolean shouldShowDefaultActionBar();

    protected abstract int getDemoTitleResId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

