package com.example.sayi.imdb2;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by sayi on 23-12-2016.
 */

public class NetUtils extends AsyncTask {
    private static final String API_URL ="https://yts.ag/api/v2/list_movies.json" ;
    private static final String QUERY_YEAR ="query_term" ;
    private static final String QUERY_GENRE = "genre";
    private static final String QUERY_RATING ="minimum_rating" ;
    private static final String QUERY_ORDER ="order_by" ;
    private static final String QUERY_SORT ="sort_by";
    private static final String QUERY_PAGES="pages";
    private static final String QUERY_LIMIT = "20";
    public static int limit=20;

    public static URL MovieQueryUrl;


    public static URL buildUrl(String year, String genre, String rating, String order, String sort, String page)
    {
        if(genre.equals("Genres"))
        {
            genre="";
        }
        if(sort.equals("Sort By"))
        {
            sort="";
        }
        if(order.equals("Order by"))
        {
            order="";
        }

        Uri MovieQueryUri=Uri.parse(API_URL).buildUpon()
                .appendQueryParameter(QUERY_YEAR,year)
                .appendQueryParameter(QUERY_GENRE,genre)
                .appendQueryParameter(QUERY_RATING,rating)
                .appendQueryParameter(QUERY_ORDER,order)
                .appendQueryParameter(QUERY_SORT,sort)
                .appendQueryParameter(QUERY_PAGES,page)
                .build();

        try
        {
            MovieQueryUrl=new URL(MovieQueryUri.toString());
            return MovieQueryUrl;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public static String getResponceFromHttpUrl(URL Url) throws IOException
    {
        HttpURLConnection urlConnection= (HttpURLConnection) Url.openConnection();
        try {
            InputStream in=urlConnection.getInputStream();
            Scanner scn=new Scanner(in);
            scn.useDelimiter("\\A");
            boolean hasInput=scn.hasNext();
            String response=null;
            if(hasInput)
            {
                response=scn.next();
            }
            scn.close();
            return response;
        }
        finally {
            urlConnection.disconnect();
        }
    }


    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}

