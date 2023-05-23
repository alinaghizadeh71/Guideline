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

public class level2 extends AppCompatActivity {
ListView mylist;
    String finaltxt;
    String key;
    String title;
    ListView list;
    MaterialSearchView searchView;
    String[] termsArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2);
        //set Actionbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //NO PROB
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));


        //address
        TextView txt=(TextView)findViewById(R.id.txt);

      // setTitle("level1-->Headache");

        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            // key=b.getString("key");
            title=b.getString("title");
        }
finaltxt=b.getString("cap").toString();
//=b.getString("total")+": -> "+b.getString("cap");
        txt.setText(finaltxt);
        int arryid =Integer.valueOf(b.getString("id"));

        Toast.makeText(level2.this,String.valueOf(finaltxt)+"\n"+title,Toast.LENGTH_LONG).show();

        termsArray  = this.getResources().getStringArray(arryid);



        //fill listview
        list=(ListView)findViewById(R.id.list1);

       final int size = termsArray.length;
       // Toast.makeText(level2.this,String.valueOf(size),Toast.LENGTH_LONG).show();
        Spanned[] spannedStrings = new Spanned[size];
        for(int i=0; i<size; i++){
            spannedStrings[i] = Html.fromHtml(termsArray[i]);
        }

                       /* final ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>
                                (this,R.layout.custom_textview,spannedStrings){
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent){
                                // Get the current item from ListView
                                View view = super.getView(position,convertView,parent);
                                if(position %2 == 1)
                                {
                                    // Set a background color for ListView regular row/item
                                    view.setBackgroundColor(Color.parseColor("#ADD8E6"));
                                }
                                else
                                {
                                    // Set the background color for alternate row/item
                                    view.setBackgroundColor(Color.parseColor("#F5FFFA"));
                                }
                                return view;
                            }
                        };*/

                        // DataBind ListView with items from ArrayAdapter
                    ListAdapter adapter1=new ListAdapter(level2.this, spannedStrings);
                    list.setAdapter(adapter1);




        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CharSequence item = (CharSequence) parent.getItemAtPosition(position);
              //  Toast.makeText(level2.this,String.valueOf(position),Toast.LENGTH_LONG).show();
                //Toast.makeText(level2.this,item,Toast.LENGTH_LONG).show();
                        String st=title+"_"+String.valueOf(position+1);
                       // Toast.makeText(level2.this,item,Toast.LENGTH_LONG).show();
                        int arryid = level2.this.getResources().getIdentifier(st, "array",
                                level2.this.getPackageName());



                        if (arryid>0) {
                           // String[] termsArray  = level2.this.getResources().getStringArray(arryid);
                            Intent i = new Intent(level2.this, level3.class);
                            i.putExtra("id", String.valueOf(arryid));
                            i.putExtra("cap",finaltxt+" -> "+item);
                            i.putExtra("st",st);
                            startActivity(i);
                        } else {
                            Toast.makeText(level2.this,"This list has not any sub item",Toast.LENGTH_LONG).show();
                        }

            }
        });


        //search in actionbar
                            searchView=(MaterialSearchView)findViewById(R.id.Search_view);
                            searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
                                @Override
                                public void onSearchViewShown() {

                                }

                                @Override
                                public void onSearchViewClosed() {
                                    list=(ListView)findViewById(R.id.list1);
                                   final int size = termsArray.length;
                                    Spanned[] spannedStrings = new Spanned[size];
                                    for(int i=0; i<size; i++){
                                        spannedStrings[i] = Html.fromHtml(termsArray[i]);
                                    }
               /* ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(level1.this,R.layout.custom_textview,spannedStrings);
                list.setAdapter(adapter);*/
                                    ListAdapter adapter1=new ListAdapter(level2.this, spannedStrings);
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
                                        for (String item:termsArray)
                                        {
                                            if(item.contains(newText))
                                                mylist.add(item);
                                        }
                                        final int size1 = mylist.size();
                                        Spanned[] spannedStrings1 = new Spanned[size1];
                                        for(int i=0; i<size1; i++){
                                            spannedStrings1[i] = Html.fromHtml(mylist.get(i));
                                        }
                                        ListAdapter adapter1=new ListAdapter(level2.this, spannedStrings1);
                                        list.setAdapter(adapter1);

                                    }
                                    else
                                    {
                                        final int size = termsArray.length;
                                        Spanned[] spannedStrings = new Spanned[size];
                                        for(int i=0; i<size; i++){
                                            spannedStrings[i] = Html.fromHtml(termsArray[i]);
                                        }

                                        ListAdapter adapter1=new ListAdapter(level2.this, spannedStrings);
                                        list.setAdapter(adapter1);
                                    }
                                    return false;
                                }
                            });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Home:
                Intent i=new Intent(level2.this,MainActivity.class);
                startActivity(i);
                return true;
            case R.id.back:
                /*Intent ii=new Intent(level2.this,level1.class);
                startActivity(ii);
                this.finish();
                return true;*/
                this.finish();
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
