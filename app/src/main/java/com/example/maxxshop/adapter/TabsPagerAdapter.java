package com.example.maxxshop.adapter;

import android.content.Context;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.maxxshop.R;
import com.example.maxxshop.ui.TabItemContentFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private int numTabs;
    SparseArray<String> mTabTitle = new SparseArray<>();

    public TabsPagerAdapter(FragmentManager manager, Context context, int numTabs) {
        super(manager);
        this.context = context;
        this.numTabs = numTabs;

        mTabTitle.put(0,"全部");
        mTabTitle.put(1,"男生");
        mTabTitle.put(2,"女生");
    }

    @Override
    public Fragment getItem(int position) {
        return TabItemContentFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle.get(position);
    }
}
