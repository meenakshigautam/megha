package com.example.hp.ourassignmentapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HP on 04-09-2018.
 */

public class SharedPrefManager {
    static final String SHARED_PREF_NAME = "FCMSharedPrefnewssecondthirdforthfive";
    static final String TAG_TOKEN = "tagtokenfirstsecondthird";

    static SharedPrefManager mInstance;
    static Context mCtx;


    public SharedPrefManager(Context context)

    {
        mCtx = context;
    }


    public static synchronized SharedPrefManager getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;

    }


    //this method will save the device token to shared preferences
    public boolean saveDeviceToken(String token) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, token);
        editor.apply();
        return true;
    }


    //this method will fetch the device token from shared preferences
    public String getDeviceToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TAG_TOKEN, null);
    }

}