package com.example.aepl.servicebroadcast;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aepl on 28/6/16.
 */
public class StateListAdapter extends BaseAdapter{
    ArrayList<String >statelist;
    ArrayList<Item1> items;
    LayoutInflater inflater;
    ArrayList<String> cityList;

    public StateListAdapter(ArrayList<String> statelist, ArrayList<Item1> items, LayoutInflater inflater) {
        this.statelist  = statelist;
        this.items = items;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return statelist.size();
    }

    @Override
    public String getItem(int i) {
        return statelist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        String data = getItem(i);
        view  = inflater.inflate(R.layout.listview,viewGroup,false);
        TextView tview = (TextView)view.findViewById(R.id.tview);
        LinearLayout   list = (LinearLayout)view.findViewById(R.id.list);
//        list.addView(tview);
        tview.setText(data);
        Log.d("TAG","hello " + data);
        for(final Cities c:items.get(i).getCity()){
//            View cityview  = inflater.inflate(R.layout.citylistview,(ViewGroup)view,true);
            final TextView tvCity = new TextView(viewGroup.getContext());
//            TextView tvCity = (TextView)cityview.findViewById(R.id.textView);
            tvCity.setText(c.getCityName());
            final String name = c.getCityName();
            list.addView(tvCity);
            tvCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(viewGroup.getContext(),name,Toast.LENGTH_SHORT).show();
                }
            });

//            Log.d("TAG",data + " " + c.getCityName());
        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(R.layout.citylistview,)

        tview.setText(data);
        return view;
    }
}
