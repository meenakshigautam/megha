package com.example.hp.ourassignmentapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Akshay on 9/6/2017.
 */





public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder>

   {

    private List<OrderHistoryModel> orderHistories;
    public Context context;
    protected PrefManager pref;
    int orderid,riderid;


    public OrderDetailsAdapter(Context context, List<OrderHistoryModel> orderHistories)
    {
        this.orderHistories = orderHistories;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderdetail_listrow, parent, false);


        return new MyViewHolder(itemView);


    }


    @Override
    public void onBindViewHolder(OrderDetailsAdapter.MyViewHolder holder, int position) {

        OrderHistoryModel order = orderHistories.get(position);

        //  holder.tvName.setText(order.getVendorName());

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


      //  OrderHistoryModel order = orderHistories.get(position);


        holder.tvName.setText(order.getVendorName());

        //holder.tvExpireDate.setText(order.getVendorNo());


        //holder.tvOrderId.setText(order.getOrderId());

        orderid = order.getOrderId();

        riderid = order.getRiderId();


        holder.tvPickUpLocation.setText(order.getPickUpAddress());

        holder.tvDropLocation.setText(order.getDeliveryAddress());



        holder.tvOrderDate.setText(order.getdate());

        //holder.acceptedbtn.setText(order.getDeliveryStatus());













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
