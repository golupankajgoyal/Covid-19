package com.example.covid_19;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NetworkUtils {

    public static URL buildUrl(String stringUrl) {

        Uri uri = Uri.parse(stringUrl).buildUpon().build();
        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromUrl(URL url) throws IOException {

        HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
        try {
            InputStream inputStream = urlConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static List<StateData> getFormattedStateData(String jsonResponse){

        List<StateData> data=new ArrayList<>();
        try {

            JSONObject baseJsonObject=new JSONObject(jsonResponse);
            JSONObject dataJsonObject=baseJsonObject.getJSONObject("data");
            JSONArray stateDataArray=dataJsonObject.getJSONArray("statewise");

            for(int i=0;i<stateDataArray.length();i++){
                JSONObject currentStateObject=stateDataArray.getJSONObject(i);
                int confirmed=currentStateObject.getInt("confirmed");
                int recovered=currentStateObject.getInt("recovered");
                int deaths=currentStateObject.getInt("deaths");
                int active=currentStateObject.getInt("active");
                String state=currentStateObject.getString("state");
                StateData currentStateData=new StateData(confirmed,active,recovered,deaths,state);
                data.add(currentStateData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<DistrictData> getFormattedDistrictData(String jsonResponse,String stateName){

        List<DistrictData> data=new ArrayList<>();
        try {
            JSONObject baseJsonObject=new JSONObject(jsonResponse);
            JSONObject stateJsonObject=baseJsonObject.getJSONObject(stateName);
            JSONObject districtDataObject=stateJsonObject.getJSONObject("districtData");
            Iterator<?> keys=districtDataObject.keys();
            ArrayList<String> districtArray=new ArrayList<>();
            while (keys.hasNext()) {
                String name = (String) keys.next();
                districtArray.add(name);
            }
            for(int i=0;i<districtArray.size();i++){
                JSONObject currentDistrict=districtDataObject.getJSONObject(districtArray.get(i));
                int comfirmed=currentDistrict.getInt("confirmed");
                DistrictData districtData=new DistrictData(comfirmed,districtArray.get(i));
                data.add(districtData);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<IndiaData> getIndiaFormattedData(String jsonResponse){
        List<IndiaData> indiaData=new ArrayList<>();
        List<Integer> imagesData=new ArrayList<>();
        imagesData.add(0,R.drawable.india);
        imagesData.add(1,R.drawable.rope);
        imagesData.add(2,R.drawable.skull);
        imagesData.add(3,R.drawable.therapy);

        try {
            JSONObject baseJsonObject=new JSONObject(jsonResponse);
            JSONObject dataJsonObject=baseJsonObject.getJSONObject("data");
            JSONObject totalJsonObject=dataJsonObject.getJSONObject("total");
            Iterator<?> keys=totalJsonObject.keys();
            ArrayList<String> totalKeys=new ArrayList<>();
            while (keys.hasNext()) {
                String name = (String) keys.next();
                totalKeys.add(name);
            }
            for(int i=0;i<totalKeys.size();i++){
                int cases=totalJsonObject.getInt(totalKeys.get(i));
                int imageId=imagesData.get(i);
                IndiaData currentData=new IndiaData(cases,imageId);
                indiaData.add(currentData);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return indiaData;
    }
}
