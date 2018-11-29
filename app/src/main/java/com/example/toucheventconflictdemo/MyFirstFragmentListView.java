package com.example.toucheventconflictdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by hasee on 2018/1/13.
 */

public class MyFirstFragmentListView extends ListView{
    public MyFirstFragmentListView(Context context) {
        super(context);
    }

    public MyFirstFragmentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
