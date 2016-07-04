package com.example.aepl.recyclerview;

import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aepl on 24/6/16.
 */
public class ImagePagerAdapter extends PagerAdapter{
    private int[] list;
    private ImageView imageview;

    public ImagePagerAdapter(int[] images) {
        this.list = images;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(images.remove(position));
        //container.removeView(images.get(position));
        ((ViewPager)container).removeView((View)object);
        //super.destroyItem(container, position, object);
    }



        /* @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(images.get(position));
//        (ViewPager)container.removeView();
    }*/

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //ImageView imageview = images.get(position);
        imageview = new ImageView(container.getContext());
        imageview.setImageResource(list[position]);

        container.addView(imageview);
//        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageview;

    }



    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
