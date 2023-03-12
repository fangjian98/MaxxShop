package com.example.maxxshop;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private int numTabs;

    public TabsPagerAdapter(FragmentManager manager, Context context, int numTabs) {
        super(manager);
        this.context = context;
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
