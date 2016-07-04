package com.example.aepl.fragment_tab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aepl on 27/6/16.
 */
public class BrandDetails extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.branddetails_fragment,container,false);
        TextView tv = (TextView)v.findViewById(R.id.country_details);
        Bundle b = getArguments();
        tv.setText("Details of " + BrandName.brand[b.getInt("position")]);
        return v;
    }
}
