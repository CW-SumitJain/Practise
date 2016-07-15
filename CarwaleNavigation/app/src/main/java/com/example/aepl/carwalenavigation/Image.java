package com.example.aepl.carwalenavigation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by aepl on 14/7/16.
 */
public class Image extends PagerAdapter {
    ArrayList<String> img = new ArrayList<String>();
    Context mcontext;
    ImageView imageView;
    RelativeLayout rv;
    TextView tv;
    int list[] = new int[]{R.drawable.ic_arrow_drop_down,R.drawable.featured_icon,R.drawable.garage,R.drawable.multiple_offers};

    public Image(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        imageView = new ImageView(container.getContext());
        rv = new RelativeLayout(container.getContext());
        imageView.setImageResource(list[position]);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1200,1200));
        tv = new TextView(container.getContext());
        tv.setText("Helo");
        tv.setTextColor(Color.RED);
        rv.addView(imageView);
        rv.addView(tv);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(container.getContext(),"Clicked " + position,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(container.getContext(),GalleryAcitivity.class);
                intent.putExtra("list",list);
                intent.putExtra("position",position);
                container.getContext().startActivity(intent);
            }
        });
        container.addView(rv);
        return rv;
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
