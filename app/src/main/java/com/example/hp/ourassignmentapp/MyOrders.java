package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by HP on 03-08-2018.
 */


public class MyOrders extends AppCompatActivity implements View.OnClickListener

       {


          protected PrefManager pref;
          ImageView backiconimage;




          @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
        {

        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.myorders);

        pref = new PrefManager(this);


        backiconimage = (ImageView) findViewById(R.id.backiconimage);

            backiconimage.setOnClickListener(this);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Active"));
        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
            });
            }



            @Override
    public void onClick(View view)
    {

        Intent in = new Intent(MyOrders.this , MainActivitySixth.class);

        String token = pref.getToken();


        in.putExtra("tokennewstring",token);
        startActivity(in);




    }
    }

