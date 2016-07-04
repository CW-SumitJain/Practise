package com.example.aepl.fragment_tab;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListBrands.OnArticleSelectedListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment checkFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

    }

    @Override
    protected void onStart() {
        super.onStart();
        int orientaion = getResources().getConfiguration().orientation;
        if(orientaion == Configuration.ORIENTATION_LANDSCAPE){
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
//            Fragment checkFragment = fragmentManager.findFragmentByTag("car_details");
            checkFragment = fragmentManager.findFragmentByTag("car_details");
            if(checkFragment != null)
                fragmentTransaction.remove(checkFragment);
            BrandDetails fragment = new BrandDetails();
            Bundle b = new Bundle();
            b.putInt("position",0);
            fragment.setArguments(b);
            fragmentTransaction.add(R.id.car_details,fragment,"car_details");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


    }

    @Override
    public void onArticleSelected(int position) {
        int orientaion = getResources().getConfiguration().orientation;
        if(orientaion == Configuration.ORIENTATION_LANDSCAPE){
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
//            Fragment checkFragment = fragmentManager.findFragmentByTag("car_details");
            checkFragment = fragmentManager.findFragmentByTag("car_details");
           /* if(checkFragment != null)
                fragmentTransaction.remove(checkFragment);*/
            BrandDetails fragment = new BrandDetails();
            Bundle b = new Bundle();
            b.putInt("position",position);
            fragment.setArguments(b);
//            fragmentTransaction.add(R.id.car_details,fragment,"car_details");
            fragmentTransaction.replace(R.id.car_details,fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        else{
            Intent intent = new Intent(this,com.example.aepl.fragment_tab.DetailActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);

        }
    }
}
