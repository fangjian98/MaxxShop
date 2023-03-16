package com.example.maxxshop.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.CategoryAdapter;
import com.example.maxxshop.adapter.SubCategoryAdapter;
import com.example.maxxshop.bean.Category;

import java.util.ArrayList;

public class TabItemContentFragment extends Fragment {
    private static final String TAB_NUMBER = "tab_number";

    public TabItemContentFragment() {
    }

    public static TabItemContentFragment newInstance(int tabNumber) {
        TabItemContentFragment fragment = new TabItemContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TAB_NUMBER, tabNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.double_list_layout, viewGroup, false /* attachToRoot */);
        //int tabNumber = getArguments().getInt(TAB_NUMBER, -1);

        initCategory(view);

        return view;
    }

    private ListView mCategoryListView;
    private ListView mSubCategoryListView;
    private CategoryAdapter mCategoryAdapter;
    private SubCategoryAdapter mSubCategoryAdapter;
    private ArrayList<Category> mCategoryList;

    private void initCategory(View view) {
        mCategoryListView = (ListView) view.findViewById(R.id.list_view_category);
        mSubCategoryListView = (ListView) view.findViewById(R.id.list_view_sub_category);

        mCategoryList = new ArrayList<Category>();
        int i = 20;
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
