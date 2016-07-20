package com.jike.toolbar_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wancc on 2016/7/20.
 */
public class MyFragment extends Fragment {

    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.my_fragment, null);
        toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);

        toolbar.setTitle("NEW TITLE");

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return inflate;
    }


}
