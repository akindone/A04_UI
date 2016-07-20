package com.jike.toolbar_fragment;

import android.app.Fragment;
import android.os.Bundle;

public class SingleFragActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_single_frag);
    }

    @Override
    Fragment buildFragment() {
        return new MyFragment();
    }
}
