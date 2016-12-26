package com.example.sayi.imdb2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.example.sayi.imdb2.database.JsonThing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private static final String MSG ="Some thing ";
    static Spinner  spin1_genre;
    static Spinner spin2_order_by;
    static Spinner spin3_sort_by;
    static EditText mET_YEAR;
    static EditText mET_RATING;
    static EditText mET_LIMIT;
    static TextView mTV_URL;
    static Button mBT;
    static  Button mBT2;
    static TextView mTV_RESULTS;
    static ProgressBar mPB;
    public static   List<Movies> data;
    //
    static  public String genre;
    public static String order_by;
    public static String sort_by;
    //

    public static String urltodispaly;
    public Menu menu;
    public static  String ytfSearchresults;
    public static URL url;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1_genre =(Spinner) this.findViewById(R.id.MA_SPINNER_GENRE);
        spin2_order_by=(Spinner) this.findViewById(R.id.MA_SPINNER2_ORDERBY);
        spin3_sort_by=(Spinner) this.findViewById(R.id.MA_SPINNER3_SORTBY);
        mET_YEAR=(EditText) this.findViewById(R.id.MA_ET);
        mET_RATING=(EditText) this.findViewById(R.id.MA_ET1);
        mET_LIMIT=(EditText) this.findViewById(R.id.MA_ET2);
        mTV_URL=(TextView) this.findViewById(R.id.MA_TV_URL_DISPLAY);
//        mTV_RESULTS=(TextView) this.findViewById(R.id.MA_RV_RESULTS);
//        mBT=(Button) this.findViewById(R.id.MA_BT);
//       mBT2 = (Button) this.findViewById(R.id.MA_BT2);
        mPB=(ProgressBar) this.findViewById(R.id.progressBar);

        FirstTask();
        mTV_URL.setText(urltodispaly);
        mTV_RESULTS.setText(ytfSearchresults);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menufiles,menu);
        return true;

    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_search:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_search1,null);
                        AlertDialog.Builder alertdialogbuilder1=new AlertDialog.Builder(MainActivity.this);
                        alertdialogbuilder1.setMessage("Are you sure you want to Exit the Application..?");
                        alertdialogbuilder1.setView(view);
                        return false;
                    }
                });



            case R.id.MENU_HISTORY:
                Intent intent=new Intent(MainActivity.this,QuickPreferenceActivity.class);
                Toast.makeText(getApplicationContext(),"History Clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MENU_REFRESH:
                Toast.makeText(getApplicationContext(),"Refresh Clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MENU_ABOUT:
                Toast.makeText(getApplicationContext(),"About Clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MENU_EXIT:
                Toast.makeText(getApplicationContext(),"Exit Clicked",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
                alertdialogbuilder.setMessage("Are you sure you want to Exit the Application..?");
                alertdialogbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(getApplicationContext(),"I know that u won't Leave me..",Toast.LENGTH_SHORT).show();
                    }
                });
                alertdialogbuilder.setPositiveButton("yes", new DialogInterface.OnClickListener()
                {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

                AlertDialog alertDialog1=alertdialogbuilder.create();
                alertDialog1.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        FirstTask();
        mTV_URL.setText(urltodispaly);
        mTV_RESULTS.setText(ytfSearchresults);

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
         genre = adapterView.getItemAtPosition(i).toString();

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
    public  void FirstTask()
    {
            spin1_genre.setOnItemSelectedListener(this);// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this,R.array.genre_arrays,android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Apply the adapter to the spinner
            spin1_genre.setAdapter(arrayAdapter);

            spin2_order_by.setOnItemSelectedListener(new OrederItemSelectedListener());
            ArrayAdapter arrayAdapter2=ArrayAdapter.createFromResource(this,R.array.order_array,android.R.layout.simple_spinner_item);
            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin2_order_by.setAdapter(arrayAdapter2);

            spin3_sort_by.setOnItemSelectedListener(new SortItemSelectedListener());
            ArrayAdapter arrayAdapter3=ArrayAdapter.createFromResource(this,R.array.sort_array,android.R.layout.simple_spinner_item);
            arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin3_sort_by.setAdapter(arrayAdapter3);

            mBT.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    url = NetUtils.buildUrl(MainActivity.mET_YEAR.getText().toString(), MainActivity.genre, MainActivity.mET_RATING.getText().toString(), order_by, sort_by, mET_LIMIT.getText().toString());
                    urltodispaly=url.toString();
                    MainActivity.mTV_URL.setText(urltodispaly);
                    new DownloadData().execute(NetUtils.buildUrl(
                            MainActivity.  mET_YEAR.getText().toString(),
                            MainActivity. genre,
                            MainActivity.mET_RATING.getText().toString(),
                            order_by,
                            sort_by,
                            mET_LIMIT.getText().toString()
                    ));
                     mPB.setVisibility(View.VISIBLE);
                }
            });
        mBT2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                    if(ytfSearchresults==null)
                    {
                        Toast.makeText(getApplicationContext(),"please make a search",Toast.LENGTH_SHORT).show();
                    }
                else {
                        Intent intent = new Intent(MainActivity.this, Results.class);
                        startActivity(intent);
                    }



            }
        });
        }
    public class DownloadData extends AsyncTask<URL,Void,String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            if(ytfSearchresults!=null)
            {
                mTV_RESULTS.setText(" ");
            }



        }

        @Override
        protected String doInBackground(URL... params)
        {
            URL searchurl=params[0];

             ytfSearchresults=null;
            try
            {
                 ytfSearchresults = NetUtils.getResponceFromHttpUrl(searchurl);
                return ytfSearchresults;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            mPB.setVisibility(View.INVISIBLE);
            mTV_RESULTS.setText(s);
            Log.d(MSG,"Executed");
        }
    }
}
