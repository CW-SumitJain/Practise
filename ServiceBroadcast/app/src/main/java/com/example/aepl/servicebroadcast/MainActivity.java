package com.example.aepl.servicebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private String uri = "http://www.carwale.com/webapi/newcardealers/cities/?makeid=10";
    private String ACTION = "DOWNLOADED";
    private EditText editText;
    String text;
    String json;
    JSONObject jsonObject = null;
    ArrayList<String> citylist= new ArrayList<String>();
    ArrayList<String> advanceCity = new ArrayList<String>();
    ArrayList<Item1> items;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent downloadIntent = new Intent (MainActivity.this,DownloadService.class);
        downloadIntent.putExtra("uri",uri);
        startService(downloadIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(testReceiver,intentFilter);
    }
    private BroadcastReceiver testReceiver  = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            String text = intent.getExtras().getString("name");
           /* Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Set<String> keys = bundle.keySet();
                Iterator<String> it = keys.iterator();
                Log.e("TAG","Dumping Intent start");
                while (it.hasNext()) {
                    String key = it.next();
                    Log.e("TAG","[" + key + "=" + bundle.get(key)+"]");
                }
                Log.e("TAG","Dumping Intent end");
            }*/
            text = intent.getExtras().getString("name");
            json = intent.getExtras().getString("json");
            Log.d("TAG","CEHCK HELLO  EHCK HELLO  EHCK HELLO  EHCK HELLO EHCK HELLO " + json);
            try {
                jsonObject = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
//                JSONObject jsonItem = jsonObject.getJSONObject("Item1");
                JSONArray jsonItem = jsonObject.getJSONArray("Item1");
                Log.d("TAG","ITEM1 " + jsonItem.toString());
                items = new ArrayList<>();
                int i,j;
                for(i=0;i<jsonItem.length();i++){
                    Item1 itm = new Item1();
                    JSONObject jsonCity = jsonItem.getJSONObject(i);
                    JSONArray jsonCities = jsonCity.getJSONArray("cities");
                    for(j=0;j<jsonCities.length();j++){
                        int cityId = jsonCities.getJSONObject(j).getInt("cityId");
                        String cityName = jsonCities.getJSONObject(j).getString("cityName");
                        citylist.add(cityName);
                        int totalCount = jsonCities.getJSONObject(j).getInt("totalCount");
                        Cities C = new Cities();
                        C.setCityId(cityId);
                        C.setCityName(cityName);
                        C.setTotalCount(totalCount);
                        itm.setCity(C);
//                        Log.d("TAG","DATA - " + cityId + "  " + cityName + "  " + totalCount);
                    }
                    String stateName = jsonCity.optString("stateName");
                    int stateId = jsonCity.optInt("stateId");
                    int cityId = jsonCity.optInt("cityId");
                    String cityName= jsonCity.optString("cityName");
                    int totalCount = jsonCity.getInt("totalCount");
                    itm.setStateName(stateName);
                    itm.setCityName(cityName);
                    itm.setCityId(cityId);
                    itm.setStateId(stateId);
                    itm.setTotalCount(totalCount);
                    items.add(itm);
//                    Log.d("TAG","stateName " + stateName + stateId + cityId + cityName + totalCount);
                }
               /* ArrayList<Cities> checkCity = items.get(1).getCity();
                for(Cities c:checkCity){
                    Log.d("TAG",c.getCityName());
                }*/
                JSONArray jsonItem2 = jsonObject.getJSONArray("Item2");
                for(i=0;i<jsonItem2.length();i++){
                    JSONObject jsonAdvance = jsonItem2.getJSONObject(i);
                    int cityId = jsonAdvance.optInt("cityId");
                    String cityName = jsonAdvance.optString("cityName");
                    advanceCity.add(cityName);
                    String cityImgUrl = jsonAdvance.optString("cityImgUrl");
//                    Log.d("TAG","data " + cityId + " " + cityName);
                }
                /*JSONArray jsonCity = jsonItem.getJSONArray(0);
                Log.d("TAG","CITIES " + jsonCity);*/
            } catch (JSONException e) {
                Log.d("TAG","E R R O R");
                e.printStackTrace();
            }

            lv = (ListView)findViewById(R.id.citylist);
            ArrayList<String > statelist = new ArrayList<>();
            for(Item1 i:items){
                statelist.add(i.stateName);
            }
           /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(),R.layout.listview,R.id.tview,statelist);
            lv.setAdapter(adapter);*/
            LayoutInflater inflater = LayoutInflater.from(getApplication());
            StateListAdapter stateAdapter = new StateListAdapter(statelist,items,inflater);
            lv.setAdapter(stateAdapter);
            /*editText = (EditText)findViewById(R.id.editText);

            editText.setText(intent.getStringExtra("name"));*/

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(testReceiver);
    }
}
