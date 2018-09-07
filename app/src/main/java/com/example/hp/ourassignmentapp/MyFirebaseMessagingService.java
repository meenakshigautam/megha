package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by HP on 25-08-2018.
 */







public class MyFirebaseMessagingService  extends FirebaseMessagingService

      {



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)

       {

        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0)
           {

            //Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());

            try
            {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
                sendPushNotification(json);
            }


            catch (Exception e)
            {
                // Log.e(TAG, "Exception: " + e.getMessage());

            }
            }
            }





       private void sendPushNotification(JSONObject json)
                {

               //optionally we can display the json into log
               //Log.e(TAG, "Notification JSON " + json.toString());

               try
               {

                   //getting the json data
               JSONObject data = json.getJSONObject("data");

               //parsing json data
               String title = data.getString("title");
               String message = data.getString("message");
               String imageUrl = data.getString("image");

               //creating MyNotificationManager object
               MyNotificationManager mNotificationManager = new MyNotificationManager(getApplicationContext());

               //creating an intent for the notification
               Intent intent = new Intent(getApplicationContext(), MainActivity.class);

               //if there is no image

                   if(imageUrl.equals("null"))
               {
                   //displaying small notification
                   mNotificationManager.showSmallNotification(title, message, intent);
               }

               else
                   {

                       //if there is an image
                      //displaying a big notification

                   mNotificationManager.showBigNotification(title, message, imageUrl, intent);
                    }
                    }

           catch (JSONException e)
           {
               Log.d("exception", "Json Exception: " + e.getMessage());
           }

           catch (Exception e)
           {

               Log.e("exception2", "Exception: " + e.getMessage());

           }
           }

           }








