package com.example.hp.ourassignmentapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 14-08-2018.
 */


public class UpcomingOrderAdapter extends RecyclerView.Adapter<UpcomingOrderAdapter.MyViewHolder>

   {

    private List<OrderHistoryModel> orderHistories;
    public Context context;
    protected PrefManager pref;
    int orderid,riderid;
    private static final int MY_SOCKET_TIMEOUT_MS = 50000;
    String DATA_URL  = "http://52.70.180.154/api/auth/orderstatus";

       String s = "Bearer";
     String snew;





    public UpcomingOrderAdapter(Context context, List<OrderHistoryModel> orderHistories)
    {
        this.orderHistories = orderHistories;
        this.context = context;
    }



    @Override
    public UpcomingOrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activeorder_listrow, parent, false);


        return new UpcomingOrderAdapter.MyViewHolder(itemView);


    }







    @Override
    public void onBindViewHolder(UpcomingOrderAdapter.MyViewHolder holder, int position)

        {

        OrderHistoryModel order = orderHistories.get(position);

        //holder.tvName.setText(order.getVendorName());

        //holder.tvExpireDate.setText(order.getVendorNo());


        //holder.tvOrderId.setText(order.getOrderId());


        //holder.tvPickUpLocation.setText(order.getPickUpAddress());

        //holder.tvDropLocation.setText(order.getDeliveryAddress());


        // holder.tvOrderDate.setText(order.getdate());

        // holder.acceptedbtn.setText(order.getDeliveryStatus());


       /* holder.acceptedbtn.setOnClickListener(new View.OnClickListener()
          {
            @Override
            public void onClick(View view)
            {

                Toast.makeText(context, "Action Performed", Toast.LENGTH_SHORT).show();

            }
            });


             }*/

        //}


        //OrderHistoryModel order = orderHistories.get(position);


        holder.tvName.setText(order.getVendorName());

        //holder.tvExpireDate.setText(order.getVendorNo());


        //holder.tvOrderId.setText(order.getOrderId());

        orderid = order.getOrderId();

       //riderid = order.getRiderId();


        holder.tvPickUpLocation.setText(order.getPickUpAddress());

        holder.tvDropLocation.setText(order.getDeliveryAddress());



        holder.tvOrderDate.setText(order.getdate());

        //holder.acceptedbtn.setText(order.getDeliveryStatus());


        holder.acceptedbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {


                hitApi();

            }
           });


    }

    private void hitApi()

    {


        RequestQueue queue = Volley.newRequestQueue(context);
        //       String url ="http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, DATA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            String message = obj.getString("message");
                            Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Now you can manipulate/store your JSON
                        //   Log.d("tryresponse",response.toString());


                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {

                pref = new PrefManager(context);

                String token = pref.getToken();

                snew = s + " "+ token;






                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", snew);
                return params;


            }





            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("status", "Completed");
                params.put("order_id", String.valueOf(orderid));
                params.put("rider_id",String.valueOf(riderid));
                //params.put("deviceid", Cons.deviceId(getApplicationContext()));
                //   Log.d(TAG, "Login Params : " + params.toString());
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    @Override
    public int getItemCount()


    {
        return orderHistories.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView tvName, tvOrderId, tvPickUpLocation, tvDropLocation, tvOrderStore, tvOrderDate, tvSemester, tvExpireDate, tvSubjectName, tvPrice;
        public Button acceptedbtn;


        public MyViewHolder(View view)
        {
            super(view);


            tvName = (TextView) view.findViewById(R.id.nametext);
            tvPrice = (TextView) view.findViewById(R.id.pricetext);
            tvOrderId = (TextView) view.findViewById(R.id.ordernotext);

            tvOrderDate = (TextView) view.findViewById(R.id.datetext);


            tvPickUpLocation = (TextView) view.findViewById(R.id.pickuplocationdetailtext);


            tvDropLocation = (TextView) view.findViewById(R.id.droplocationdetailtext);


            acceptedbtn = (Button) view.findViewById(R.id.acceptedbutton);


        }
    }
}
