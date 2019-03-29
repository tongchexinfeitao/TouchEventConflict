package com.example.toucheventconflictdemo.fragment;

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
 * Created by hasee on 2018/1/12.购物车
 */

public class Fragment0 extends BaseLazyLoadFragment {

    private ListView listView;
    private List<String> userList = new ArrayList<>();//实体类
    @Override
    protected boolean setIsRealTimeRefresh() {
        return false;
    }


    @Override
    protected void initData() {

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

    }

    @Override
    protected void initView() {
        //对View中控件的操作方法
        listView = mRootView.findViewById(R.id.list_view);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.layout1;
    }
}

