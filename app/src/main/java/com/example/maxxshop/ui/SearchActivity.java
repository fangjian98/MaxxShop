package com.example.maxxshop.ui;

import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;

import com.example.maxxshop.R;
import com.example.maxxshop.base.BaseActivity;
import com.example.maxxshop.util.SearchDemoUtils;

import java.lang.reflect.Field;

public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener {

    private SearchView mMenuSearch;
    private LinearLayout containerView;

    @Override
    protected int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        containerView = findViewById(R.id.cat_search_view_suggestion_container);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected boolean shouldShowDefaultActionBar() {
        return true;
    }

    @Override
    protected int getDemoTitleResId() {
        return 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);

        // 获取SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        mMenuSearch = (SearchView) searchMenuItem.getActionView();

        mMenuSearch.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        mMenuSearch.setIconifiedByDefault(false);
        mMenuSearch.setOnQueryTextListener(this);
        mMenuSearch.setQueryHint(getString(R.string.app_name));

        if (mMenuSearch != null) {
            try {
                Class<?> argClass = mMenuSearch.getClass();

                //搜索框下划线
                Field mSearchSrcTextView = argClass.getDeclaredField("mSearchPlate");//通过反射，获得类对象的一个属性对象
                mSearchSrcTextView.setAccessible(true);//设置此私有属性是可访问的
                View view = (View) mSearchSrcTextView.get(mMenuSearch);//获得属性的值
                view.setBackground(null);//设置此view的背景

                //搜索框前图标
                Field mCollapsedIcon = argClass.getDeclaredField("mCollapsedIcon");
                mCollapsedIcon.setAccessible(true);
                ImageView collapsedIcon = (ImageView) mCollapsedIcon.get(mMenuSearch);
                collapsedIcon.setImageDrawable(null);

                //搜索框背景
                Field searchTextView = argClass.getDeclaredField("mSearchSrcTextView");
                searchTextView.setAccessible(true);
                TextView searchText = (TextView) searchTextView.get(mMenuSearch);
                searchText.setBackgroundResource(R.drawable.bg_searchview);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            mMenuSearch.onActionViewExpanded();
        }

        SearchDemoUtils.setUpSuggestions(containerView, mMenuSearch);

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        TextView textView = new TextView(this);
        textView.setText(newText);
        containerView.removeAllViews();
        containerView.addView(textView);
        return true;
    }
}
