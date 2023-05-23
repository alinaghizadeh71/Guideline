package com.example.malihe.guideline;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import android.preference.PreferenceManager;
import static android.content.Context.MODE_PRIVATE;


/**
 * Created by malihe on 3/7/2018.
 */

public class ListAdapter extends ArrayAdapter<CharSequence> {
    private final Activity context;
    private final CharSequence[] itemname;
    mydatabasehandler db;
   // SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
   SharedPreferences shared =getContext().getSharedPreferences("Prefs", MODE_PRIVATE);
    Integer key=0;
    public ListAdapter(Activity context, CharSequence[] itemname) {
        super(context, R.layout.custom_textview, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;

    }

    public View getView(final int position, final View view, ViewGroup parent) {
       // Toast.makeText(getContext(),String.valueOf(itemname.length),Toast.LENGTH_LONG).show();
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_textview, null, true);
        if(position %2 == 1)
        {
            // Set a background color for ListView regular row/itemADD8E6
            rowView.setBackgroundColor(Color.parseColor("#ADD8E6"));
        }
        else
        {
            // Set the background color for alternate row/itemF5FFFA
            rowView.setBackgroundColor(Color.parseColor("#F5FFFA"));
        }
        final TextView txtTitle = (TextView) rowView.findViewById(R.id.tv);
        txtTitle.setText(itemname[position]);

        final ToggleButton toggleButton = (ToggleButton) rowView.findViewById(R.id.fav);
        //for work click item listview

        toggleButton.setFocusable(false);
        toggleButton.setFocusableInTouchMode(false);


        favclass item=new favclass();
        db=new mydatabasehandler(getContext());
        item.setName(String.valueOf(itemname[position]));

        String st=db.getstatususer(item);

        if(st.equals("1"))
        {
            //Toast.makeText(getContext(),String.valueOf(1),Toast.LENGTH_LONG).show();
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.favorite));
        }else
        {
           // Toast.makeText(getContext(),String.valueOf(0),Toast.LENGTH_LONG).show();
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.favoritee));
        }
 /*boolean boolean_from_sp = shared.getBoolean("tgpref", false);
        if (boolean_from_sp == false) //if (tgpref) may be enough, not sure
        {
            toggleButton.setChecked(false);
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.favoritee));

            }
        else
        {
            toggleButton.setChecked(true);
            toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.favorite));
        }*/

        toggleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                if((toggleButton.isChecked()))
                {

                   // Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.favorite));

                   /* SharedPreferences.Editor editor = shared.edit();
                    editor.putBoolean("tgpref", true);
                    editor.apply();*/

                    favclass item=new favclass();
                    db=new mydatabasehandler(getContext());
                    item.setName(String.valueOf(txtTitle.getText()));
                    item.setstatus(1);
                    item.setpos(position);

                    String check=db.checkuser(item);
                    if(check.equals("false"))
                    {
                        //not found user
                        db.additem(item);
                    }
                    else
                    {
                        ///found user with status 0 and change status 1

                        db.updateuser(item);
                    }
                }
                else
                {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.favoritee));

                   /* SharedPreferences.Editor editor = shared.edit();
                    editor.putBoolean("tgpref", false);
                    editor.apply();*/
                    favclass item=new favclass();
                    db=new mydatabasehandler(getContext());
                    item.setName(String.valueOf(txtTitle.getText()));
                    item.setstatus(0);
                    //item.setpos(position);
                    db.updateuser(item);
                }
            }
        });
       /*                                               imageView.setOnClickListener(new View.OnClickListener() {

                                                                        @Override
                                                                        public void onClick(View v) {
                                                                            //Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                                                                            //Toast.makeText(getContext(),String.valueOf(txtTitle.getText()),Toast.LENGTH_LONG).show();
                                                                            if (key==0)
                                                                            {
                                                                                key=1;
                                                                                favclass item=new favclass();
                                                                                imageView.setImageResource(R.drawable.favorite);
                                                                                // favclass item=new favclass();
                                                                                db=new mydatabasehandler(getContext());
                                                                                item.setName(String.valueOf(txtTitle.getText()));
                                                                                item.setstatus(1);
                                                                                db.additem(item);
                                                                               // Toast.makeText(getContext(),String.valueOf("0 to 1"),Toast.LENGTH_LONG).show();
                                                                                return;
                                                                            }

                                                                            if (key==1)
                                                                            {
                                                                                key=0;
                                                                                favclass item=new favclass();
                                                                                imageView.setImageResource(R.drawable.favoritee);
                                                                                // favclass item=new favclass();
                                                                                db=new mydatabasehandler(getContext());
                                                                                item.setName(String.valueOf(txtTitle.getText()));
                                                                                item.setstatus(0);
                                                                                db.deluser(item);
                                                                                //Toast.makeText(getContext(),String.valueOf("1 to 0"),Toast.LENGTH_LONG).show();
                                                                                return;
                                                                            }

                                                                           // db.close();
                                                                        }} );*/

       /* rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"byyyyyy",Toast.LENGTH_LONG).show();
                //Click on listView row
            }
        });*/
        return rowView;

    }




}

