package com.example.hp.ourassignmentapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;




/**
 * Created by HP on 07-08-2018.
 */







public class ProfileActivity extends AppCompatActivity implements View.OnClickListener

          {

           private static final int GALLERY_REQUEST = 1 ;

          private static final int MY_SOCKET_TIMEOUT_MS = 50000;

          EditText emailedittext,firstnameedittext,agreementedittext,rideredittext,lastnameedittext,contactnoedittext,alternatecontactnoedittext,dateofbirthedittext,cityedittext,bloodgroupedittext,addressedittext,pinedittext,adhaarnoedittext,dlnoedittext,dlexpiryedittext,vehicleedittext,vehicleregdetailedittext;

          Spinner spinner;

         Button updatebtn,changepwdbtn, button1,button656;

         ImageView image43,cameraimage,vehicleregimage,adhaarimageview,dlimageview;

         ArrayAdapter<String> arrayAdapter;

         String arr[]={"Select Gender","Male","Female"};


         String DATA_URL = "http://52.70.180.154/api/auth/user";

        String snew;

        private int GALLERY = 1;

        ImageView backiconimage;


        protected PrefManager pref;
        JSONObject jsonobject2;




              @Override
       protected void onCreate(@Nullable Bundle savedInstanceState)

        {

        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.fragment_myprofile);

            pref = new PrefManager(this);


            Intent in = getIntent();
        snew = in.getStringExtra("snew");

        spinner = (Spinner)findViewById(R.id.genderspinner);


        updatebtn = (Button) findViewById(R.id.updatebutton);


        changepwdbtn = (Button) findViewById(R.id.changepasswordbutton);


        cameraimage = (ImageView) findViewById(R.id.cameraimage);


        backiconimage = (ImageView) findViewById(R.id.backiconimage);



            arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_text1,R.id.text1,arr);
        spinner.setAdapter(arrayAdapter);


        firstnameedittext = (EditText)findViewById(R.id.et_first_name);

        lastnameedittext = (EditText)findViewById(R.id.et_last_name);


        emailedittext = (EditText)findViewById(R.id.et_email);


            contactnoedittext = (EditText)findViewById(R.id.et_contact_number);


            image43 = (ImageView)findViewById(R.id.image43);




            alternatecontactnoedittext = (EditText)findViewById(R.id.et_contact_number_alternate);


        bloodgroupedittext = (EditText)findViewById(R.id.et_blood_group);


        addressedittext = (EditText)findViewById(R.id.et_address);



        pinedittext = (EditText)findViewById(R.id.et_pin);



        cityedittext  = (EditText)findViewById(R.id.et_city);





            adhaarnoedittext = (EditText)findViewById(R.id.et_adhaarno);



        dateofbirthedittext = (EditText)findViewById(R.id.et_date_of_birth);




            button1 = (Button)findViewById(R.id.button1);


        adhaarimageview = (ImageView)findViewById(R.id.adhaarimageview);


        dlimageview = (ImageView)findViewById(R.id.dlimageview);



        vehicleregimage  = (ImageView)findViewById(R.id.vehicleregimage);




        dlnoedittext = (EditText)findViewById(R.id.et_dlno);



        dlexpiryedittext  = (EditText)findViewById(R.id.et_dlexpiry);



        vehicleedittext  = (EditText)findViewById(R.id.et_vehicle);



        vehicleregdetailedittext  = (EditText)findViewById(R.id.et_vehicle_regdetails);



        agreementedittext  = (EditText)findViewById(R.id.et_agreement);

        rideredittext  = (EditText)findViewById(R.id.et_rider);





        button656 = (Button)findViewById(R.id.button656);


         hitApiForProfile();



           button1.setOnClickListener(this);
            updatebtn.setOnClickListener(this);

            changepwdbtn.setOnClickListener(this);

           cameraimage.setOnClickListener(this);


            backiconimage.setOnClickListener(this);

          }




          private void hitApiForProfile()

             {

              RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);

              final JSONObject jsonObject = new JSONObject();


             /*try
              {
                  jsonObject.put("email", "pramod@liyatechnology.com");
                  jsonObject.put("password", "123456");

              }

              catch (JSONException e)
              {
                  e.printStackTrace();
              }

             */


              StringRequest sr = new StringRequest(Request.Method.GET, DATA_URL,
                      new Response.Listener<String>()
                      {

                          @Override
                          public void onResponse(String response)

                          {

                              Log.e("HttpClient", "" + "Bearer "+ response.toString());


                              //tokennewstring  =  response.toString();


                              JSONObject jsonObject1 = null;

                              try

                              {

                                  jsonObject1 = new JSONObject(response);

                                   jsonobject2 = jsonObject1.getJSONObject("success");

                                  String firstname = jsonobject2.getString("first_name");

                                  String lastname = jsonobject2.getString("last_name");

                                  String contactnumber = jsonobject2.getString("contact_number");


                                  String alterantecontact = jsonobject2.getString("contact_number_alternate");


                                  String dob = jsonobject2.getString("dob");


                                  String gender = jsonobject2.getString("gender");

                                  String blood_group = jsonobject2.getString("blood_group");


                                  String address = jsonobject2.getString("address");


                                  String city = jsonobject2.getString("city_id");

                                  String pin = jsonobject2.getString("pin");


                                  String aadhar_number = jsonobject2.getString("aadhar_number");

                                  String dl_number = jsonobject2.getString("dl_number");


                                  String dlexpiry = jsonobject2.getString("dl_expiry");

                                  String vehicle_type = jsonobject2.getString("vehicle_type");


                                  String vehicle_reg_details = jsonobject2.getString("vehicle_reg_details");

                                  String agreement_id = jsonobject2.getString("agreement_id");

                                  String  riderstatus = jsonobject2.getString("rider_status");


                                  JSONObject jsonobjectuser =     jsonobject2.getJSONObject("user");

                                  String email = jsonobjectuser.getString("email");

                                  emailedittext.setText(""+email);

                                  firstnameedittext.setText(""+firstname);

                                  lastnameedittext.setText(""+lastname);

                                  contactnoedittext.setText(""+contactnumber);

                                  alternatecontactnoedittext.setText(""+alterantecontact);

                                  contactnoedittext.setText(""+contactnumber);

                                  dateofbirthedittext.setText(""+dob);

                                  bloodgroupedittext.setText(""+blood_group);

                                  addressedittext.setText(""+address);

                                  cityedittext.setText(""+ city);

                                  pinedittext.setText(""+ pin);

                                  adhaarnoedittext.setText(""+ aadhar_number);

                                  dlnoedittext.setText(""+ dl_number);

                                  dlexpiryedittext.setText(""+dlexpiry);

                                  vehicleedittext.setText(""+vehicle_type);

                                  vehicleregdetailedittext.setText(""+vehicle_reg_details);

                                  agreementedittext.setText(""+agreement_id);

                                 rideredittext.setText(""+riderstatus);




                                  //String token  = jsonObject1.getString("access_token");

                                  //pref.storeToken(token);





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




          @Override
    public void onClick(View v)
        {

        if (v.getId() == button1.getId())
        {


            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
        }


         else if (v.getId() == cameraimage.getId())
            {


            /*Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);*/

          choosePhotoFromGallery();



            }


      else if(v.getId() == backiconimage.getId())
      {

            Intent in = new Intent(ProfileActivity.this,MainActivitySixth.class);

            String token = pref.getToken();


            in.putExtra("tokennewstring",token);
            startActivity(in);





        }







            else  if (v.getId() == updatebtn.getId())
        {


           /*Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST);*/



        }


        else  if (v.getId() == changepwdbtn.getId())
        {


            /*Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST);*/




        }

        }

           private void choosePhotoFromGallery()
           {



               Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                       MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

               startActivityForResult(galleryIntent, GALLERY);

           }


           @Override
           public void onActivityResult(int requestCode, int resultCode, Intent data)
           {

               super.onActivityResult(requestCode, resultCode, data);
               if (resultCode == this.RESULT_CANCELED)
               {
                   return;
               }
               //if (requestCode == GALLERY) {

                   if (data != null)
                   {
                       Uri contentURI = data.getData();
                       try
                       {

                           Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                            //String path = saveImage(bitmap);
                            //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();

                           image43.setImageBitmap(bitmap);

                       }
                       catch (IOException e)
                       {
                           e.printStackTrace();
                           //Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                       }
                   }

               }



/*           @Override
       public void onActivityResult(int requestCode, int resultCode, Intent data)
           {

           super.onActivityResult(requestCode, resultCode, data);

           if(resultCode == Activity.RESULT_OK)

               switch (requestCode)
                   {

                   case GALLERY_REQUEST:

                       Uri selectedImage = data.getData();

                       try
                       {

                           Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), selectedImage);
                           adhaarimageview.setImageBitmap(bitmap);

                       }

                       catch (IOException e)
                       {

                           Log.i("TAG", "Some exception " + e);

                       }


                       break;
                        }
                        }*/

                     }
