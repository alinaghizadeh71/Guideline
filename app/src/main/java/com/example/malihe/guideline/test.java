package com.example.malihe.guideline;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//implements AdapterView.OnItemClickListener
public class test extends Activity implements AdapterView.OnItemClickListener {
    ListView list1;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

      /*  CharSequence[] st = new CharSequence[]{"hello","ahmad","malihe","ahmadmalihe"};

        final ArrayList<CharSequence> list = new ArrayList<CharSequence>();
        for (int i = 0; i < st.length; ++i) {
            list.add(st[i]);
        }*/
        list1=(ListView)findViewById(R.id.listview);
        ListAdapter adapter=new ListAdapter(this, itemname);
       // list=(ListView)findViewById(R.id.list);
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(this);
     /*   list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(test.this,"by",Toast.LENGTH_LONG).show();
            }
        });*/

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.custom_textview,R.id.tv,list);
        //list1.setAdapter(adapter);

     //   ListAdapter adapter1;
       // adapter1 = new ListAdapter(test.this,list);
        //list1.setAdapter(adapter1);
        /*{
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
                }*/

                ///////////////////holder
              /*  ListAdapter.ViewHolder viewHolder;
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(this.getContext());
                    convertView = inflater.inflate(R.layout.custom_textview, null);
                    viewHolder = new ListAdapter.ViewHolder();
                    viewHolder.text = (TextView) convertView
                            .findViewById(R.id.tv);
                    viewHolder.button = (ImageButton) convertView
                            .findViewById(R.id.fav);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ListAdapter.ViewHolder) convertView.getTag();
                }
                final CharSequence temp = getItem(position);
                viewHolder.text.setText(temp);
                viewHolder.button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                    }
                });
///////
*/




             /*   return view;
            }*/

       // };
       // ListAdapter adapter;
       //  adapter = new ListAdapter([]st,getApplicationContext());
        // DataBind ListView with items from ArrayAdapter
      // list1.setOnItemClickListener(test.this);

      //  list1.setOnItemClickListener(onItemClickListener);



    }

 /*   @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //  String item = adapter.getItemAtPosition(position).toString();
        Toast.makeText(test.this, "CLICK: " , Toast.LENGTH_SHORT).show();

    }*/
   /* private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {



        @Override

        public void onItemClick(AdapterView<?> arg0, View arg1, int position,

                                long arg3) {

            Toast.makeText(test.this, "vaaaaaaaaaaaaay: " , Toast.LENGTH_SHORT).show();
        }

    };*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
       /* Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);*/
        Toast toast = Toast.makeText(getApplicationContext(),
               "fff",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
