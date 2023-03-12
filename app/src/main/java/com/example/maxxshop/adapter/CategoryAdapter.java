package com.example.maxxshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.maxxshop.R;
import com.example.maxxshop.bean.Category;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {

    private ArrayList<Category> mCategories;
    private Context mContext;

    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
        mCategories = categories;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.category_list_item, parent, false);
        }

        TextView categoryName = (TextView) convertView.findViewById(R.id.category_name);
        categoryName.setText(mCategories.get(position).getCategoryName());

        return convertView;
    }
}


