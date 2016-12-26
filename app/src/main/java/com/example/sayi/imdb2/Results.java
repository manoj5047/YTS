package com.example.sayi.imdb2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sayi.imdb2.database.JsonThing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

import static com.example.sayi.imdb2.MainActivity.data;
import static com.example.sayi.imdb2.MainActivity.mET_LIMIT;
import static com.example.sayi.imdb2.MainActivity.mPB;
import static com.example.sayi.imdb2.MainActivity.mTV_RESULTS;
import static com.example.sayi.imdb2.MainActivity.order_by;
import static com.example.sayi.imdb2.MainActivity.sort_by;
import static com.example.sayi.imdb2.MainActivity.urltodispaly;
import static com.example.sayi.imdb2.MainActivity.ytfSearchresults;
import static com.example.sayi.imdb2.SelectedResult.url;

public class Results extends AppCompatActivity
{
    private static final String TAG ="array check :" ;
    private static final String MESSAGE = "RESULTS ACTIVITY" ;
    TextView rTV;
    RecyclerView movielistview;
    URL url;

    MovieAdapter movieAdapter;
    static  RequestQueue  requestque;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        movielistview = (RecyclerView) this.findViewById(R.id.ALL_MOVIES_RESULTS);
        rTV = (TextView) this.findViewById(R.id.RS_TV);
        Toast.makeText(getApplicationContext(),"something..!!!!",Toast.LENGTH_SHORT).show();
        requestque= Volley.newRequestQueue(this);
        JsonThing.doTask();
        requestque.add(JsonThing.jsonobjectRequest);
        movieAdapter=new MovieAdapter(this, JsonThing.doTask());
        movielistview.setLayoutManager(new LinearLayoutManager(this));
        movielistview.setAdapter(movieAdapter);
        movielistview.setItemAnimator(new SlideInUpAnimator());
        Log.i(MESSAGE,"ON CREATE");


    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(MESSAGE,"ON START");


    }

    @Override
    protected void onRestart()
    {
        super.onRestart();

    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }


}


