package com.jike.demo_notification;

import android.app.NotificationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class Main2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //跳转到新页面后要cancel通知
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);//参数是之前通知的id
    }
}
