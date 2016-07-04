package com.example.aepl.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aepl on 24/6/16.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.HolderView>{
    Context mContext;
    String text;
    public Integer[] image_list= {R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,R.drawable.index,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};
    
    public RecycleAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecycleAdapter.HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
//        mContext = parent.getContext();
        View inflater = LayoutInflater.from(mContext).inflate(R.layout.grid_view,parent,false);

        return new RecycleAdapter.HolderView(inflater);
    }

    @Override
    public void onBindViewHolder(HolderView holder, int position) {
        holder.image_grid.setImageResource(image_list[position]);
       text = "image"+ position;
        holder.tv_text.setText(text);


    }



    @Override
    public int getItemCount() {
        return image_list.length;
    }

    public class HolderView extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image_grid;
        TextView tv_text;
        public HolderView(final View itemView) {
            super(itemView);
            image_grid = (ImageView) itemView.findViewById(R.id.grid_image);
            tv_text = (TextView)itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(HolderView.this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(),ImagePager.class);
            intent.putExtra("position",getAdapterPosition());
            intent.putExtra("list",image_list);
            Log.d("TAG","size recycle " + image_list.length);
            //intent.putParcelableArrayListExtra("list",image_list);
            view.getContext().startActivity(intent);
//            Toast.makeText(view.getContext(),"image"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }
    }
}
