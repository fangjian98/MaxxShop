package com.example.maxxshop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ScrollView;

public class BounceScrollView extends ScrollView {

    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;

    private Context mContext;
    private int mMaxYOverscrollDistance;

    public BounceScrollView(Context context) {
        super(context);
        mContext = context;
        initBounceScrollView();
    }

    public BounceScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initBounceScrollView();
    }

    public BounceScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initBounceScrollView();
    }

    private void initBounceScrollView() {
        // get the density of the screen and do some maths with it on the max overscroll distance
        // variable so that you get similar behaviors no matter what the screen size is
        final DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        final float density = metrics.density;
        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
        setVerticalScrollBarEnabled(false);
    }

    /*@Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        int newDeltaY = deltaY;
        int delta = (int) (mMaxYOverscrollDistance / 2.5f);

        //可能是由于滑动速度过快而导致的卡顿，你可以尝试调整以下代码中的参数来减慢滑动速度：
        if (scrollY <= 0 && deltaY > 0) {
            newDeltaY = (int) (deltaY / 3f);
        } else if (scrollY >= scrollRangeY && deltaY < 0) {
            newDeltaY = (int) (deltaY / 3f);
        }
        return super.overScrollBy(deltaX, newDeltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);
    }*/

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        int newDeltaY = deltaY;
        int delta = (int) (mMaxYOverscrollDistance / 2.5f);

        if (scrollY <= 0 && deltaY > 0) {
            if (deltaY > delta) {
                newDeltaY = delta;
            }
        } else if (scrollY >= scrollRangeY && deltaY < 0) {
            if (Math.abs(deltaY) > delta) {
                newDeltaY =  -delta;
            }
        }
        return super.overScrollBy(deltaX, newDeltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);
    }
}