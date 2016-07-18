package com.jike.calculator;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        setContentView(R.layout.activity_main);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        textView.setBackground(drawable);//这里会执行drawable.setCallback(this);这个this就是textview。
        // 如果textview有context，那么drawable也会有context的引用
        drawable.setCallback(null);
        



    }
}
