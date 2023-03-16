package com.example.maxxshop.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {

    private List<View> mList;

    public ViewPagerAdapter(List<View> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.removeAllViews();
        if (mList != null) {
            container.addView(mList.get(position));
            return mList.get(position);
        }
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mList != null) {
            container.removeView(mList.get(position));
        }
    }
}
