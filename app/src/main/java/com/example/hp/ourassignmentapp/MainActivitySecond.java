package com.example.hp.ourassignmentapp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;



import java.util.HashMap;
import java.util.Map;

import static com.example.hp.ourassignmentapp.NotificationPoints.URL_REGISTER_DEVICE;





/**
 * Created by HP on 25-08-2018.
 */






public class MainActivitySecond extends AppCompatActivity implements View.OnClickListener

        {


        Button button;
        TextView textView;
        SharedPrefManager sharedPrefManager;
        EditText edittext;
        String emailtext;

        private ProgressDialog progressDialog;

        //String token;







     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState)
            {

           super.onCreate(savedInstanceState);

           setContentView(R.layout.activity_main_second);

           //Log.d("meesage received","");

            sharedPrefManager = new SharedPrefManager(this);




            textView = (TextView)findViewById(R.id.text54);

            button = (Button) findViewById(R.id.button1);

            edittext = (EditText) findViewById(R.id.edittext);

            button.setOnClickListener(this);
            //Log.d("Get Token", token);

              }




        public void storeToken(String token)
        {


            sharedPrefManager = new SharedPrefManager(this);

            sharedPrefManager.saveDeviceToken(token);
            //SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);
            Log.d("Token Saved",  token);

            //we will save the token in sharedpreferences later


        }



            @Override
              public void onClick(View view)

             {

                 String refreshedToken = FirebaseInstanceId.getInstance().getToken();


                 Log.d("MainActivitySecond",   refreshedToken);


                 storeToken(refreshedToken);

                String   token = sharedPrefManager.getDeviceToken();

                 Log.d("GetTokenValue",   token);



                 hitApi(token);




              }




            private void hitApi(final String token)

              {

             //emailtext = edittext.getText().toString();

             //progressDialog = new ProgressDialog(this);

              //progressDialog.setMessage("Registering Device...");


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
                                progressDialog.dismiss();

                                Toast.makeText(MainActivitySecond.this, error.getMessage(), Toast.LENGTH_LONG).show();
                            }
                            })

                   {
                  @Override
                  public Map<String, String> getHeaders() throws AuthFailureError
                  {
                      Map<String, String> params = new HashMap<String, String>();
                      params.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijg2MGQ2ODg4NGY4NWJmMmQ3ZTc5NjljNDFhZDQ0NWU4MjI2ZmExMWRjYjgzZmVlNzhmMTBmZDhiNzVhMDZkNTBkMGRkZjgyY2Q5M2Q0NTEzIn0.eyJhdWQiOiIxIiwianRpIjoiODYwZDY4ODg0Zjg1YmYyZDdlNzk2OWM0MWFkNDQ1ZTgyMjZmYTExZGNiODNmZWU3OGYxMGZkOGI3NWEwNmQ1MGQwZGRmODJjZDkzZDQ1MTMiLCJpYXQiOjE1MzQyMjA3ODksIm5iZiI6MTUzNDIyMDc4OSwiZXhwIjoxNTY1NzU2Nzg5LCJzdWIiOiIzIiwic2NvcGVzIjpbXX0.lXuVG5DyO7ohmKCjDLmRJgthpItyC5cPcqKirn4OWVcHcavRBrtlenl9YYFwN9tXNgvsgMHYqpJmquCid9PMsecrqsheePmZggK4lNxo1RX0qVRWUjoQrHRnKerFOaYIj6i8opC5t32LrkGq1wjrjufKuQguRMMUnG2ajo7OGMVwOan-2eUmfHwjKE-Dhl2K_i0926bMg8KefeNkbZzePYZQz0gMCJbqXUSJnZeis7S1N-52bjysz4gDxZex-spMUJKNHZY1teSg8PFknON-Q3yS11jnuwyI8dTEuB4edEHr8PQB47iKIgMrBHFpeG2QuNoFR7h8u_1omjzY5OCVdtVNmgV0E_QgzBpBH2c9AvsX1mE9jgaTaS0GojUAFWnwRe2aPdvjVBv9yu-bgjmbjb5mI6lG3TVaSR75tiE2oThxpROTJlQrvrgxVhBM4CPOQEubs89qrwUsViHTXH3cgCwm3oL4rZwgZtXsqx2yHlRSiMphjW082C_uxYe0VkKL5GBjdTLW2KXcciS1DRxP76DS9mOEFAH6KoXhiYXPMb91XVrGXXH_IKKPq2vHSDR49bqAanUzGXHWKqHRdqBwXN3Mnd2RdiEChq-Fe0p1cudhXJEkXkT-S_2YSVM5r1WBrU56xAsbQ-eQUgzlWZmtJO-ZMTfUywPFm1w3ZtacsKU");
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



                     }
