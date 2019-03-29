package com.example.toucheventconflictdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by hasee on 2018/1/13.
 */

public class MyThirdFragmentListView extends ListView {
    public MyThirdFragmentListView(Context context) {
        super(context);
    }

    public MyThirdFragmentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private float mLastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //不允许上层viewGroup拦截事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                //满足listView滑动到顶部，如果继续下滑，那就让scrollView拦截事件
                if (getFirstVisiblePosition() == 0 && (ev.getY() - mLastY) > 0) {
                    //允许上层viewGroup拦截事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                //满足listView滑动到底部，如果继续上滑，那就让scrollView拦截事件
                else if (getLastVisiblePosition() == getCount() - 1 && (ev.getY() - mLastY) < 0) {
                    //允许上层viewGroup拦截事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    //不允许上层viewGroup拦截事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                //不允许上层viewGroup拦截事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }

        mLastY = ev.getY();
        return super.dispatchTouchEvent(ev);
    }
}
