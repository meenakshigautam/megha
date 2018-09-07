package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by HP on 15-08-2018.
 */




public class ComingSoon extends AppCompatActivity implements View.OnClickListener
    {


    ImageView backiconimage;

    protected PrefManager pref;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.coming_soon);

        backiconimage = (ImageView) findViewById(R.id.backiconimage);

        backiconimage.setOnClickListener(this);




    }



    @Override
    public void onClick(View view)
    {

        Intent in = new Intent(ComingSoon.this, MainActivitySixth.class);
        pref = new PrefManager(this);


        String token = pref.getToken();


        in.putExtra("tokennewstring",token);
        startActivity(in);


    }
    }
