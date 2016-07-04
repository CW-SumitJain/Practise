package com.example.aepl.recylercamera;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by aepl on 25/6/16.
 */
public class ImagePager extends AppCompatActivity{
    int position;
    int[] list;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("position",position);
        outState.putIntArray("list",list);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if(savedInstanceState != null){
            list = savedInstanceState.getIntArray("list");
            position = savedInstanceState.getInt("position");
        }
        else {

            Intent intent = getIntent();
            position = intent.getExtras().getInt("position");
            list = intent.getExtras().getIntArray("list");
        }*/
        if(savedInstanceState == null){
            Intent intent = getIntent();
            position = intent.getExtras().getInt("position");
            list = intent.getExtras().getIntArray("list");
            Toast.makeText(getApplication(),"NULL",Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.view_pager);
//        Log.d("TAG","Size + " + list.length);
        ImagePagerAdapter pageradapter = new ImagePagerAdapter(list);
        ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
//        pageradapter.notifyDataSetChanged();
        viewpager.setAdapter(pageradapter);

        // Show images following the position
        viewpager.setCurrentItem(position);

    }
}
