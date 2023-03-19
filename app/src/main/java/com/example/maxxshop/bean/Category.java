package com.example.maxxshop.bean;

import java.util.List;

public class Category {

    private String mCategoryName;
    private List<SubCategory> mSubCategories;

    public Category(String categoryName, List<SubCategory> subCategories) {
        mCategoryName = categoryName;
        mSubCategories = subCategories;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public List<SubCategory> getSubCategories() {
        return mSubCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        mSubCategories = subCategories;
    }
}


