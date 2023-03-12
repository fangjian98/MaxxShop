package com.example.maxxshop.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.CategoryAdapter;
import com.example.maxxshop.adapter.SubCategoryAdapter;
import com.example.maxxshop.base.BaseFragment;
import com.example.maxxshop.bean.Category;

import java.util.ArrayList;

public class ClassFragment extends BaseFragment {

    private ListView mCategoryListView;
    private ListView mSubCategoryListView;

    private CategoryAdapter mCategoryAdapter;
    private SubCategoryAdapter mSubCategoryAdapter;

    private ArrayList<Category> mCategoryList;
    @Override
    protected int getContentView() {
        return R.layout.layout_class_fragment;
    }

    @Override
    protected void initView() {
        mCategoryListView = (ListView) mRootView.findViewById(R.id.list_view_category);
        mSubCategoryListView = (ListView) mRootView.findViewById(R.id.list_view_sub_category);
    }

    @Override
    protected void initData() {
        mCategoryList = new ArrayList<Category>();
        int i = 5;
        while (i != 0) {
            mCategoryList.add(new Category("Electronics", "TV, Audio"));
            mCategoryList.add(new Category("Fashion", "Clothing, Accessories"));
            i--;
        }

        mCategoryAdapter = new CategoryAdapter(getActivity(), mCategoryList);
        mCategoryListView.setAdapter(mCategoryAdapter);

        ArrayList<String> defaultSubCategories = new ArrayList<>(mCategoryList.get(0).getSubCategories());

        mSubCategoryAdapter = new SubCategoryAdapter(this.getActivity(), defaultSubCategories);
        mSubCategoryListView.setAdapter(mSubCategoryAdapter);

        mCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> clickSubCategories = new ArrayList<>(mCategoryList.get(position).getSubCategories());
                mSubCategoryAdapter.updateCategory(clickSubCategories);
            }
        });

    }
}
