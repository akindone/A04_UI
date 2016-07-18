package com.jike.day02_layout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by wancc on 2016/3/6.
 */
//写一个类继承布局（title.xml里的根节点）
public class TitleLayout extends LinearLayout {
    //重写 LinearLayout 中带两个参数的构造函数
    public  TitleLayout(Context context, AttributeSet attrs){
        super(context, attrs);//要有父类的构造方法
        //在构造函数中需要对标题栏布局进行动态加载
        LayoutInflater.from(context).inflate(R.layout.title,this);

        //给button设置事件
        Button bt_back = (Button) findViewById(R.id.bt_back);
        Button bt_forward = (Button) findViewById(R.id.bt_forward);
        bt_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        bt_forward.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"向前",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
