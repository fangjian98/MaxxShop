package com.example.maxxshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class MyRecyclerAdapter<T> extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<T> mDataList;
    private int mLayoutId;
    private OnItemClickListener mItemClickListener;

    public MyRecyclerAdapter(List<T> dataList, int layoutId) {
        mDataList = dataList;
        mLayoutId = layoutId;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mItemClickListener.onItemClick(position);
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        T item = mDataList.get(position);
        // 绑定数据到View
        // holder.textView.setText(item.getTitle());
        // holder.imageView.setImageResource(item.getImageResId());
        // ...
        bindView(holder,mDataList.get(position));
    }
    public abstract void bindView(ViewHolder holder, T obj);

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 定义ViewHolder中的控件对象
        // TextView textView;
        // ImageView imageView;
        // ...

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // 初始化控件对象
            // textView = itemView.findViewById(R.id.tv_title);
            // imageView = itemView.findViewById(R.id.iv_image);
            // ...
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

