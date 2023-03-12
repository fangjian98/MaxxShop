package com.example.maxxshop.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.maxxshop.R;
import com.google.android.material.appbar.AppBarLayout;

public abstract class BaseFragment extends Fragment {

    protected View mRootView;
    private Toolbar toolbar;
    private ViewGroup demoContainer;

    private AppBarLayout appBarLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_base_fragment, container, false);
        toolbar = mRootView.findViewById(R.id.toolbar);
        demoContainer = mRootView.findViewById(R.id.fragment_container);
        appBarLayout = mRootView.findViewById(R.id.fragment_appbar);
        initDemoActionBar();
        demoContainer.addView(onCreateDemoView(inflater, container, savedInstanceState));
        initView();
        initData();
        return mRootView;
    }

    private View onCreateDemoView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = layoutInflater.inflate(getContentView(), viewGroup, false /* attachToRoot */);
        return view;
    }

    private void initDemoActionBar() {
        if (shouldShowDefaultActionBar()) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setTitle(getDemoTitleResId());
            //activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            appBarLayout.setExpanded(true, true);
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
}
