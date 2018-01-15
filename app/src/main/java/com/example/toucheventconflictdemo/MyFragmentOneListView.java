package com.example.toucheventconflictdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by hasee on 2018/1/13.
 */

public class MyFragmentOneListView  extends ListView{
    public MyFragmentOneListView(Context context) {
        super(context);
    }

    public MyFragmentOneListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
