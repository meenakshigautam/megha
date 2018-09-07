package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * Created by HP on 30-07-2018.
 */





public class Registration extends AppCompatActivity implements View.OnClickListener

    {


     EditText addressedittext,nameedittext;
     Spinner spinner1,spinner2;
     Button button;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)

      {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.registration);

         //addressedittext = (EditText)findViewById(R.id.addressedittext);

        //nameedittext = (EditText)findViewById(R.id.addressedittext);


        spinner1 = (Spinner) findViewById(R.id.spinner1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);



        button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(this);


        }




    @Override
    public void onClick(View view)
    {

        Intent in = new Intent(Registration.this , MainActivitySixth.class);
        startActivity(in);

    }
    }
