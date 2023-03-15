package com.example.maxxshop.ui;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.MyRecyclerAdapter;
import com.example.maxxshop.base.BaseFragment;
import com.example.maxxshop.bean.Icon;

import java.util.ArrayList;

public class CartFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    MyRecyclerAdapter myRecyclerAdapter;

    @Override
    protected int getContentView() {
        return R.layout.layout_cart_fragment;
    }

    @Override
    protected void initView() {
        mRecyclerView = mRootView.findViewById(R.id.recycler_view);

    }

    @Override
    protected void initData() {

        ArrayList<Icon> mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.ic_launcher, "图标1"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标2"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标3"));
        mData.add(new Icon(R.mipmap.ic_launcher, "图标4"));
        myRecyclerAdapter = new MyRecyclerAdapter<Icon>(mData,R.layout.recycle_view_item) {

            @Override
            public void bindView(ViewHolder holder, Icon obj) {
               ((ImageView)holder.itemView.findViewById(R.id.goods_img)).setImageResource(obj.getId());
                ((TextView)holder.itemView.findViewById(R.id.goods_title)).setText(obj.getName());

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(myRecyclerAdapter);

    }

    @Override
    protected boolean shouldShowDefaultActionBar() {
        return true;
    }

    @Override
    protected int getDemoTitleResId() {
        return R.string.shop_tabs_label_cart;
    }
}
