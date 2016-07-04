package com.example.aepl.camera_grid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by aepl on 23/6/16.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<String> itemList = new ArrayList<String>();
    ArrayList<Bitmap> imageList = new ArrayList<Bitmap>();

   // LayoutInflater inflater;


    public ImageAdapter(Context context) {

        mContext = context;
      //this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void add(String path){
        itemList.add(path);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    public void add_image(Bitmap bitmap)
    {
        Log.d("TAG","added");
        imageList.add(bitmap);
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(420, 420));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(imageList.get(position));
        return imageView;*//*
    if(convertView == null) {
        convertView = inflater.inflate(R.layout.activity_image,null);
        imageView = (ImageView) convertView.findViewById(R.id.image_view);

        //convertView.setTag(imageView);
    }
        else{
        imageView = (ImageView) convertView.getTag();
    }
        imageView.setImageBitmap(imageList.get(position));
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //Bitmap bm = decodeSampledBitmapFromUri(imageList.get(position), 220, 220);

        //imageView.setImageBitmap(imageList.get(position));
        return convertView;*/
        ImageView imageview;
        View row = convertView;
        Viewholder view_holder;
        if(row == null)
        {
            view_holder = new Viewholder();
            LayoutInflater inflater =  ((Activity)mContext).getLayoutInflater();
            row = inflater.inflate(R.layout.activity_image,null);
            view_holder.imageview = (ImageView)row.findViewById(R.id.image_view);
            row.setTag(view_holder);

        }
        else{
            view_holder = (Viewholder) row.getTag();
        }
        view_holder.imageview.setImageBitmap(imageList.get(position));
        return row;
    }

    private  static class Viewholder{
        static ImageView imageview;
    }

    /*public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {

        Bitmap bm = null;
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }

        return inSampleSize;
    }*/

}
