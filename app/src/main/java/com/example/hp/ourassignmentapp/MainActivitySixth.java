package com.example.hp.ourassignmentapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by HP on 31-07-2018.
 */








public class MainActivitySixth extends AppCompatActivity implements View.OnClickListener {


    ImageView deleteimageview, menuimageview;

    NavigationView navigationView;

    DrawerLayout drawerLayout;

    TextView logouttext;

    private static final int MY_SOCKET_TIMEOUT_MS = 50000;

    String DATA_URL = "http://52.70.180.154/api/auth/logout";

    String tokennewstring,tokennewstringnew;

    String s = "Bearer";

    protected PrefManager pref;

    String snew;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)

       {

        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.mainactivity_sixth);


        pref = new PrefManager(this);


        //displaySelectedScreen(0);

           displaySelectedScreen(0);





           Intent in = getIntent();

        tokennewstring = in.getStringExtra("tokennewstring");


        tokennewstringnew = tokennewstring.replaceAll("^\"|\"$", "");


        snew = s + " "+ tokennewstring;


        Log.e("snew",snew.toString());



           initViews();

       }




         private void displaySelectedScreen(int itemId)
            {

             //creating fragment object
             Fragment fragment = new HomeFragment();

             //initializing the fragment object which is selected


             switch (itemId)
                {

                 case 0:

                     fragment = new HomeFragment();
                     //fragment=new HomeFragmentSecond();




                     break;


                  }



             //replacing the fragment
             if (fragment != null)
             {
                 FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                 ft.replace(R.id.frameLayout, fragment);
                 ft.commit();
             }


             DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
             drawer.closeDrawer(GravityCompat.START);

             }



         private void initViews()
         {

             menuimageview = (ImageView) findViewById(R.id.menu);

             drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

             navigationView = (NavigationView) findViewById(R.id.navigationView);

             deleteimageview = (ImageView) findViewById(R.id.delete);

             logouttext = (TextView) findViewById(R.id.logouttext);

             logouttext.setOnClickListener(this);

             menuimageview.setOnClickListener(this);

             //navigationView.setOnClickListener(this);

             deleteimageview.setOnClickListener(this);




             navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

               {

                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem item)

                 {

                     switch (item.getItemId())
                     {


                    /*case R.id.myFavorite:
                        //loadFragment(new FavoriteList(), true);


                        break;


                    case R.id.myCart:
                        //loadFragment(new MyCartList(), true);

                        break;



                    case R.id.myOrders:
                        //loadFragment(new MyOrders(), true);

                        //loadFragment(new MyOrders(), true);


                        Intent in = new Intent(MainActivitySixth.this, MyOrders.class);
                        startActivity(in);
                        closeDrawer();


                        break;


                    case R.id.myProfile:

                        //loadFragment(new MyProfile(), true);


                        Intent in2 = new Intent(MainActivitySixth.this, ProfileActivity.class);
                        in2.putExtra("snew",snew);
                        startActivity(in2);
                        closeDrawer();

                        break;


                    case R.id.faq:
                        //loadFragment(new FAQ(), true);

                        break;

                    case R.id.appInfo:
                        //loadFragment(new AppInfo(), true);

                        break;

                    case R.id.share:
                        //shareApp();

                        break;


                    case R.id.rateApp:
                        // perform click on Rate Item

                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                        break;


                    case R.id.email:

                        //openGmail();

                        break;


                    case R.id.call:
                        // call();

                        break;


                    case R.id.whatsapp:
                        //openWhatsApp();


                        break;
                       */


                         case R.id.myOrders:
                             //loadFragment(new FavoriteList(), true);


                             Intent in = new Intent(MainActivitySixth.this, MyOrders.class);
                             startActivity(in);
                             closeDrawer();



                             break;


                         case R.id.myEarnings:
                             //loadFragment(new MyCartList(), true);




                             Intent in76 = new Intent(MainActivitySixth.this , ComingSoon.class);
                             startActivity(in76);
                             closeDrawer();




                             break;



                         case R.id.profile:
                             //loadFragment(new MyOrders(), true);

                             //loadFragment(new MyOrders(), true);


                             Intent in2 = new Intent(MainActivitySixth.this, ProfileActivity.class);

                             in2.putExtra("snew",snew);

                             startActivity(in2);
                             closeDrawer();





                             break;


                         case R.id.settings:
                             //loadFragment(new MyOrders(), true);

                             //loadFragment(new MyOrders(), true);


                             Intent in21 = new Intent(MainActivitySixth.this, ComingSoon.class);

                             //in21.putExtra("snew",snew);

                             startActivity(in21);
                             closeDrawer();





                             break;



                         case R.id.rating:
                             //loadFragment(new MyOrders(), true);

                             //loadFragment(new MyOrders(), true);


                             Intent in25 = new Intent(MainActivitySixth.this, ComingSoon.class);

                             //in21.putExtra("snew",snew);

                             startActivity(in25);
                             closeDrawer();





                             break;


















                         case R.id.help:

                             //loadFragment(new MyProfile(), true);


                        /*Intent in2 = new Intent(MainActivitySixth.this, ProfileActivity.class);
                        in2.putExtra("snew",snew);
                        startActivity(in2);
                        closeDrawer();*/

                             Intent in78 = new Intent(MainActivitySixth.this,ComingSoon.class);
                             startActivity(in78);
                             closeDrawer();


                             break;








                         case R.id.logout:
                             //loadFragment(new FAQ(), true);

                             hitApiForLogout();
                             break;

                    /* case R.id.appInfo:
                        //loadFragment(new AppInfo(), true);

                        break;

                    case R.id.share:
                        //shareApp();

                        break;


                    case R.id.rateApp:
                        // perform click on Rate Item

                        try
                        {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                        }
                        catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                        break;


                    case R.id.email:

                        //openGmail();

                        break;


                    case R.id.call:
                        // call();

                        break;


                    case R.id.whatsapp:
                        //openWhatsApp();
                      */


                         // break;










                     }
                     return false;
                 }
             });

         }



         public void loadFragment(Fragment fragment, Boolean bool)
         {

             FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
             transaction.replace(R.id.frameLayout, fragment);
             if (bool)
             {
                 transaction.addToBackStack(null);
             }

             transaction.commit();

         }




         @Override
         public void onClick(View view)
         {

             if (view.getId() == menuimageview.getId())
             {

                 if (!drawerLayout.isDrawerOpen(Gravity.LEFT))

                 {
                     drawerLayout.openDrawer(Gravity.LEFT);

                 }

             }



             else if (view.getId() == deleteimageview.getId())
             {

                 drawerLayout.closeDrawer(Gravity.LEFT);

             }

             else if (view.getId() == logouttext.getId())
             {
                 hitApiForLogout();
                 //drawerLayout.closeDrawer(Gravity.LEFT);

             }

             //Toast.makeText(this, "u clicked", Toast.LENGTH_SHORT).show();

         }



         private void hitApiForLogout()

         {
             RequestQueue queue = Volley.newRequestQueue(MainActivitySixth.this);

             final JSONObject jsonObject = new JSONObject();

            /*try
            {
                jsonObject.put("email", "pramod@liyatechnology.com");
                jsonObject.put("password", "123456");

            }

            catch (JSONException e)
            {
                e.printStackTrace();
            }*/




             StringRequest sr = new StringRequest(Request.Method.GET, DATA_URL,
                     new Response.Listener<String>()
                     {

                         @Override
                         public void onResponse(String response)
                         {

                             Log.e("HttpClient", "" + "Bearer " + response.toString());

                             try
                             {

                                 JSONObject jsonObject1 = new JSONObject(response);
                                 String message = jsonObject1.getString("message");

                                 Toast.makeText(MainActivitySixth.this, ""+message, Toast.LENGTH_SHORT).show();

                                 pref.clearSession();


                                 Intent i = new Intent(MainActivitySixth.this, LoginActivity.class);

                                 //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                 startActivity(i);

                                 //finish();


                             }
                             catch (JSONException e)
                             {
                                 e.printStackTrace();
                             }


                             //                       String tokennewstring = response.toString();

//                        Intent in = new Intent(LoginActivity.this, MainActivitySixth.class);


//                        Intent in = new Intent(LoginActivity.this, ToggleActivity.class);


                             //                in.putExtra("tokenstring",""+ response.toString());


                             //tokennewstring = in.getStringExtra("tokenstring");


                             //               tokennewstringnew = tokennewstring.replaceAll("^\"|\"$", "");


                             //tokennewstringnew=tokennewstring.substring(1, tokennewstring.length()-1);

                             //snew = s + " "+ tokennewstringnew;
                             //hitApiForCategories();


                             //           Log.e("stringnew",snew);


                             //                      startActivity(in);


                         }

                     },
                     new Response.ErrorListener()
                     {
                         @Override
                         public void onErrorResponse(VolleyError error)
                         {
                             Log.e("HttpClient", "error: " + error.toString());
                         }
                     })

             {

                 @Override
                 public Map<String, String> getHeaders() throws AuthFailureError
                 {
                     Map<String, String> params = new HashMap<String, String>();

                     //params.put("Content-Type", "application/json; charset=utf-8");

                     params.put("Authorization", snew);



                     return params;
                 }

                 @Override
                 public byte[] getBody() throws AuthFailureError
                 {
                     return jsonObject.toString().getBytes();
                 }
             };


             sr.setRetryPolicy(new DefaultRetryPolicy(
                     MY_SOCKET_TIMEOUT_MS,
                     DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                     DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
             queue.add(sr);
         }




         public void closeDrawer()
         {

             drawerLayout.closeDrawer(Gravity.LEFT);

         }
     }




