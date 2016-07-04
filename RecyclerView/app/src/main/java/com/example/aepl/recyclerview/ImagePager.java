package com.example.aepl.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aepl on 24/6/16.
 */
public class ImagePager extends AppCompatActivity {
    int position;
   int[] list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
       // list = intent.getIntArrayExtra("list");
        list = intent.getExtras().getIntArray("list");
        Log.d("TAG","list size " +  position);

      /*  Object[] l =    (Object[]) intent.getExtras().get("list");
        Integer[] list = (Integer[]) Arrays.copyOf(l,l.length);*/
//        RecycleAdapter imageAdapter = new RecycleAdapter(this);
//        List<ImageView> images = new ArrayList<ImageView>();
//        Log.d("TAG","size image" + list.length);
        /*ImageView imageView;
        for (int i = 0; i < list.size(); i++) {
            imageView = new ImageView(this);
//            imageView.setImageResource(imageAdapter.image_list[position]);
            imageView.setImageResource(list.get(i));
           *//* ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = 40;
            layoutParams.width = 40;
            imageView.setLayoutParams(layoutParams);*//*
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

//            images.add(imageView);
        }*/

        // Set the images into ViewPager
        ImagePagerAdapter pageradapter = new ImagePagerAdapter(list);
        ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
        pageradapter.notifyDataSetChanged();
        viewpager.setAdapter(pageradapter);

        // Show images following the position
        viewpager.setCurrentItem(position);



    }
}
