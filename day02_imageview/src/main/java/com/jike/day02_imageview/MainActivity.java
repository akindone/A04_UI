package com.jike.day02_imageview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;


    private ImageView imageView;
    private ProgressBar pb_1;
    private ProgressBar pb_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.bt_1);
        button2 = (Button) findViewById(R.id.bt_2);
        button3 = (Button) findViewById(R.id.bt_3);
        button4 = (Button) findViewById(R.id.bt_4);
        button5 = (Button) findViewById(R.id.bt_5);
        button6 = (Button) findViewById(R.id.bt_6);

        pb_1 = (ProgressBar) findViewById(R.id.pb_1);
        pb_2 = (ProgressBar) findViewById(R.id.pb_2);



        imageView = (ImageView) findViewById(R.id.img);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_1:
                imageView.setImageResource(R.mipmap.icon1);
                break;
            case R.id.bt_2:
                imageView.setImageResource(R.mipmap.icon2);
                break;
            case R.id.bt_3:
                if (pb_1.getVisibility()==View.GONE){
                    pb_1.setVisibility(View.VISIBLE);
                } else {
                    pb_1.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_4:
                pb_2.setProgress(pb_2.getProgress()+10);
                break;
            case R.id.bt_5:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("这是一个警告框");
                dialog.setMessage("警告：是否要关闭该页面？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "页面即将关闭", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "页面不会关闭", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                break;
            case R.id.bt_6:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("这是一个进度条框");
                progressDialog.setMessage("请耐心等待");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}







