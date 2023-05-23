package com.example.malihe.guideline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class dashboard extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
          new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(dashboard.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, SPLASH_TIME_OUT);
      /*  WebView wv = (WebView)findViewById(R.id.webView1);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setContentDescription("application/pdf");
        wv.loadUrl("file:///android_asset/alinaghizade.pdf");*/
    }
}
