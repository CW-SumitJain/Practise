package com.example.aepl.carwalenavigation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    FrameLayout drawer;
    FragmentManager fragmentManager;
    DrawerLayout drawer_layout;
    FragmentTransaction fragmentTransaction;
    ActionBarDrawerToggle actiontoggle;
    ViewPager viewpager;
    Image iadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setTitle("NavigationTest");
        drawer = (FrameLayout)findViewById(R.id.drawer);
        initDrawer();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        NavigationDrawer fragment = NavigationDrawer.getInstance();
        fragmentTransaction.add(R.id.drawer,fragment);
        fragmentTransaction.commit();


        viewpager = (ViewPager)findViewById(R.id.viewpager);
        iadapter  = new Image(this);
        viewpager.setAdapter(iadapter);


        drawer.setBackgroundColor(getResources().getColor(R.color.drawer));


    }

    private void initDrawer() {
        actiontoggle = new ActionBarDrawerToggle(this,drawer_layout,toolbar, R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }
        };
        actiontoggle.setDrawerIndicatorEnabled(true);
        actiontoggle.syncState();
//        drawer_layout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}
