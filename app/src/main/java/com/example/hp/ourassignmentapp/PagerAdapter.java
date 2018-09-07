package com.example.hp.ourassignmentapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by HP on 02-08-2018.
 */




public class PagerAdapter extends FragmentStatePagerAdapter
    {


    int mNumOfTabs;

    protected PrefManager pref;



    public PagerAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }



    @Override
    public Fragment getItem(int position)
           {

        switch (position)

              {

            case 0:

                //EmailFragment tab1 = new EmailFragment();

                ActiveOrdersFragment activeordersfragment = new ActiveOrdersFragment();

                return activeordersfragment;



            case 1:


                CompletedOrdersFragment completedOrdersFragment = new CompletedOrdersFragment();

                return completedOrdersFragment;



                 //pass data from activity to fragment


                //Bundle bundle = new Bundle();
               //bundle.putString("params", "My String data");


                //completedOrdersFragment.setArguments(bundle);




              case 2:

                  UpcomingOrdersFragment upcomingOrdersFragment = new UpcomingOrdersFragment();


                  return upcomingOrdersFragment;


              //case 2:
             //TabFragment1 tab3 = new TabFragment1();
             //return tab3;


               default:
                return null;
             }
             }



    @Override
    public int getCount()

    {
        return mNumOfTabs;
    }
    }