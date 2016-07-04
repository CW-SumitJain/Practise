package com.example.aepl.servicebroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by aepl on 29/6/16.
 */
public class HomeActivity extends AppCompatActivity implements DownloadData.sendToActivity{
    DrawerLayout drawerLayout;
    String menu[];
    ListView navigation_list;
    ArrayAdapter<String> arrayAdapter;
    private String uri = "http://www.carwale.com/webapi/newcardealers/cities/?makeid=10";
    Toolbar my_toolbar;
    ActionBarDrawerToggle actiontoggle;
    ArrayList<String > stateList;
    ArrayList<String> cityList;
    ArrayList<Item1> itms;

    @Override
    public void onBackPressed() {
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        DownloadData dData = new DownloadData(this);
        dData.execute(uri);
        my_toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        stateList = new ArrayList<String >();

        /*my_toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);*/
        /*ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.list_icon);
        ab.setDisplayHomeAsUpEnabled(true);*/


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.list_icon);


        menu = new String[]{"Menu 1","Menu 2", "Menu 3", "Menu 4"};


    }

    @Override
    public void onComplete(ArrayList<Item1> items) {
        this.itms = items;
        Log.d("TAG","Sumit " + items.get(0).getStateName());
        for(Item1 i:items){
            stateList.add(i.getStateName());
        }
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        navigation_list = (ListView)findViewById(R.id.navigation_list);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stateList);
        navigation_list.setAdapter(arrayAdapter);
//        drawerLayout.setScrimColor(ContextCompat.getColor(getApplicationContext(), android.R.color.background_light));
        getSupportActionBar().setTitle("Navigation_drawer");
        actiontoggle = new ActionBarDrawerToggle(this,drawerLayout,my_toolbar,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
//                getSupportActionBar().setTitle("Drawer");
            }
        };
        actiontoggle.setDrawerIndicatorEnabled(true);
        actiontoggle.setHomeAsUpIndicator(R.drawable.list_icon);
        drawerLayout.setDrawerListener(actiontoggle);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.list_icon);
        actiontoggle.syncState();
        navigation_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cityList = new ArrayList<String>();
                for(Cities c:itms.get(i).getCity()){
//                        Log.d("TAG","jain" + c.getCityName());
                    cityList.add(c.getCityName());
                }
                Intent intent = new Intent(HomeActivity.this,Menu1.class);
                    intent.putStringArrayListExtra("list",cityList);
                    intent.putExtra("item",stateList.get(i));
                    startActivity(intent);
                    drawerLayout.closeDrawers();



            }
        });

    }
}
