package com.example.toucheventconflictdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.toucheventconflictdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2018/1/12.
 */

public class Fragment1 extends Fragment {

    public String testData = "我是数据还没被赋值";
    private boolean mIsFirstGetData =true;
    private boolean mIsVisibleToUser;
    private View mRootView;

    public static final String className = Fragment1.class.getName();

    private ListView listView;
    private List<String> userList = new ArrayList<>();//实体类

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.e("TAG", className + "========   onCreateView  ");
        //在viewpager中，当前fragment之前显示过，view被销毁后，
        // 如果再次显示如果不判空知己恩创建的话，数据也必须更新，不然新的view不会被赋值，是空白
        if(mRootView ==null) {
            // TODO Auto-generated method stub
            mRootView = inflater.inflate(R.layout.layout1, container, false);
            //对View中控件的操作方法
            listView = mRootView.findViewById(R.id.list_view);
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        if (mIsFirstGetData && mIsVisibleToUser && mRootView != null) {
//            mIsFirstGetData = false;
            testData = "我是数据  我被赋值啦";
            Log.e("TAG", className + "======== onActivityCreated中请求数据 ");

            //模拟数据库
            for (int i = 0; i < 18; i++) {
                userList.add("item " + i);
            }
            BaseAdapter adapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    // TODO Auto-generated method stub
                    return userList.size();//数目
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    View view;

                    if (convertView == null) {
                        //因为getView()返回的对象，adapter会自动赋给ListView
                        view = inflater.inflate(android.R.layout.simple_list_item_1, null);
                    } else {
                        view = convertView;
                    }
                    TextView textView = (TextView) view.findViewById(android.R.id.text1);
                    textView.setText(userList.get(position));


                    return view;
                }

                @Override
                public long getItemId(int position) {//取在列表中与指定索引对应的行id
                    return 0;
                }

                @Override
                public Object getItem(int position) {//获取数据集中与指定索引对应的数据项
                    return null;
                }
            };

            listView.setAdapter(adapter);

//        }
        Log.e("TAG", className + "========   onActivityCreated  = ==  " + testData);



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("TAG", className + "========   onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", className + "========   onCreate");
    }

    @Override
    public void onStart() {
        Log.e("TAG", className + "========   onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("TAG", className + "========   onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("TAG", className + "========   onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("TAG", className + "========   onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("TAG", className + "========   onDestroyView");
        super.onDestroyView();
//        mRootView = null;
    }

    @Override
    public void onDestroy() {
        Log.e("TAG", className + "========   onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("TAG", className + "========   onDetach");
        super.onDetach();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        mIsVisibleToUser = isVisibleToUser;
        super.setUserVisibleHint(mIsVisibleToUser);
        Log.e("TAG", className + "========   setUserVisibleHint " + isVisibleToUser);

        if (mIsFirstGetData && mIsVisibleToUser && mRootView != null) {
            mIsFirstGetData = false;
            Log.e("TAG", className + "========   setUserVisibleHint中请求数据  = ==  " + testData);

        }

    }
}

