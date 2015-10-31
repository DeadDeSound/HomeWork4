package qa.edu.qu.cse.cmps497.homework4.model;


import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonExtract {

    private final static String TAG = "JsonExtract";

    private final static int NUM_ARTICLES = 5;


    public static String[] extractTitles(JSONArray jsonArray) {

        String[] titles = new String[NUM_ARTICLES];

        for (int i=0; i< NUM_ARTICLES; i++) {
            String title = null;
            try {
                title = jsonArray.getJSONObject(i).getString("title");
            } catch (JSONException e) {
                Log.e(TAG, "Json threw an exception in extractTitles");
            }

            titles[i] = title;
        }

        return titles;

    }

    public static String[] extractAbstracts(JSONArray jsonArray) {

        String[] titles = new String[NUM_ARTICLES];

        for (int i=0; i< NUM_ARTICLES; i++) {
            String title = null;
            try {
                title = jsonArray.getJSONObject(i).getString("abstract");
            } catch (JSONException e) {
                Log.e(TAG, "Json threw an exception in extractAbstracts");
            }

            titles[i] = title;
        }

        return titles;

    }

    public static String[] extractLinks(JSONArray jsonArray) {

        String[] titles = new String[NUM_ARTICLES];

        for (int i=0; i< NUM_ARTICLES; i++) {
            String title = null;
            try {
                title = jsonArray.getJSONObject(i).getString("url");
            } catch (JSONException e) {
                Log.e(TAG, "Json threw an exception in extractLinks");
            }

            titles[i] = title;
        }

        return titles;

    }

    public static String getAbstract(JSONArray jsonArray, int i) {

        String abs = null;
        try {
            abs = jsonArray.getJSONObject(i).getString("abstract");
        } catch (JSONException e) {
            Log.e(TAG, "JSON threw an exception in abstract fetching");
        }

        return abs;
    }


    public static JSONArray getFeed(Context context, int id){

        InputStream inputStream = context.getResources().openRawResource(id);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";

        StringBuffer buffer = new StringBuffer("");

        try {
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            Log.i(TAG, "IOException");
            return null;
        }


        // Turn the raw file into JSONArray
        JSONArray feed=null;
        try {
            JSONObject obj = new JSONObject(buffer.toString());
            feed = obj.getJSONArray("results");
        } catch (JSONException e) {
            Log.i(TAG, "JSONException in getFeed");
        }

        return feed;
    }
}
