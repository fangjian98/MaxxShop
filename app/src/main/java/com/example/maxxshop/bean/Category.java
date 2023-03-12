package com.example.maxxshop.bean;

import java.util.Arrays;
import java.util.List;

public class Category {

    private String mCategoryName;
    private List<String> mSubCategories;

    public Category(String categoryName, String subCategories) {
        mCategoryName = categoryName;
        mSubCategories = Arrays.asList(subCategories.split(","));
    }

    public String getCategoryName() { return mCategoryName; }

    public List<String> getSubCategories() { return mSubCategories; }

    public void setSubCategories(List<String> subCategories) { mSubCategories = subCategories; }
}


