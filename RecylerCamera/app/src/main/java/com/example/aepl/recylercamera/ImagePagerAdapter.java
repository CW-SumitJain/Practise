package com.example.aepl.recylercamera;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by aepl on 25/6/16.
 */
public class ImagePagerAdapter extends PagerAdapter{
    int[] list;
    ImageView imageView;
    public ImagePagerAdapter(int[] list) {
        this.list = list;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        imageView = new ImageView(container.getContext());
        imageView.setImageResource(list[position]);

        container.addView(imageView);
        /*LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemServiceName(Context.LAYOUT_INFLATER_SERVICE);
        imageView =(ImageView)container.findViewById(R.id.image_sl);
        imageView.setImageResource(list[position]);
        container.addView(imageView);
        imageView.setOnTouchListener(new multiTouch());*/
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        imageView.setOnTouchListener(new multiTouch());
        return imageView;
        //return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
