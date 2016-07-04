package com.example.aepl.servicebroadcast;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aepl on 29/6/16.
 */
public class DownloadData extends AsyncTask <String, Integer, String >{
    String json;
    JSONObject jsonObject;
    Toolbar toolbar;
    ArrayList<String> citylist= new ArrayList<String>();
    ArrayList<String> advanceCity = new ArrayList<String>();
    ArrayList<Item1> items;
    private Context mcontext;
    ListView lv;
    sendToActivity send_data = null;
    public DownloadData(Context mContext) {

        this.mcontext = mContext;
    }
    public void setData(sendToActivity send_data){
        this.send_data = send_data;
    }

    public interface sendToActivity{
        public void onComplete(ArrayList<Item1> items);
    }
    @Override
    protected String doInBackground(String... strings) {
        publishProgress(0);
       String uri = strings[0];
       try {
           URL url = new URL(uri);
           HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
           urlConnection.setRequestMethod("GET");
           urlConnection.connect();
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
           StringBuilder sb = new StringBuilder();
           String line = null;
           while((line = bufferedReader.readLine()) != null){
               sb.append(line + "\n");
//               Log.d("TAG",line);
           }
           urlConnection.getInputStream().close();
           json = sb.toString();
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return json;
   }

    /*@Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        TextView tv = new TextView(mcontext);
        LinearLayout list = (LinearLayout)((Activity)mcontext).findViewById(R.id.linear);
//        lv=  (ListView)((Activity)mcontext).findViewById(R.layout.activity_main);

        tv.setText("Downloading");
        list.addView(tv);

    }*/

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
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
        View view;
        /*LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_main,null);
        lv = (ListView)view.findViewById(R.id.citylist);*/
//        lv = (ListView)((Activity)mcontext).findViewById(R.id.citylist);
        FrameLayout main_content = (FrameLayout)((Activity)mcontext).findViewById(R.id.main_content);
        LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_main,main_content,true);
        lv = (ListView)view.findViewById(R.id.citylist);

        ArrayList<String > statelist = new ArrayList<>();
        for(Item1 i:items){
            statelist.add(i.stateName);
        }
//        LayoutInflater inflater = LayoutInflater.from((Activity)mcontext);
        StateListAdapter stateAdapter = new StateListAdapter(statelist,items,inflater);
        lv.setAdapter(stateAdapter);
      /* if(send_data != null)
            send_data.onComplete(items);*/
        send_data = (sendToActivity)mcontext;
        send_data.onComplete(items);



    }

}
