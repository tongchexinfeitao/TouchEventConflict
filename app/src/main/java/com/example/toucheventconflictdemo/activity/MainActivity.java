package com.example.toucheventconflictdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.toucheventconflictdemo.FragAdapter;
import com.example.toucheventconflictdemo.R;
import com.example.toucheventconflictdemo.fragment.Fragment1;
import com.example.toucheventconflictdemo.fragment.Fragment2;
import com.example.toucheventconflictdemo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        //构造适配器
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);
    }
}
