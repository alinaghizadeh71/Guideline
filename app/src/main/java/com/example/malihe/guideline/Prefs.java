package com.example.malihe.guideline;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by malihe on 4/4/2018.
 */

public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

       // String myString = prefs.getString("myStringName", "");
        Boolean myBoolean = prefs.getBoolean("tgpref", true);
    }
}
