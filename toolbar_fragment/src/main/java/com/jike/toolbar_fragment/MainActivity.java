package com.jike.toolbar_fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public abstract class MainActivity extends AppCompatActivity {

    public static final String TAG_FRAGMENT ="MyFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(android.R.id.content,buildFragment(),TAG_FRAGMENT);
        fragmentTransaction.commit();

    }

    abstract Fragment buildFragment() ;
}
