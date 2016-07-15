package com.example.aepl.carwalenavigation;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by aepl on 15/7/16.
 */
public class GalleryAdapter extends PagerAdapter implements View.OnTouchListener{
    Context context;
    int[] list;
    ImageView ig;
    int position;
    boolean zoom;
    public GalleryAdapter(Context context, int[] list, int position) {
        this.context = context;
        this.position = position;
        this.list  = list;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ig = new ImageView(container.getContext());
        ig.setImageResource(list[position]);
        container.addView(ig);
        zoom = false;
//        ig.setOnTouchListener(this);
        return ig;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                Log.d("down","down" + ig.getWidth() + "  " + ig.getHeight());

                break;
            case MotionEvent.ACTION_UP:
                if(!zoom){
//                    ig.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    float x = ig.getScaleX();
                    float y = ig.getScaleY();
                    ig.setScaleX((float)x+0.2f);
                    ig.setScaleY((float)y+0.2f);
                    zoom =true;
                    Log.d("up","up 1");

                }
                else
                {
                    float x = ig.getScaleX();
                    float y = ig.getScaleY();
                    ig.setScaleX((float)x-0.2f);
                    ig.setScaleY((float)y-0.2f);
                    zoom=false;
                    Log.d("up","up 2");
                }

//                ig.setLayoutParams(new LinearLayout.LayoutParams(100,100));

                break;
            default:
                Log.d("Default","default");
        }
        return true;
    }
}
