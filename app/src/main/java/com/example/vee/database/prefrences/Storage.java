package com.example.vee.database.prefrences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.vee.MyApplication;

public class Storage {
    private static Storage instance;
    public static final String STORAGE_PREF_KEY = "Vee.main.pref";
    private SharedPreferences preferences;

    Storage() {
        Context context = MyApplication.getContext();
        preferences = context.getSharedPreferences(STORAGE_PREF_KEY, Context.MODE_PRIVATE);
    }

    public static Storage getInstance() {
        return instance == null ? instance = new Storage() : instance;
    }

}
