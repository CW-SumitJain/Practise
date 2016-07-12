package com.example.aepl.collapsingtoolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    CollapsingToolbarLayout collapsing_toolbar;
    Bitmap tool_image;
    ArrayAdapter arrayAdapter;
    Toolbar toolbar;
    ArrayList<String> list = new ArrayList<String>();
    FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        listView = (ListView)findViewById(R.id.listView);
        add = (FloatingActionButton)findViewById(R.id.add);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        list.add("Item 6");
        list.add("Item 7");
        list.add("Item 8");
        list.add("Item 9");
        list.add("Item 10");
        list.add("Item 11");

        /*arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
        Log.d("Size",""+ list.size());
        listView.setAdapter(arrayAdapter);*/
        RecyclerView recycle_grid = (RecyclerView) findViewById(R.id.recycle_grid);
        RecycleAdapter recycleAdapter = new RecycleAdapter(list,this);
        /*RecyclerView.LayoutManager layout_grid = new GridLayoutManager(getApplicationContext(),1);
        recycle_grid.setLayoutManager(layout_grid);*/
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycle_grid.setLayoutManager(llm);

        recycle_grid.setAdapter(recycleAdapter);

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeButtonEnabled(true);

        actionbar.setDisplayHomeAsUpEnabled(true);
//        actionbar.setIcon(R.drawable.add);
        collapsing_toolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Collapsing Animation");

//        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.collapse);
        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.expand);
        collapsing_toolbar.setContentScrimColor(Color.GREEN);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collapsing_toolbar.setContentScrimColor(Color.YELLOW);

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
