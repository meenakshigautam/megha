package com.example.hp.ourassignmentapp;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by HP on 21-08-2018.
 */






public class FirebaseServiceInstanceId extends FirebaseInstanceIdService
     {


    SharedPrefManager sharedPrefManager;
    private static final String TAG = "MyFirebaseIIDService";





    @Override
    public void onTokenRefresh()
      {


        //Getting registration token

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Displaying token on logcat

        Log.d(TAG, "Refreshed token New: " + refreshedToken);

        //Toast.makeText(this, ""+refreshedToken, Toast.LENGTH_SHORT).show();
        //calling the method store token and passing token

     //   storeToken(refreshedToken);

    }




    private void storeToken(String token)
    {
        sharedPrefManager = new SharedPrefManager(this);

         sharedPrefManager.saveDeviceToken(token);
         //SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);

        Log.d(TAG, "Save token One: " + token);

        //we will save the token in sharedpreferences later

    }

    }