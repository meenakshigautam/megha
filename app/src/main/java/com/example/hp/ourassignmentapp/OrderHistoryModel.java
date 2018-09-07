package com.example.hp.ourassignmentapp;

/**
 * Created by Akshay on 9/6/2017.
 */


public class OrderHistoryModel

     {

    public String deliverystatus,pickupaddress,deliveryaddress, dropaddress, vendoraddress,vendorname,date,store,subject_id, subject_name, semester, price, discount, tax, expiredate;
    int orderid,riderid,vendorno,vendorid;


    public OrderHistoryModel()
    {

    }


    public String getVendorName()


    {
        return vendorname;
    }


    public void setVendorName(String vendorname)


    {
        this.vendorname = vendorname;
    }




         public int getOrderId()


         {
             return orderid;
         }


         public void setOrderId(int orderid)


         {
             this.orderid = orderid;
         }





         public int getRiderId()


         {
             return riderid;
         }


         public void setRiderId(int riderid)


         {
             this.riderid = riderid;
         }




         public String getDeliveryStatus()


         {
             return deliverystatus;
         }


         public void setDeliveryStatus(String deliverystatus)


         {
             this.deliverystatus = deliverystatus;
         }











         public String getPickUpAddress()


         {
             return pickupaddress;
         }


         public void setPickUpAddress(String pickupaddress)


         {
             this.pickupaddress = pickupaddress;
         }





         public String getDeliveryAddress()


         {
             return deliveryaddress;
         }


         public void setDeliveryAddress(String deliveryaddress)


         {
             this.deliveryaddress = deliveryaddress;
         }






         public int getVendorId()

         {
             return vendorid;
         }


         public void setVendorId(int vendorid)
         {
             this.vendorid = vendorid;
         }




         public String getDropAddress()

         {
             return vendoraddress;
         }


         public void setDropAddress(String dropaddress)
         {
             this.dropaddress = dropaddress;
         }











         public int getVendorNo()

    {
        return vendorno;
    }


    public void setVendorNo(int vendorno)

    {
        this.vendorno = vendorno;
    }




         public String getdate()

         {
             return date;
         }


         public void setDate(String date)

         {
             this.date = date;
         }










         public String getStore()

         {
             return store;
         }


         public void setStore(String store)

         {
             this.store = store;
         }
















         public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public OrderHistoryModel(String subject_id, String subject_name, String semester, String price, String discount, String tax, String expiredate) {

        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.semester = semester;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
        this.expiredate = expiredate;
    }

   }