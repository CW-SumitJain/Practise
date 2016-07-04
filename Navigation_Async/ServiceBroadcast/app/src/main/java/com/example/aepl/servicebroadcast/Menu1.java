package com.example.aepl.servicebroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aepl on 29/6/16.
 */
public class Menu1 extends AppCompatActivity{
    TextView tview;
    ArrayList<String> cityList;
    ListView cList;
    ArrayAdapter<String> arrayAdapter;
    Toolbar my_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        cityList = new ArrayList<String >();
        cList = (ListView)findViewById(R.id.cList);

        cityList = getIntent().getExtras().getStringArrayList("list");
        my_toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        my_toolbar.setTitle(getIntent().getExtras().getString("item"));
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityList);
        cList.setAdapter(arrayAdapter);


//        tview.setText("hello");

    }
}
