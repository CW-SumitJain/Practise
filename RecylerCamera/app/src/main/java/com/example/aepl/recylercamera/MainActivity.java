package com.example.aepl.recylercamera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycle_grid = (RecyclerView) findViewById(R.id.recycle_grid);
        RecycleAdapter recycleAdapter = new RecycleAdapter(this);
        RecyclerView.LayoutManager layout_grid = new GridLayoutManager(getApplicationContext(),2);
        recycle_grid.setLayoutManager(layout_grid);
        recycle_grid.setAdapter(recycleAdapter);
    }
}
