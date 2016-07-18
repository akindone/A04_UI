package com.jike.demo_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendNotification(View v){
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //设置通知的显示图标，文字信息，显示时间
        Notification notification = new Notification(R.mipmap.ic_launcher, "This is ticker text", System.currentTimeMillis());
        //点击通知后跳转到某个活动
        Intent intent = new Intent(this, Main2Activity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		/*
		PendingIntent的flag：
		- FLAG_ONE_SHOT 系统只发一次intent
		- FLAG_NO_CREATE 不能先点，跟风者
		- FLAG_UPDATE_CURRENT replace extra data
		- FLAG_CANCEL_CURRENT:如果之前的intent没有cancle，则无法使用新的一个intent*/

        //设置通知的信息（上下文，标题，内容，延时跳转的intent）
        notification.setLatestEventInfo(this, "This is content title", "This is content text", pi);
        //让管理器去显示通知（每个通知都有一个唯一的id，notification对象）
        manager.notify(1, notification);
    }
}
