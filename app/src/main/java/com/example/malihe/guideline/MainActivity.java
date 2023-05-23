package com.example.malihe.guideline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WebView  wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // wv = (WebView)findViewById(R.id.webView1);
      /*  ImageButton imgb=(ImageButton)findViewById(R.id.imgbb);
        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,about.class);
                startActivity(i);

            }
        });*/
        Button ct=(Button)findViewById(R.id.ct);
        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,level1.class);
                i.putExtra("key","ct");
                startActivity(i);
            }
        });

        Button cta=(Button)findViewById(R.id.cta);
        cta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,level1.class);
                i.putExtra("key","cta");
                startActivity(i);
            }
        });

        Button pdf=(Button)findViewById(R.id.pdf);
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,viewpdf.class);
                startActivity(i);
            }
        });
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.List);
       // spinner.setPrompt("List of diseases");

        spinner.requestFocus();

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("List of diseases:");
        categories.add("CT");
        categories.add("CTA");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.item_spinner, categories);

        // Drop down layout style - list view with radio button
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        // attaching data adapter to spinner
      spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
              // Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                if (selectedItem.equals("CT")) {
                    Intent i=new Intent(MainActivity.this,level1.class);
                    i.putExtra("key","list_ct");
                    startActivity(i);
                  //  Toast.makeText(getBaseContext(), selectedItem, Toast.LENGTH_SHORT).show();
                }
                else if(selectedItem.equals("CTA"))
                {
                    Intent i=new Intent(MainActivity.this,level1.class);
                    i.putExtra("key","list_cta");
                    startActivity(i);
                   // Toast.makeText(getBaseContext(), selectedItem, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.about:
                Intent i=new Intent(MainActivity.this,about.class);
                startActivity(i);
                return true;
            case R.id.favorites:
                Intent ii=new Intent(MainActivity.this,favorites.class);
                startActivity(ii);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static long back_pressed = 0L;

    @Override
    public void onBackPressed()
    {
        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), "برای خروج دوباره بازگشت را بزنید!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}
