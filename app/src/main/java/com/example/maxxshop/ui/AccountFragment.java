package com.example.maxxshop.ui;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.GridViewAdapter;
import com.example.maxxshop.adapter.MyAdapter;
import com.example.maxxshop.adapter.MyRecyclerAdapter;
import com.example.maxxshop.base.BaseFragment;
import com.example.maxxshop.bean.Icon;
import com.example.maxxshop.bean.UserShop;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends BaseFragment {

    private ShapeableImageView mUserImage;
    private GridView mShopView;
    private GridView mOrderView;
    private GridView mFunctionView;
    private RecyclerView recyclerView;
    private RelativeLayout rlIndicator;
    private View mainLine;

    private static final int COLUMN_COUNT = 2;
    private static final int SPAN_COUNT = 2;

    @Override
    protected int getContentView() {
        return R.layout.layout_account_fragment;
    }

    @Override
    protected void initView() {
        mUserImage = mRootView.findViewById(R.id.user_image);
        mUserImage.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());

        mShopView = mRootView.findViewById(R.id.user_shop);
        mOrderView = mRootView.findViewById(R.id.user_order_menu);
        mFunctionView = mRootView.findViewById(R.id.user_function_view);
        recyclerView = mRootView.findViewById(R.id.user_other_view);

        rlIndicator = mRootView.findViewById(R.id.rl_indicator);
        mainLine = mRootView.findViewById(R.id.main_line);
    }

    @Override
    protected void initData() {
        initShopView();
        initOrderView();
        initFunctionView();
        initOtherView();
    }

    @Override
    protected boolean shouldShowDefaultActionBar() {
        return true;
    }

    @Override
    protected int getDemoTitleResId() {
        return R.string.shop_tabs_label_account;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initShopView() {
        ArrayList<UserShop> mData = new ArrayList<UserShop>();
        mData.add(new UserShop("1", "图标1"));
        mData.add(new UserShop("12", "图标2"));
        mData.add(new UserShop("123", "图标3"));
        mData.add(new UserShop("0", "图标4"));

        GridViewAdapter<UserShop> mAdapter = new GridViewAdapter<UserShop>(mData, R.layout.user_shop_item) {
            @Override
            public void bindView(ViewHolder holder, UserShop obj) {
                holder.setText(R.id.shop_count, obj.getCount());
                holder.setText(R.id.shop_title, obj.getTitle());
            }
        };
        mShopView.setAdapter(mAdapter);
    }


    private void initOrderView() {
        ArrayList<Icon> mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标5"));

        GridViewAdapter<Icon> mAdapter = new GridViewAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getId());
                holder.setText(R.id.txt_icon, obj.getName());
            }
        };
        mOrderView.setAdapter(mAdapter);
    }

    private void initFunctionView() {
        ArrayList<Icon> mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));

        GridViewAdapter<Icon> mAdapter = new GridViewAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getId());
                holder.setText(R.id.txt_icon, obj.getName());
            }
        };
        mFunctionView.setAdapter(mAdapter);
    }

    private void initOtherView() {

        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Icon> mData = new ArrayList<Icon>();
        for (int i = 0; i < 3; i++) {
            mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
            mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
            mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
            mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));
        }
        MyRecyclerAdapter<Icon> myRecyclerAdapter = new MyRecyclerAdapter<Icon>(mData, R.layout.horizontal_recycle_view_item) {

            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                ((ImageView) holder.itemView.findViewById(R.id.other_icon)).setImageResource(obj.getId());
                ((TextView) holder.itemView.findViewById(R.id.other_title)).setText(obj.getName());

            }
        };
        recyclerView.setAdapter(myRecyclerAdapter);


//        MyAdapter adapter = new MyAdapter();
//        List<String> data = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            if (i % 2 == 0) {
//                data.add("第一行" + i);
//            } else {
//                data.add("第二行 " + i);
//            }
//        }
//        adapter.setData(data);
//
//        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int range = 0;
                int temp = recyclerView.computeHorizontalScrollRange();
                if (temp > range) {
                    range = temp;
                }
                //滑块的偏移量
                int offset = recyclerView.computeHorizontalScrollOffset();
                //可视区域长度
                int extent = recyclerView.computeHorizontalScrollExtent();
                //滑出部分在剩余范围的比例
                float proportion = (float) (offset * 1.0 / (range - extent));
                //计算滚动条宽度
                float transMaxRange = rlIndicator.getWidth() - mainLine.getWidth();
                //设置滚动条移动
                mainLine.setTranslationX(transMaxRange * proportion);
            }
        });
    }
}
