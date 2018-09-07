package com.example.hp.ourassignmentapp;





import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


//Firebase tutorial
//https://demonuts.com/firebase-push-notification/


//https://demonuts.com/firebase-push-notification-multiple/


// Refreshed token:
// dyJNsO5Dy9U:APA91bFs35TMRm-oa6OTs7IhkRmjngvbgQYyNWzxNjfrDt9ci-LbczWLsfWF4bMrLHfV0B1yGcSiwa04maCDWz3Fid9Wn4U5nhYPKMe8FoqbXwJ19alp8KYTbgtUSFMw-UQ6FSspNjdx



// Manually Add Firebase


//  https://console.firebase.google.com/
//  GoogleNotificationDemo(Project in firebase)

//  https://console.firebase.google.com/project/notificationdemo-7784d/settings/privacy

//  get config file and download google play services json file in app folder in project directory

//  add this line    classpath 'com.google.gms:google-services:4.0.0' in build.gradle(project)
//  add this line  in build.gradle(app)
//  compile 'com.google.firebase:firebase-core:16.0.1'
         //}

//apply plugin: 'com.google.gms.google-services'



        //Server key
        //AAAAiwaE6cM:APA91bGbWcbcYKMrEqeUIyrt0Sz8vw9wRcVw0dGPYsvA5Y2ZOqwqB3z2YtWKulk-oozfmMW85jlVDJYrQpgHBkEZU2sCJds63JrLLYL_FG2X9yxA4aocfqjqdFVhBDgGGbtx4YnHonbb

       // Server key
       // AAAAiwaE6cM:APA91bF0EukmwWNz-szRsgRDLnfGhuqTYSwMuj1DNkWR9lzI5lSFJcdfC0_9lb-mOOc8aeqCQ1zkh4wgTMjLdhiH7HrO91B4-7L0r-mRYvsYhhYdWBv-Oel8tS7JSOSCc4VljkbZ1-f7

       // Legacy server key
       // AIzaSyAWc54AI9yLJ37eg7qi48RaC0Qu9Lv-Nqk





       public class MainActivity extends AppCompatActivity

        {

        private WebView mWebview ;




        @Override
        protected void onCreate(Bundle savedInstanceState)
       {

        super.onCreate(savedInstanceState);

        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true);         // enable javascript

         final Activity activity = this;


          mWebview.setWebViewClient(new WebViewClient()
           {

            @SuppressWarnings("deprecation")


            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {

                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();

            }



            @TargetApi(android.os.Build.VERSION_CODES.M)

            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr)
            {
                // Redirect to deprecated method, so you can use it in all SDK versions

                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());


            }
            });




         mWebview .loadUrl("https://cdrreport.net/");
         setContentView(mWebview );

          }

          }
