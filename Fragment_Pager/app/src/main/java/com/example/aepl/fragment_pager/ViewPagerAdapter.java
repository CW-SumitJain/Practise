package com.example.aepl.fragment_pager;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by aepl on 1/7/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    TestFragment testFragment;
    Bundle args;
    private int num_tabs;
    Context mcontext;
    public ViewPagerAdapter(FragmentManager fm, int num_tabs, Context mcontext) {
        super(fm);
        this.num_tabs   = num_tabs;
        this.mcontext = mcontext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                testFragment = new TestFragment();
                args = new Bundle();
                args.putInt("position",position);
//                Fragment.instantiate(mcontext,TestFragment.class.getName(),args);
                testFragment.setArguments(args);

                return  testFragment;
            case 1:
                testFragment = new TestFragment();
                args = new Bundle();
                args.putInt("position",position);
                testFragment.setArguments(args);
                return  testFragment;
            case 2:
                testFragment = new TestFragment();
                args = new Bundle();
                args.putInt("position",position);
                testFragment.setArguments(args);
                return  testFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return num_tabs;
    }
}
