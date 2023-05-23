package com.example.malihe.guideline;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import static com.example.malihe.guideline.R.id.favorites;
import static com.example.malihe.guideline.R.id.listview;

public class favorites extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayAdapter adapter;
    ArrayList list1;
    ListView list;
    List<String> myList;
    mydatabasehandler db;
     String itemdel;
    Integer ii=0;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };

    //String[] filllist;
    MaterialSearchView searchView;
     ArrayList del = new ArrayList();
     List<String> list2 ;
    String[] filllist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Button btnDel = (Button) findViewById(R.id.btnDel);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Favorites List");
        //set Actionbar
       /* Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //NO PROB
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
*/


        list = (ListView) findViewById(listview);
        list.setOnItemClickListener(this);
        db = new mydatabasehandler(favorites.this);

         list2 = db.getfavoriteslist();

        /** Defining the ArrayAdapter to set items to ListView */
         adapter = new ArrayAdapter(this, R.layout.simple_list_item_multiple_choice,list2)
             {
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
             };


list.setAdapter(adapter);
        Button btndel=(Button)findViewById(R.id.btnDel);
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // SparseBooleanArray checkedItemPositions=list.getCheckedItemPositions();
                int itemCount=list.getCount();
                SparseBooleanArray checked = list.getCheckedItemPositions();

                for (int i = (checked.size() - 1); i >= 0; i--) {
                    if (checked.valueAt(i)) {
                        String selecteditem = String.valueOf(list.getItemAtPosition(checked.keyAt(i)));
                        // Remove selected items following the ids
                        adapter.remove(selecteditem);
                        db.deluser(selecteditem);
                    }
                }

                del.clear();
                checked.clear();
                adapter.notifyDataSetChanged();
                list.clearChoices();
                list.setAdapter(adapter);

            }
        });

                                //search in actionbar
                               /* searchView=(MaterialSearchView)findViewById(R.id.Search_view);
                                searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
                                    @Override
                                    public void onSearchViewShown() {

                                    }

                                    @Override
                                    public void onSearchViewClosed() {




                                        list = (ListView) findViewById(listview);
                                        list.setOnItemClickListener(favorites.this);
                                        db = new mydatabasehandler(favorites.this);

                                        list2 = db.getfavoriteslist();

                                        *//** Defining the ArrayAdapter to set items to ListView *//*
                                        adapter = new ArrayAdapter(favorites.this, R.layout.simple_list_item_multiple_choice,list2)
                                        {
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
                                        };


                                        list.setAdapter(adapter);
                                    }
                                });

                                searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
                                    @Override
                                    public boolean onQueryTextSubmit(String query) {
                                        return false;
                                    }

                                    @Override
                                    public boolean onQueryTextChange(String newText) {
                                        list = (ListView) findViewById(listview);
                                        list.setOnItemClickListener(favorites.this);
                                        db = new mydatabasehandler(favorites.this);



                                        list2 = db.getfavoriteslist();

                                        if(newText!=null && !newText.isEmpty())
                                        {
                                            List<String> mylist=new ArrayList<>();
                                            for (String item:list2)
                                            {
                                                if(item.contains(newText))
                                                    mylist.add(item);
                                            }
                                            adapter = new ArrayAdapter(favorites.this, R.layout.simple_list_item_multiple_choice,mylist)
                                            {
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
                                            };



                                            list.setAdapter(adapter);
                                            final int size = mylist.size();
                                            // Toast.makeText(level2.this,String.valueOf(size),Toast.LENGTH_LONG).show();
                                            Spanned[] spannedStrings = new Spanned[size];
                                            for(int i=0; i<size; i++) {
                                                spannedStrings[i] = Html.fromHtml(mylist.get(i));
                                            }
                                            adapter = new ArrayAdapter(favorites.this, R.layout.simple_list_item_multiple_choice,spannedStrings)
                                            {
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
                                            };


                                            list.setAdapter(adapter);
                                            //list.setAdapter(adapter1);

                                        }
                                        else
                                        {
                                            list = (ListView) findViewById(listview);
                                            list.setOnItemClickListener(favorites.this);
                                            db = new mydatabasehandler(favorites.this);


                                            list2 = db.getfavoriteslist();
                                            final int size = list2.size();
                                            Spanned[] spannedStrings = new Spanned[size];
                                            for(int i=0; i<size; i++){
                                                spannedStrings[i] = Html.fromHtml(list2.get(i));
                                            }

                                            adapter = new ArrayAdapter(favorites.this, R.layout.simple_list_item_multiple_choice,spannedStrings)
                                            {
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
                                            };
                                            list.setAdapter(adapter);
                                        }
                                        return false;
                                    }});*/



                                    }

                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        itemdel=String.valueOf(list.getItemAtPosition(position));
                                        //itemdel=position;
                                       // Toast.makeText(getBaseContext(), itemdel, Toast.LENGTH_SHORT).show();
                                        del.add(itemdel);
                                    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menufav,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Integer ii;
        switch (item.getItemId())
        {

            case R.id.selectAll:
            if(ii==0)
            {
                            int itemCount = list.getCount();
                            for (int i = 0; i < itemCount; i++) {

                                list.setItemChecked(i, true);
                            }
                            ii=1;
            }else if(ii==1)
            {
                int itemCount = list.getCount();
                for (int i = 0; i < itemCount; i++) {

                    list.setItemChecked(i, false);
                }
                ii=0;
            }
               //mode.setTitle(checkedCount  + "  Selected");

                return true;

            case R.id.Home:
                Intent i=new Intent(favorites.this,MainActivity.class);
                startActivity(i);
                return true;
            case android.R.id.home:

                // go to previous activity
                onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

}








