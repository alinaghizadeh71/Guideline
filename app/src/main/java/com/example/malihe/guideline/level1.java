package com.example.malihe.guideline;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import static com.example.malihe.guideline.R.id.listview;

public class level1 extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    //implements AdapterView.OnItemClickListener
    List<String> listitem;
    ListView list;
    MaterialSearchView searchView;
    String st[]={"hello","ahmad","malihe","ahmadmalihe"};
    String[] filllist;
    String key,title;
    int i;
    CharSequence item;
   public static String total;
    public static String totalb;
    CharSequence[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };
    Spanned[] spannedStrings1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1);

        //get ct or cta
        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            key=b.getString("key");
        }
        if(key.equals("ct"))
        {
            filllist= getResources().getStringArray(R.array.ct);
            total="ct";
            totalb="CT";
            i=1;
        }
        else if(key.equals("cta"))
        {
            filllist=getResources().getStringArray(R.array.cta);
            total="cta";
            totalb="CTA";
            i=1;
        }

        else if(key.equals("list_ct"))
        {
            filllist=getResources().getStringArray(R.array.ctlist);
            total="ct";
            totalb="CT";
            i=2;
        }
        else if(key.equals("list_cta"))
        {
            filllist=getResources().getStringArray(R.array.ctalist);
            total="cta";
            totalb="CTA";
            i=3;
        }



        //set Actionbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //NO PROB
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));


        //address
        TextView txt=(TextView)findViewById(R.id.txt);
        txt.setText(totalb);
       // txt.setRotation(float);






        //search in actionbar
        searchView=(MaterialSearchView)findViewById(R.id.Search_view);
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                list=(ListView)findViewById(listview);
                //String[] nafarat=getResources().getStringArray(R.array.ct);
                final int size = filllist.length;
                Spanned[] spannedStrings = new Spanned[size];
                for(int i=0; i<size; i++){
                    spannedStrings[i] = Html.fromHtml(filllist[i]);
                }
               /* ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(level1.this,R.layout.custom_textview,spannedStrings);
                list.setAdapter(adapter);*/
                ListAdapter adapter1=new ListAdapter(level1.this, spannedStrings);
                list.setAdapter(adapter1);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if(newText!=null && !newText.isEmpty())
                {
                    List<String> mylist=new ArrayList<>();
                    for (String item:filllist)
                    {
                     if(item.contains(newText))
                         mylist.add(item);

                    }

                    final int size1 = mylist.size();
                    Spanned[] spannedStrings1 = new Spanned[size1];
                    for(int i=0; i<size1; i++){
                        spannedStrings1[i] = Html.fromHtml(mylist.get(i));
                    }
                    ListAdapter adapter1=new ListAdapter(level1.this, spannedStrings1);
                    list.setAdapter(adapter1);

                }
                else
                    {

                        final int size = filllist.length;
                        Spanned[] spannedStrings = new Spanned[size];
                        for(int i=0; i<size; i++){
                            spannedStrings[i] = Html.fromHtml(filllist[i]);
                        }

                        ListAdapter adapter1=new ListAdapter(level1.this, spannedStrings);
                        list.setAdapter(adapter1);
                }
                return false;
            }
        });


        setTitle("level1");


        //fill listview
        list=(ListView)findViewById(listview);
        final int size = filllist.length;
        Spanned[] spannedStrings = new Spanned[size];
        for(int i=0; i<size; i++){
            spannedStrings[i] = Html.fromHtml(filllist[i]);
        }
        ListAdapter adapter1=new ListAdapter(level1.this, spannedStrings);
        list.setAdapter(adapter1);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setOnItemClickListener(this);

        //Toast.makeText(level1.this,String.valueOf(size),Toast.LENGTH_LONG).show();

                     /*   final ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>
                                (this,R.layout.custom_textview,spannedStrings){
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent){
                                // Get the current item from ListView
                                View view = super.getView(position,convertView,parent);
                                if(position %2 == 1)
                                {
                                    // Set a background color for ListView regular row/itemADD8E6
                                    view.setBackgroundColor(Color.parseColor("#ADD8E6"));
                                }
                                else
                                {
                                    // Set the background color for alternate row/itemF5FFFA
                                    view.setBackgroundColor(Color.parseColor("#F5FFFA"));
                                }
                                return view;
                            }
                        };*/

        // DataBind ListView with items from ArrayAdapter
        // list.setAdapter(arrayAdapter);


      /*  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });*/

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        if(i==1)
        {
            item = (CharSequence) parent.getItemAtPosition(position);
            title = total + "_" + String.valueOf(position + 1);
        }

        else if(i==2)
        {
            item = getResources().getStringArray(R.array.ctlist)[position];
            title =  total + "_" + getResources().getStringArray(R.array.ctlist_values)[position];
            //Toast.makeText(list.this,value,Toast.LENGTH_LONG).show();
        }
        else if(i==3)
        {
            item = getResources().getStringArray(R.array.ctalist)[position];
            title =  total + "_" + getResources().getStringArray(R.array.ctalist_values)[position];
            //Toast.makeText(list.this,value,Toast.LENGTH_LONG).show();
        }
        // Toast.makeText(level1.this,item,Toast.LENGTH_LONG).show();
       //  Toast.makeText(level1.this,title,Toast.LENGTH_LONG).show();

        int arryid = level1.this.getResources().getIdentifier(title, "array", level1.this.getPackageName());

        //Toast.makeText(level1.this, String.valueOf(arryid), Toast.LENGTH_LONG).show();
        if (arryid > 0) {
            //  Toast.makeText(level1.this,item,Toast.LENGTH_LONG).show();
            Intent i = new Intent(level1.this, level2.class);
            Bundle b = new Bundle();
            // b.putStringArray("key", termsArray);
            //i.putExtra("key", String.valueOf(position + 1));
            i.putExtra("id", String.valueOf(arryid));
            i.putExtra("cap", totalb + " -> " + item);
            i.putExtra("l1", totalb);
            i.putExtra("l2", item);
            i.putExtra("title", title);
            startActivity(i);
        } else {
            Toast.makeText(level1.this, "This list has not any sub item", Toast.LENGTH_LONG).show();
        }



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Home:
                Intent i=new Intent(level1.this,MainActivity.class);
                startActivity(i);
                return true;
            case R.id.back:
                Intent ii=new Intent(level1.this,MainActivity.class);
                startActivity(ii);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

}
