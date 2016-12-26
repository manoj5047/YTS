package com.example.sayi.imdb2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

import static android.R.attr.calendarTextColor;
import static android.R.attr.data;
import static android.R.attr.start;

/**
 * Created by anvaya5 on 23/12/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements View.OnClickListener {
    public Context mcontext;
    public JSONArray mjarray;
    public JSONObject jsonObject;
    Movies current;
    Movies tempCurrent;
    List<Movies> data;
    int position1=0;


    public MovieAdapter(Context context, List<Movies> datamovies)
    {

        this.mcontext = context;
        this.data = datamovies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(mcontext);
        View view = layoutinflater.inflate(R.layout.recycler_item, parent, false);
        return new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position)
    {
        position1=position;
        current = data.get(position);
        holder.name.setText(current.title);
        holder.year.setText(current.year);
        holder.rating.setText(current.rating);
        Picasso.with(mcontext).load(current.large_cover_image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;

        }
        return data.size();
    }


    @Override
    public void onClick(View view)
    {
        Toast.makeText(mcontext, "Second clock", Toast.LENGTH_SHORT).show();

    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Background;
        TextView year;
        TextView name;
        TextView rating;
        ImageView image;

        public MovieViewHolder(View itemView)
        {
            super(itemView);
            year = (TextView) itemView.findViewById(R.id.RI_YEAR);
            name = (TextView) itemView.findViewById(R.id.RI_MOVIE_NAME);
            rating = (TextView) itemView.findViewById(R.id.RI_RATING);
            Background = (TextView) itemView.findViewById(R.id.BACKGROUND_TV);
            image = (ImageView) itemView.findViewById(R.id.RV_img);
            itemView.setOnClickListener(this);
              tempCurrent=data.get(0);
        }


        @Override
        public void onClick(View view)
        {
            position1=getAdapterPosition();
            if(position1==0)
            {
                SelectedResult.setData(data.get(position1));
            }
            else
            {
                SelectedResult.setData(data.get(position1));
            }
            mcontext.startActivity(new Intent(mcontext,SelectedResult.class));


        }
    }



}
