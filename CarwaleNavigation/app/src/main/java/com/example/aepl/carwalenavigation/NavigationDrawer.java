package com.example.aepl.carwalenavigation;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aepl on 14/7/16.
 */
public class NavigationDrawer extends Fragment {
    static NavigationDrawer navigate = new NavigationDrawer();
    View view;
    Context mcontext;
    TextView newscars,usedcars,usedfind,usedcompare,newfind,newcompare;
    ImageView usedcarsdrop,newcarsdrop;

    public static NavigationDrawer getInstance(){
        return navigate;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        mcontext  = context;

    }

    @Override
    public void onResume() {
        super.onResume();
        newfind.setVisibility(View.GONE);
        newcompare.setVisibility(View.GONE);
        newcarsdrop.setImageResource(R.drawable.icon_play);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.navigation,container,false);
        newscars = (TextView) view.findViewById(R.id.newcars);
        usedcars = (TextView)view.findViewById(R.id.usedcars);
        usedcarsdrop = (ImageView) view.findViewById(R.id.usedcarsdrop);
        newcarsdrop = (ImageView) view.findViewById(R.id.newcarsdrop);
        usedfind = (TextView)view.findViewById(R.id.usedfind);
        newfind = (TextView)view.findViewById(R.id.newfind);
        usedcompare = (TextView)view.findViewById(R.id.usedcompare);
        newcompare = (TextView)view.findViewById(R.id.newcompare);


        newscars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newfind.getVisibility() == View.GONE) {
                    newfind.setVisibility(View.VISIBLE);
                    newcompare.setVisibility(View.VISIBLE);
                    newcarsdrop.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    newfind.setVisibility(View.GONE);
                    newcompare.setVisibility(View.GONE);
                    newcarsdrop.setImageResource(R.drawable.icon_play);
                }

            }
        });

//        view = LayoutInflater.from(mcontext).inflate(R.layout.navigation,null);
        return view;
    }
}
