package com.example.hp_pc.weathertest;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hp-pc on 07-08-2017.
 */

public class Weather extends AsyncTask<String,Void,String> {
    String result;
    @Override
    protected String doInBackground(String... urls) {
        result="";
        URL link;
        HttpURLConnection myconnection;

        try {
            link = new URL(urls[0]);
            myconnection = (HttpURLConnection) link.openConnection();
            InputStream in = myconnection.getInputStream();
            InputStreamReader myreader = new InputStreamReader(in);
            int data = myreader.read();
            while (data != -1) {
                char current = (char) data;
                result += current;
                data = myreader.read();

            }
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        try
        {
            JSONObject myobject=new JSONObject(result);
            JSONObject main=new JSONObject(myobject.getString("main"));
            String temperature=main.getString("temp");
            String placename=myobject.getString("name");

            MainActivity.place.setText(placename);
            MainActivity.temp.setText(temperature);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

}
