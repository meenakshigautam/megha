package com.example.hp.ourassignmentapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


public class PrefManager
     {

         private SharedPreferences pref;
         private SharedPreferences.Editor editor;
         private Context mContext;
         int PRIVATE_MODE = 0;
         private static final String PREF_NAME = "InkpotOnlineSharedPrefNew";
         private static final String KEY_NOTIFICATIONS = "notifications";
         static Context mCtx;

         public static final String KEY_TOKEN = "tokensecond";

         public static final String KEY_LOGGED_IN = "isLoggedIn";
         static PrefManager mInstance;

         static final String SHARED_PREF_NAME = "FCMSharedPrefnewssecondthirdforth";
         static final String TAG_TOKEN = "tagtokenfirstsecond";


    public PrefManager(Context context)
    {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }










         public static synchronized PrefManager getInstance(Context context)
         {

             if (mInstance == null)
             {
                 mInstance = new PrefManager(context);
             }
             return mInstance;

         }


         //this method will save the device token to shared preferences
         public boolean saveDeviceToken(String token)
         {
             SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
             SharedPreferences.Editor editor = sharedPreferences.edit();
             editor.putString(TAG_TOKEN, token);
             editor.apply();
             return true;
         }


         //this method will fetch the device token from shared preferences
         public String getDeviceToken() {
             SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
             return sharedPreferences.getString(TAG_TOKEN, null);
         }




         //for store token-->

    public void storeToken(String token)

    {

        editor.putString(KEY_TOKEN, token);

        editor.putBoolean(KEY_LOGGED_IN, true);

        editor.commit();

    //    Toast.makeText(mContext, "Data saved"+token, Toast.LENGTH_SHORT).show();


    }


         public boolean isLoggedIn()
         {

             return pref.getBoolean(KEY_LOGGED_IN, false);

         }



         //for getting token-->


         public String getToken()
      {

          return pref.getString(KEY_TOKEN,null);




      }


         public void clearSession()
         {
             editor.clear();
             editor.commit();
             Toast.makeText(mContext, "cleared all data", Toast.LENGTH_SHORT).show();

             //Log.d("TAG", "Deleted all user info from shared preference");
         }




    /*public HashMap<String, String> getUserDetail()
    {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_USER_ID, pref.getString(KEY_USER_ID, null));
        user.put(KEY_USER_IMAGE, pref.getString(KEY_USER_IMAGE, null));
        user.put(KEY_USER_REGTYPE, pref.getString(KEY_USER_REGTYPE, null));
        user.put(KEY_USER_NAME, pref.getString(KEY_USER_NAME, null));
        user.put(KEY_USER_REGEMAIL, pref.getString(KEY_USER_REGEMAIL, null));
        user.put(KEY_USER_LAST_NAME, pref.getString(KEY_USER_LAST_NAME, null));


        return user;
    }


    public HashMap<String, String> getPrefCourseData() {
        HashMap<String, String> userDetail = new HashMap<>();
        userDetail.put(KEY_SUBJECT_ID, pref.getString(KEY_SUBJECT_ID, null));
        return userDetail;
    }

    public String getDataItem() {
        return pref.getString(KEY_USER_PURCHASED, null);
    }

    public void setDataItem(String r_purchsed) {
        editor.putString(KEY_USER_PURCHASED, r_purchsed);
        editor.commit();
    }

    public String getCustId() {
        return pref.getString(KEY_USER_ID, null);
    }

    //    set/get for user email
    public String getEmail() {
        return pref.getString(KEY_USER_REGEMAIL, null);
    }

    public void setEmail(String r_email) {
        editor.putString(KEY_USER_REGEMAIL, r_email);
        editor.commit();
    }

    public void setCourseIcon(String icon) {
        editor.putString(KEY_COURSE_ICON, icon);
        editor.commit();
    }

    public String getCourseIcon() {
        return pref.getString(KEY_COURSE_ICON, null);
    }


    public void setCourseColor(String color) {
        editor.putString(KEY_COURSE_COLOR, color);
        editor.commit();
    }

    public String getCourseColor() {
        return pref.getString(KEY_COURSE_COLOR, null);
    }

    public void setSubjectIdArray(String[] s ) {

        String stringIdArray = null;

        for(int i=0;i<s.length;i++) {

            if(stringIdArray == null)
            {
                stringIdArray = s[i];
            }
            else
            {
                stringIdArray = stringIdArray + "," + s[i];
            }
        }

        editor.putString(KEY_SUBJECT_ID,stringIdArray);
        editor.commit();

    }

    public String getSubjectIdArray()
    {
        return pref.getString(KEY_SUBJECT_ID, null);
    }

    public String getPass() {
        return pref.getString(KEY_USER_PASS, null);
    }

    public String getType() {
        return pref.getString(KEY_USER_REGTYPE, null);
    }

    //set/get for user mobile number
    public String getmobile() {
        return pref.getString(KEY_USER_MOBILE, null);
    }

    public void setuser_mobile(String r_mobile) {
        editor.putString(KEY_USER_MOBILE, r_mobile);
        editor.commit();
    }

    public void setTokenToServer(boolean b) {
        editor.putBoolean(KEY_TOKEN_SERVER, b);
        editor.commit();
    }

    public boolean getTokenToServer() {
        return pref.getBoolean(KEY_TOKEN_SERVER, false);
    }

    //for user login session
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_LOGGED_IN, false);
    }

    public void addNotification(String notification) {

        // get old notifications
        String oldNotifications = getNotifications();

        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }

        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
        editor.commit();
    }

    public String getNotifications() {
        return pref.getString(KEY_NOTIFICATIONS, null);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
        Log.d("TAG", "Deleted all user info from shared preference");
    }*/


     }
