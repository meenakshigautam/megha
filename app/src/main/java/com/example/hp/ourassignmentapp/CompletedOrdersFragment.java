package com.example.hp.ourassignmentapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by HP on 08-08-2018.
 */






   public class CompletedOrdersFragment extends Fragment

           {

          JSONObject jsonobject1;
          private static final String TAG = "CompletedOrders";

          RecyclerView recyclerView;

          String DATA_URL = "http://52.70.180.154/api/auth/completedorders";

          private static final int MY_SOCKET_TIMEOUT_MS = 50000;

          public List<OrderHistoryModel> orderHistories;

          private OrderDetailsAdapter mAdapter;

          protected PrefManager pref;

          String token;

          String s = "Bearer";

          String snew;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)

          {


          View view = inflater.inflate(R.layout.fragment_completed_orders,container,false);

          pref = new PrefManager(getActivity());

          token = pref.getToken();

           //Intent in = getIntent();

           //tokennewstring = in.getStringExtra("tokennewstring");


          //tokennewstringnew = tokennewstring.replaceAll("^\"|\"$", "");


           snew = s + " "+ token;




          recyclerView = (RecyclerView)view.findViewById(R.id.rvList_order);

          orderHistories = new ArrayList<>();

          recyclerView = (RecyclerView)view.findViewById(R.id.rvList_order);

          mAdapter = new OrderDetailsAdapter(getActivity(), orderHistories);

          RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

          recyclerView.setLayoutManager(mLayoutManager);
          recyclerView.setAdapter(mAdapter);

          hitApi();


         return view;


           }




       public void hitApi()

           {


           RequestQueue queue = Volley.newRequestQueue(getActivity());


               StringRequest sr = new StringRequest(Request.Method.GET, DATA_URL,
                       new Response.Listener<String>()
                       {

                           @Override
                           public void onResponse(String response)
                           {

                               try {

                                   //JSONArray array = new JSONArray(response);

                                   jsonobject1 = new JSONObject(response);

                                   Log.d("completedorderresponse",response.toString());

                                   JSONArray jsonarray1 = jsonobject1.getJSONArray("data");


                                   for (int i = 0; i < jsonarray1.length(); i++)

                                      {

                                          JSONObject object = jsonarray1.getJSONObject(i);




                                          OrderHistoryModel orderhistorymodel = new OrderHistoryModel();



                                          int orderid = Integer.parseInt(object.getString("order_id"));

                                          orderhistorymodel.setOrderId(orderid);


                                          int riderid = Integer.parseInt(object.getString("rider_id"));

                                          orderhistorymodel.setRiderId(riderid);



                                          orderhistorymodel.setVendorName(object.getString("vendor_name"));




                                          orderhistorymodel.setPickUpAddress(object.getString("pick_up_address"));




                                          orderhistorymodel.setDeliveryAddress(object.getString("drop_address"));


                                          orderhistorymodel.setDate(object.getString("date"));



                                          orderhistorymodel.setDeliveryStatus(object.getString("delivery_status"));



                                          //orderhistorymodel.setStore(object.getString("store"));

                                    //   int no = Integer.parseInt(object.getString("number"));

                                      // orderhistorymodel.setVendorNo(no);








                                        /*JSONArray jsonarray5 = object.getJSONArray("order_details");

                                       JSONObject jsonObject9 = jsonarray5.getJSONObject(0);


                                       String date = jsonObject9.getString("date");


                                       orderhistorymodel.setDate(date);*/


                                       //orderHistories.add(orderhistorymodel);



                                         /*JSONArray jsonaaray = object.getJSONArray("order_details");

                                       for (int j = 0; j < jsonaaray.length(); j++)
                                       {


                                           JSONObject jsonobect54 = jsonaaray.getJSONObject(j);


                                           orderhistorymodel.setDate(jsonobect54.getString("order_description"));

                                      }*/




                                       orderHistories.add(orderhistorymodel);



                                       }


                                       }

                               catch (JSONException e)
                               {
                                   e.printStackTrace();
                               }
                               mAdapter.notifyDataSetChanged();
                                }
                       }, new Response.ErrorListener()
                    {

                   @Override
                   public void onErrorResponse(VolleyError error)
                   {
                       Log.d(TAG, "Error : " + error.toString());
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
                   return jsonobject1.toString().getBytes();
               }
               };



           sr.setRetryPolicy(new DefaultRetryPolicy(
                   MY_SOCKET_TIMEOUT_MS,
                   DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                   DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
           queue.add(sr);

           }

           }


