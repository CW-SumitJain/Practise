package com.example.aepl.grid_image;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by aepl on 22/6/16.
 */
public class GridAdapter extends BaseAdapter {
    private Context c;
    public GridAdapter(Context context) {
        this.c = context;
    }


    @Override
    public int getCount() {
        return src.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public Integer[] src = {R.drawable.car2,R.drawable.car1,R.drawable.car3,R.drawable.a1,R.drawable.a3,R.drawable.a4,R.drawable.car4,R.drawable.car2,R.drawable.car1,R.drawable.car3,R.drawable.a1,R.drawable.a3,R.drawable.a4,R.drawable.car4};
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageview;
        if(view == null){
            imageview = new ImageView(c);
            imageview.setLayoutParams(new GridView.LayoutParams(385,385));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageview.setPadding(8,8,8,8);
        }
        else{
            imageview = (ImageView) view;

        }
        imageview.setImageResource(src[i]);
        view = imageview;
        return view;
    }
}
