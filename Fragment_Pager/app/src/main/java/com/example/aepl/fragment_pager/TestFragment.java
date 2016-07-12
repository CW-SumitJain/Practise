package com.example.aepl.fragment_pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aepl on 1/7/16.
 */
public class TestFragment extends Fragment {
    int position;
    TextView tab_text;
    public TestFragment() {
//        this.position = getArguments().getInt("position");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_layout,container,false);
        position = getArguments().getInt("position");
        position++;

        tab_text = (TextView)v.findViewById(R.id.tab_text);
        tab_text.setText("Selected Tab \n" + position);
        return v;

    }
}
