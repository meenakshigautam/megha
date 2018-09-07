package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.hp.ourassignmentapp.NotificationPoints.URL_REGISTER_DEVICE;

/**
 * Created by HP on 06-09-2018.
 */





public class LoginActivity extends AppCompatActivity implements View.OnClickListener

         {

         TextView newusertext;
         String tokennewstring,tokennewstringnew;
         Button button;
         EditText emailedittext,passwordedittext;
         private static final int MY_SOCKET_TIMEOUT_MS = 50000;
         String DATA_URL = "http://52.70.180.154/api/auth/login";
         protected PrefManager pref;
         String snew,accesstoken;
         String s = "Bearer";
         String email,emailsecond;

         SharedPrefManager sharedPrefManager;


         String email_pattern = "\"^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\";";












         @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_login);



        pref = new PrefManager(this);

        sharedPrefManager = new SharedPrefManager(this);



        newusertext = (TextView) findViewById(R.id.newusertext);

        emailedittext = (EditText) findViewById(R.id.et_login_email);

        passwordedittext = (EditText) findViewById(R.id.et_login_password);

        emailsecond = emailedittext.getText().toString();

        button = (Button) findViewById(R.id.button1);


        button.setOnClickListener(this);

        newusertext.setOnClickListener(this);


    }



        @Override
        public void onClick(View view)
            {

            if (view.getId() == newusertext.getId())
            {

                Intent in = new Intent(LoginActivity.this, Registration.class);
                startActivity(in);

            }



            else if (view.getId() == button.getId())
            {

                if (!emailedittext.getText().toString().isEmpty())
                {


                    //if (emailsecond.matches(email_pattern))
                    //{


                    if (!passwordedittext.getText().toString().isEmpty())

                    {

                        //passwordedittext.setError("Please enter password");
                        //passwordedittext.requestFocus();


                        //Toast.makeText(this, "please enter pwd", Toast.LENGTH_SHORT).show();


                        if (emailedittext.getText().toString().equalsIgnoreCase("pramod@liyatechnology.com") && passwordedittext.getText().toString().equalsIgnoreCase("123456"))

                        {

                            DATA_URL = DATA_URL.replaceAll("\\s+", "");

                            hitApi();

                            hitApiForNotification();



                        }

                        else
                        {

                            Toast.makeText(this, "Please enter proper credentials", Toast.LENGTH_SHORT).show();

                        }
                        }

                    else
                    {


                        passwordedittext.setError("Please enter password");
                        passwordedittext.requestFocus();


                    }
                    }

                 /*else
                    {

                        emailedittext.setError("Please enter valid email");
                        emailedittext.requestFocus();



                    }


                     }*/

                else
                {

                    emailedittext.setError("Please enter email");
                    emailedittext.requestFocus();


                }
                }
                }




        private void hitApiForNotification()
        {


            String refreshedToken = FirebaseInstanceId.getInstance().getToken();


            Log.d("MainActivitySecond",   refreshedToken);


            storeToken(refreshedToken);

            sharedPrefManager = new SharedPrefManager(this);


            String   token = sharedPrefManager.getDeviceToken();

            Log.d("GetTokenValue",   token);



      //    hitApiNotificationSecond(token);


        }





        private void hitApiNotificationSecond(final String token)
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER_DEVICE,
                    new Response.Listener<String>()

                    {


                        @Override
                        public void onResponse(String response)

                        {

                            //progressDialog.dismiss();

                            try

                            {

                                //    JSONObject obj = new JSONObject(response);
                                //  String message = obj.getString("message");
                                //  Toast.makeText(MainActivitySecond.this,""+message , Toast.LENGTH_LONG).show();


                                Log.d("responsemessage",response.toString());

                            }

                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }

                    },
                    new Response.ErrorListener()
                    {

                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                          //progressDialog.dismiss();

                            Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        })

              {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    Map<String, String> params = new HashMap<String, String>();


                    String tokennews =  pref.getToken();

//                    String accesstokennew = accesstoken.replaceAll("^\"|\"$", "");


                String    snews = s + " "+ tokennews;



                    params.put("Authorization", snews);
                    return params;
                }







                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {

                    Map<String, String> params = new HashMap<>();


                    params.put("token", token);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);




        }






        //}

        public void storeToken(String token)
        {


            sharedPrefManager = new SharedPrefManager(this);

            sharedPrefManager.saveDeviceToken(token);
            //SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);
            Log.d("Token Saved",  token);

            Toast.makeText(this, "Token Saved"+token, Toast.LENGTH_SHORT).show();


            //we will save the token in sharedpreferences later


        }





        private void hitApi()

        {

            RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

            final JSONObject jsonObject = new JSONObject();


            try
            {
                jsonObject.put("email", "pramod@liyatechnology.com");
                jsonObject.put("password", "123456");

            }


            catch (JSONException e)
            {
                e.printStackTrace();
            }


            StringRequest sr = new StringRequest(Request.Method.POST, DATA_URL,
                    new Response.Listener<String>()

                    {

                        @Override
                        public void onResponse(String response)

                        {

                            //Log.e("HttpClient", "" + "Bearer "+ response.toString());

                           // Toast.makeText(LoginActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();


                            //tokennewstring  =  response.toString();

                            Log.d("Aceess Token",response.toString());

                            JSONObject jsonObject1 = null;

                            try

                            {


                                 jsonObject1 = new JSONObject(response);

                                 accesstoken  = jsonObject1.getString("access_token");


                                 pref.storeToken(accesstoken);

                                 String tokennews =  pref.getToken();

                                //Toast.makeText(LoginActivity.this, "Access Token"+tokennews, Toast.LENGTH_SHORT).show();


                               //Intent in = new Intent(LoginActivity.this, MainActivitySixth.class);
                               //in.putExtra("tokennewstring",token);

                               // startActivity(in);


                              }

                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }



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
                    params.put("Content-Type", "application/json; charset=utf-8");
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

        }
