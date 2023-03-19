package com.example.maxxshop.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxxshop.R;
import com.example.maxxshop.adapter.CategoryAdapter;
import com.example.maxxshop.adapter.SubCategoryAdapter;
import com.example.maxxshop.bean.Category;
import com.example.maxxshop.bean.SubCategory;

import java.util.ArrayList;

public class TabItemContentFragment extends Fragment {

    private static final String TAB_NUMBER = "tab_number";
    private ListView mCategoryListView;
    private RecyclerView mSubCategoryListView;
    private CategoryAdapter mCategoryAdapter;
    private SubCategoryAdapter mSubCategoryAdapter;
    private ArrayList<Category> mCategoryList;

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

    private void initCategory(View view) {
        mCategoryListView = (ListView) view.findViewById(R.id.list_view_category);
        mSubCategoryListView = (RecyclerView) view.findViewById(R.id.list_view_sub_category);

        SubCategory subCategory1 = new SubCategory("title1", 0, true);
        SubCategory subCategory2 = new SubCategory("shop1", R.drawable.default_account_head, false);
        SubCategory subCategory3 = new SubCategory("shop2", R.drawable.default_account_head, false);
        SubCategory subCategory4 = new SubCategory("title2", 0, true);
        SubCategory subCategory5 = new SubCategory("shop3", R.drawable.default_account_head, false);
        ArrayList<SubCategory> all = new ArrayList<>();
        all.add(subCategory1);
        all.add(subCategory2);
        all.add(subCategory3);
        all.add(subCategory4);
        all.add(subCategory5);

        mCategoryList = new ArrayList<Category>();
        int i = 20;
        while (i != 0) {
            mCategoryList.add(new Category("Electronics", all));
            mCategoryList.add(new Category("Fashion", all));
            i--;
        }

        mCategoryAdapter = new CategoryAdapter(getActivity(), mCategoryList);
        mCategoryListView.setAdapter(mCategoryAdapter);

        ArrayList<SubCategory> defaultSubCategories = new ArrayList<>(mCategoryList.get(0).getSubCategories());
        mSubCategoryAdapter = new SubCategoryAdapter(defaultSubCategories);
        //mSubCategoryListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mSubCategoryListView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL,false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mSubCategoryAdapter.getItemViewType(position) == SubCategoryAdapter.VIEW_TYPE_HEADER) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        mSubCategoryListView.setLayoutManager(layoutManager);
        mSubCategoryListView.setAdapter(mSubCategoryAdapter);

        mCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<SubCategory> clickSubCategories = new ArrayList<>(mCategoryList.get(position).getSubCategories());
                mSubCategoryAdapter.updateCategory(clickSubCategories);
            }
        });
    }
}
