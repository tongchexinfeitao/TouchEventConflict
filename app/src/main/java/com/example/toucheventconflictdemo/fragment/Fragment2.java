package com.example.toucheventconflictdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    private ListView listView;
    private List<String> userList = new ArrayList<String>();//实体类

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout2, container, false);
        //对View中控件的操作方法
        listView = view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
                    view = inflater.inflate(android.R.layout.simple_list_item_1,null);
                } else {
                    view = convertView;
                }
                TextView textView = (TextView)view.findViewById(android.R.id.text1);
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
}

