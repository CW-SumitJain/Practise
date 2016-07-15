package com.example.aepl.carwalenavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by aepl on 15/7/16.
 */
public class GalleryAcitivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    Toolbar gallery_tool;
    ViewPager gallery_pager;
    int position;
    int[] list;
    GalleryAdapter ga;
    int title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_view);
        gallery_tool = (Toolbar) findViewById(R.id.gallery_tool);
        gallery_pager = (ViewPager) findViewById(R.id.gallery_pager);
        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        list = intent.getExtras().getIntArray("list");

        ga = new GalleryAdapter(this,list,position);
        title = position+1;
        gallery_tool.setTitle("Image " + title + "/" + list.length);
        gallery_pager.setAdapter(ga);
        gallery_pager.setCurrentItem(position);
        gallery_pager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        title = position+1;
        gallery_tool.setTitle("Image " + title + "/" + list.length);
    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }
}
