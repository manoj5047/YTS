package com.example.sayi.imdb2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;

/**
 * Created by sayi on 25-12-2016.
 */
public class QuickPreferenceActivity extends PreferenceActivity
{
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.settings);
    }
}
