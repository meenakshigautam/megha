package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;



/**
 * Created by HP on 28-08-2018.
 */




public class FirebaseServiceSecond extends AppCompatActivity implements View.OnClickListener

    {

    Button button;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        button = (Button)findViewById(R.id.button1);


        button.setOnClickListener(this);

         //String refreshedToken = FirebaseInstanceId.getInstance().getToken();



     }



    @Override
    public void onClick(View view)
    {


        //String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Toast.makeText(this, ""+refreshedToken, Toast.LENGTH_SHORT).show();


       showNotification();

       showNotificationSecond();



       }

        private void showNotificationSecond()
        {


            MyNotificationManager mNotificationManager = new MyNotificationManager(getApplicationContext());

            //creating an intent for the notification
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            //if there is no image

            //if(imageUrl.equals("null"))
            //{
            //displaying small notification


            //mNotificationManager.showBigNotification("ggjh", "fgjh", intent);




        }


        private void showNotification()

            {

             MyNotificationManager mNotificationManager = new MyNotificationManager(getApplicationContext());

             //creating an intent for the notification
             Intent intent = new Intent(getApplicationContext(), MainActivity.class);

             //if there is no image

              //if(imageUrl.equals("null"))
               //{
                //displaying small notification


                mNotificationManager.showSmallNotification("ggjh", "fgjh", intent);

              //}






        }
        }
