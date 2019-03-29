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

public class Fragment2 extends Fragment {
    public static final String className = Fragment2.class.getName();
    private ListView listView;
    private List<String> userList = new ArrayList<String>();//实体类

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", className + "========   onCreateView");
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout2, container, false);
        //对View中控件的操作方法
        listView = view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("TAG", className + "========   onActivityCreated");
        //模拟数据库
        for (int i = 0; i < 36; i++) {
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
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("TAG", className + "========   setUserVisibleHint " + isVisibleToUser);
    }
}

