package com.example.maxxshop.ui;

import com.example.maxxshop.R;
import com.example.maxxshop.base.BaseFragment;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

public class AccountFragment extends BaseFragment {
    @Override
    protected int getContentView() {
        return R.layout.layout_account_fragment;
    }

    @Override
    protected void initView() {
        ShapeableImageView iconView = mRootView.findViewById(R.id.image_view);
        iconView.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());

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
        return R.string.shop_tabs_label_account;
    }
}
