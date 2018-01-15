package com.example.toucheventconflictdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by hasee on 2018/1/13.
 */

public class MyTwoFragmentScrollView extends ScrollView {


    public MyTwoFragmentScrollView(Context context) {
        super(context);
    }

    public MyTwoFragmentScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    boolean intercepet = false;
    ListView mListView;
    private float mLastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        getChildListView();

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                super.onInterceptTouchEvent(ev);
                intercepet = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //满足listView滑动到顶部，如果继续下滑，那就让scrollView拦截事件
                if (mListView.getFirstVisiblePosition() ==0 && (ev.getY()-mLastY)>0) {
                    intercepet = true;
                }
                //满足listView滑动到底部，如果继续上滑，那就让scrollView拦截事件
                else if (mListView.getLastVisiblePosition() ==mListView.getCount()-1 && (ev.getY()-mLastY)<0) {
                    intercepet = true;
                } else {
                    intercepet = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepet = false;
                break;
        }


        mLastY =ev.getY();
        return intercepet;
    }

    public void getChildListView() {
        View childAt = getChildAt(0);
        if (childAt instanceof ListView) {
            mListView = (ListView) childAt;
        } else {
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                for (int i = 0; i < viewGroup.getChildCount() - 1; i++) {
                    View childAt1 = viewGroup.getChildAt(i);
                    if(childAt1 instanceof  ListView){
                        mListView = (ListView)childAt1;
                    }
                }
            }
        }
    }
}
