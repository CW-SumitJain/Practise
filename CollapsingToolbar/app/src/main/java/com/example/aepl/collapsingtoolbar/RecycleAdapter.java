package com.example.aepl.collapsingtoolbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aepl on 6/7/16.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.HolderView> {
    ArrayList<String> list;
    Context mcontext;
    public RecycleAdapter(ArrayList<String> list,Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @Override
    public RecycleAdapter.HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(mcontext).inflate(R.layout.display_items,parent,false);

        return new RecycleAdapter.HolderView(inflater);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.HolderView holder, int position) {

        holder.tview.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class HolderView extends RecyclerView.ViewHolder {
        TextView tview;
        public HolderView(View itemView) {
            super(itemView);
            tview = (TextView)itemView.findViewById(R.id.tview);
        }
    }
}
