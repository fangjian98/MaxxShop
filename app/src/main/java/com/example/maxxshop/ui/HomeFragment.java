package com.example.maxxshop.ui;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.BannerAdapter;
import com.example.maxxshop.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BaseFragment {

    private ViewPager viewPager;
    private List<ImageView> viewList;
    private LinearLayout indicatorLayout;
    private int currentItem = 0;
    private Timer timer;
    private boolean isAutoPlay = true;
    private static final int AUTO_PLAY_DURATION = 3000;


    @Override
    protected int getContentView() {
        return R.layout.layout_home_fragment;
    }

    @Override
    protected void initView() {
        viewPager = mRootView.findViewById(R.id.viewPager);
        indicatorLayout = mRootView.findViewById(R.id.indicatorLayout);
    }

    @Override
    protected void initData() {
        viewList = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        for (int i = 0; i < 5; i++) {
            ImageView imageView = (ImageView) inflater.inflate(R.layout.image_item, null);
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
            viewList.add(imageView);
        }
        setAdapter();
        initIndicator();
        startAutoPlay();
    }

    @Override
    protected boolean shouldShowDefaultActionBar() {
        return false;
    }

    @Override
    protected int getDemoTitleResId() {
        return R.string.shop_tabs_label_home;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopAutoPlay();
    }

    private void setAdapter() {
        viewPager.setAdapter(new BannerAdapter(viewList, mContext));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentItem = position;
                setIndicator();
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initIndicator() {
        for (int i = 0; i < viewList.size(); i++) {
            ImageView imageView = new ImageView(mContext);
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_selected);
            } else {
                imageView.setImageResource(R.drawable.indicator_normal);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(3, 0, 3, 0);
            indicatorLayout.addView(imageView, layoutParams);
        }
    }

    private void setIndicator() {
        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            ImageView imageView = ((ImageView) indicatorLayout.getChildAt(i));
            if (i == currentItem) {
                imageView.setImageResource(R.drawable.indicator_selected);
            } else {
                imageView.setImageResource(R.drawable.indicator_normal);
            }
        }
    }

    private void startAutoPlay() {
        if (timer == null && isAutoPlay) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ((AppCompatActivity) mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(currentItem, true);
                            currentItem = (currentItem + 1) % viewList.size();
                        }
                    });
                }
            }, AUTO_PLAY_DURATION, AUTO_PLAY_DURATION);
        }
    }

    private void stopAutoPlay() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
