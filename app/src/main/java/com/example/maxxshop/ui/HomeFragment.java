package com.example.maxxshop.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.BannerAdapter;
import com.example.maxxshop.adapter.GridViewAdapter;
import com.example.maxxshop.adapter.MyRecyclerAdapter;
import com.example.maxxshop.base.BaseFragment;
import com.example.maxxshop.bean.AdsCard;
import com.example.maxxshop.bean.Icon;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private ViewPager viewPager;
    private List<ImageView> viewList;
    private LinearLayout indicatorLayout;
    private GridView mGridView;
    private GridView mAdsGridView;
    private RecyclerView mRecyclerView;
    private View mSearchView;

    private GridViewAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    private GridViewAdapter mAdsAdapter = null;
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
        mGridView = mRootView.findViewById(R.id.grid_photo);
        mAdsGridView = mRootView.findViewById(R.id.ads_grid);
        mRecyclerView= mRootView.findViewById(R.id.shop_recycle_view);
        mSearchView = mRootView.findViewById(R.id.search_view);

        mSearchView.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        viewList = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        String[] colorString = new String[]{"#FF0000","#00FF00","#0000FF","#00FFFF","#FFFFF00"};

        for (int i = 0; i < 5; i++) {
            ImageView imageView = (ImageView) inflater.inflate(R.layout.image_item, null);
            imageView.setImageResource(R.drawable.banner_img);
            //imageView.setImageTintList(ColorStateList.valueOf(Color.parseColor(colorString[i])));
            viewList.add(imageView);
        }
        setAdapter();
        initIndicator();
        startAutoPlay();
        initGridView();
        initRecycleView();
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



    private void initGridView() {
        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标5"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标6"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标7"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标8"));

        mAdapter = new GridViewAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getId());
                holder.setText(R.id.txt_icon, obj.getName());
            }
        };
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<AdsCard> mAdsData = new ArrayList<AdsCard>();
        mAdsData.add(new AdsCard("MaxxShop","more",R.drawable.default_account_head,R.drawable.ic_tabs_home));
        mAdsData.add(new AdsCard("MaxxShop","more",R.drawable.default_account_head,R.drawable.ic_tabs_home));
        mAdsData.add(new AdsCard("MaxxShop","more",R.drawable.default_account_head,R.drawable.ic_tabs_home));
        mAdsData.add(new AdsCard("MaxxShop","more",R.drawable.default_account_head,R.drawable.ic_tabs_home));

        mAdsAdapter = new GridViewAdapter<AdsCard>(mAdsData, R.layout.card_view_item) {
            @Override
            public void bindView(ViewHolder holder, AdsCard obj) {
                holder.setText(R.id.card_title, obj.getTitle());
                holder.setText(R.id.card_sub_title, obj.getSubTitle());
                holder.setImageResource(R.id.first_mage, obj.getFirstId());
                holder.setImageResource(R.id.second_image, obj.getSecondId());

            }
        };
        mAdsGridView.setAdapter(mAdsAdapter);
    }



    private void initRecycleView() {
        ArrayList<Icon> mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));
        MyRecyclerAdapter<Icon> myRecyclerAdapter = new MyRecyclerAdapter<Icon>(mData, R.layout.recycle_view_item) {

            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                ((ImageView) holder.itemView.findViewById(R.id.goods_img)).setImageResource(obj.getId());
                ((TextView) holder.itemView.findViewById(R.id.goods_title)).setText(obj.getName());

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(myRecyclerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_view:
                mContext.startActivity(new Intent(mContext,SearchActivity.class));
                break;
        }
    }
}
