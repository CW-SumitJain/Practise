package com.example.aepl.servicebroadcast;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aepl on 28/6/16.
 */
public class DownloadService extends IntentService {
    private String uri;
    private String ACTION = "DOWNLOADED";
    private String name = "sumit";
    String json ="";
    JSONObject jsonObject = null;
    public DownloadService(){
        super(DownloadService.class.getName());
    }
    public DownloadService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        uri =intent.getExtras().getString("uri");

//        new DownloadData.execute(url);
        /*DownloadData dData = new DownloadData();
        dData.execute(uri);*/
        /*try {
            url = new URL("http://www.carwale.com/webapi/newcardealers/cities/?makeid=10");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                sb.append(line + "\n");
                Log.d("TAG",line);
            }
            urlConnection.getInputStream().close();
            json = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("TAG","hello " + uri);

        Intent intent1 = new Intent();
        intent1.putExtra("json",json);
        intent1.setAction(ACTION);
        intent1.putExtra("name",name);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
//        sendBroadcast(intent1);

    }

}
