package com.example.sayi.imdb2.database;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sayi.imdb2.MainActivity;
import com.example.sayi.imdb2.MovieAdapter;
import com.example.sayi.imdb2.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.sayi.imdb2.MainActivity.data;
import static com.example.sayi.imdb2.MainActivity.ytfSearchresults;

/**
 * Created by sayi on 25-12-2016.
 */

public class JsonThing

{
    JSONArray jsonArray;
    static JSONObject rootjsonObject;
    public static JsonObjectRequest jsonobjectRequest;

    Context context;
   public JsonThing(Context context)
    {
        this.context=context;
    }

    public static List<Movies>  doTask()
    {
        try
        {
            rootjsonObject =new JSONObject(ytfSearchresults);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonobjectRequest=new JsonObjectRequest(MainActivity.url.toString(), rootjsonObject,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) throws JSONException
                    {

                        data =new ArrayList<>();


                        try
                        {

                            JSONObject newjsonObject=rootjsonObject.getJSONObject("data");
                            JSONArray jsonArray= newjsonObject.getJSONArray("movies");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject json_data=jsonArray.getJSONObject(i);
                                if(i==1)
                                {
                                   // rTV.setText(json_data.getString("title"));
                                }
                                Movies movies=new Movies();
                                movies.title=json_data.getString("title");
                                movies.year=json_data.getString("year");
                                movies.rating=json_data.getString("rating");
                                movies.language=json_data.getString("language");
                                movies.runtime=json_data.getString("runtime");
                                movies.summary=json_data.getString("summary");
                                movies.url=json_data.getString("url");
                                movies.large_cover_image=json_data.getString("large_cover_image");
                                movies.background_image=json_data.getString("background_image");
                                data.add(movies);
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("Volley","Error");
            }
        });
        return data;
    }


}
