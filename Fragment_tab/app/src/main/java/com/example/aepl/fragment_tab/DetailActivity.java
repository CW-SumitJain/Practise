package com.example.aepl.fragment_tab;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aepl on 27/6/16.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BrandDetails brandDetails = new BrandDetails();
        Bundle b = new Bundle();
        b.putInt("position",getIntent().getIntExtra("position",0));
        brandDetails.setArguments(b);
        fragmentTransaction.add(R.id.fl_details,brandDetails);
        fragmentTransaction.commit();
    }
}
