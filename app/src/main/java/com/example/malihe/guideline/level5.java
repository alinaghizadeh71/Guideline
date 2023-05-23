package com.example.malihe.guideline;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class level5 extends AppCompatActivity {
    String id;
    String st;
    String title;
    ListView list;
    String[] termsArray;
    MaterialSearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2); Bundle b=getIntent().getExtras();
        //set Actionbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //NO PROB
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));



        if(b!=null)
        {
            id=b.getString("id");
            title=b.getString("cap");
        }

        //address
        TextView txt=(TextView)findViewById(R.id.txt);
        txt.setText(title);



        termsArray  = this.getResources().getStringArray(Integer.parseInt(id));


        //fill listview
        final int size = termsArray.length;
        // Toast.makeText(level2.this,String.valueOf(size),Toast.LENGTH_LONG).show();
        Spanned[] spannedStrings = new Spanned[size];
        for(int i=0; i<size; i++) {
            spannedStrings[i] = Html.fromHtml(termsArray[i]);
        }

        list=(ListView)findViewById(R.id.list1);
        // DataBind ListView with items from ArrayAdapter
        ListAdapter adapter1=new ListAdapter(level5.this, spannedStrings);
        list.setAdapter(adapter1);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b=getIntent().getExtras();
                if(b!=null)
                {
                    // key=b.getString("key");
                    st=b.getString("st")+"_"+String.valueOf(position+1);;
                }
               // Toast.makeText(level5.this, String.valueOf(st),Toast.LENGTH_LONG).show();

                CharSequence item = (CharSequence) parent.getItemAtPosition(position);
                //  Toast.makeText(level2.this,String.valueOf(position),Toast.LENGTH_LONG).show();
                //Toast.makeText(level2.this,item,Toast.LENGTH_LONG).show();

                // Toast.makeText(level2.this,item,Toast.LENGTH_LONG).show();
                int arryid = level5.this.getResources().getIdentifier(st, "array",
                        level5.this.getPackageName());



                if (arryid>0) {
                    // String[] termsArray  = level2.this.getResources().getStringArray(arryid);
                    Intent i = new Intent(level5.this, level5.class);
                    i.putExtra("id", String.valueOf(arryid));
                    i.putExtra("cap",title+" -> "+item);
                    i.putExtra("st",st);
                    startActivity(i);
                } else {
                    Toast.makeText(level5.this,"This list has not any sub item",Toast.LENGTH_LONG).show();
                }

               // String item = (String) parent.getItemAtPosition(position);
               // Toast.makeText(level4.this,"This list has not any sub item",Toast.LENGTH_LONG).show();
                //String st=String.valueOf(position+1);
              /*  Toast.makeText(level3.this,item,Toast.LENGTH_LONG).show();
                Intent i = new Intent(CT_item.this, level3.class);
                i.putExtra("key", String.valueOf(item));
                startActivity(i);*/
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
                ListAdapter adapter1=new ListAdapter(level5.this, spannedStrings);
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
                    /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(level3.this,R.layout.custom_textview,mylist);
                    list.setAdapter(adapter);*/
                    final int size = mylist.size();
                    // Toast.makeText(level2.this,String.valueOf(size),Toast.LENGTH_LONG).show();
                    Spanned[] spannedStrings = new Spanned[size];
                    for(int i=0; i<size; i++) {
                        spannedStrings[i] = Html.fromHtml(mylist.get(i));
                    }
                    ListAdapter adapter1=new ListAdapter(level5.this, spannedStrings);
                    list.setAdapter(adapter1);

                }
                else
                {
                    final int size = termsArray.length;
                    Spanned[] spannedStrings = new Spanned[size];
                    for(int i=0; i<size; i++){
                        spannedStrings[i] = Html.fromHtml(termsArray[i]);
                    }

                    ListAdapter adapter1=new ListAdapter(level5.this, spannedStrings);
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
                Intent i=new Intent(level5.this,MainActivity.class);
                startActivity(i);
                return true;
            case R.id.back:
                /*Intent ii=new Intent(level3.this,level2.class);
                startActivity(ii);*/
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
