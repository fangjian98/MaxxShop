package com.example.maxxshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.maxxshop.R;
import com.example.maxxshop.bean.SubCategory;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private List<SubCategory> mData;

    public SubCategoryAdapter(List<SubCategory> data) {
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_item, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SubCategory sectionOrItem = mData.get(position);
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.headerTextView.setText(sectionOrItem.getTitle());
        } else {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.itemTextView.setText(sectionOrItem.getTitle());
            itemViewHolder.itemIcon.setImageResource(sectionOrItem.getIconId());
            itemViewHolder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.util.Log.e("fangjian","setOnClickListener position="+position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).isHeader()) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }

    public void updateCategory(List<SubCategory> data) {
        mData = data;
        notifyDataSetChanged();
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTextView;

        HeaderViewHolder(View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.headerTextView);
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemTextView;
        ImageView itemIcon;
        RelativeLayout item;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemIcon = itemView.findViewById(R.id.itemIcon);
            item = itemView.findViewById(R.id.item);
        }
    }

}



