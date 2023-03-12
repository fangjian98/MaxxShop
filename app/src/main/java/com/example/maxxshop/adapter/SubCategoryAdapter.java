package com.example.maxxshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.maxxshop.R;

import java.util.ArrayList;

public class SubCategoryAdapter extends ArrayAdapter<String> {

    private ArrayList<String> mSubCategories;
    private Context mContext;

    public SubCategoryAdapter(Context context, ArrayList<String> subCategories) {
        super(context, 0, subCategories);
        mSubCategories = subCategories;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.category_list_item, parent, false);
        }

        TextView subCategoryName = (TextView) convertView.findViewById(R.id.category_name);
        subCategoryName.setText(mSubCategories.get(position));

        return convertView;
    }

    public void updateCategory(ArrayList<String> subCategories) {
        mSubCategories.clear();
        mSubCategories.addAll(subCategories);
        notifyDataSetChanged();
    }
}


