package com.jike.animtextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private long totalSize;
    private DifferentSizeTextView dstv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dstv = (DifferentSizeTextView) findViewById(R.id.dstv);

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (totalSize<1<<60){
                    try {
                        Thread.sleep(200);
                        final long random = (long) (Math.random() * 1024 * 1024);
                        totalSize +=random;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Animators may only be run on Looper threads
                                dstv.startAnim(totalSize-random,totalSize,200);
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
}
