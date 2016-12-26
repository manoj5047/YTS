package com.example.sayi.imdb2;

import android.view.View;
import android.widget.AdapterView;

import com.example.sayi.imdb2.database.SearchActivity1;

/**
 * Created by sayi on 23-12-2016.
 */
public class SortItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        MainActivity.sort_by=adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
