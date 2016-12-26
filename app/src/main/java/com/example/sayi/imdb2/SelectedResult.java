package com.example.sayi.imdb2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SelectedResult extends AppCompatActivity
{
    private static final String NULL ="NULLLLL....." ;
    private static final String MOVIETITLE ="MOVIETITLE" ;
    public static ImageView fIMG;
    public static ImageView fIMGSMALL;
    public static TextView  fTITLE;
    public static TextView  fYEAR;
    public static TextView  fRATING;
    public static TextView  fLANGUAGE;
    public static TextView  fDURATION;
    public static TextView  fSUMMARY;
    public static TextView  fURL;
    public static String title=null;
    public static String year=null;
    public static String rating=null;
    public static String language=null;
    public static String duration=null;
    public static String summary=null;
    public static String url=null;
    public static String img=null;
    public static String imgsmall=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_result);
        fIMG=(ImageView) this.findViewById(R.id.RA_LARGE_BG);
        fTITLE=(TextView) this.findViewById(R.id.FV_TV_TITLE);
        fYEAR=(TextView) this.findViewById(R.id.FV_TV_YEAR);
        fRATING=(TextView) this.findViewById(R.id.FV_TV_IMDB);
        fLANGUAGE=(TextView) this.findViewById(R.id.FV_TV_LANGUAGE);
        fDURATION=(TextView) this.findViewById(R.id.FA_TV_DURATION);
        fSUMMARY=(TextView) this.findViewById(R.id.Summary);
        fURL=(TextView) this.findViewById(R.id.FV_TV_URL);
        fIMGSMALL=(ImageView) this.findViewById(R.id.FIMG_SMALL_IMG);
        fTITLE.setText(title);
        fYEAR.setText("Year : "+year);
        fRATING.setText("Rating : "+rating);
        fLANGUAGE.setText(language);
        fDURATION.setText("Runtime : "+duration+" Mins");
        fSUMMARY.setText(summary);
        fURL.setText("URL : "+url);
        Picasso.with(this).load(img).into(fIMG);
        Picasso.with(this).load(imgsmall).into(fIMGSMALL);
        fURL.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        fIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(imgsmall));
                startActivity(intent);
            }
        });


    }
    public static void setData(Movies current)
    {
        String str=current.title;
        Log.d(MOVIETITLE,current.title);
        title=current.title;
        year=current.year;
        rating=current.rating;
        language=current.language;
        duration=current.runtime;
        summary=current.summary;
        url=current.url;
        img=current.background_image;
        imgsmall=current.large_cover_image;


    }

}
