package com.example.malihe.guideline;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by malihe on 3/12/2018.
 */

public class  MyListViewAdapter extends ArrayAdapter<String> {
    private final Activity context;

    Context myContext;

    LayoutInflater inflater;

    List<String> DataList;

    private  SparseBooleanArray mSelectedItemsIds;



    // Constructor for get Context and  list

    public  MyListViewAdapter(Activity context,  List<String> lists) {


        super(context, R.layout.listview_itemfav, lists);
        this.context = context;
        // TODO Auto-generated constructor stub
        mSelectedItemsIds = new  SparseBooleanArray();

        myContext = context;

        DataList = lists;


    }
    public View getView(final int position, final View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_itemfav, null, true);
        if (position % 2 == 1) {
            // Set a background color for ListView regular row/itemADD8E6
            rowView.setBackgroundColor(Color.parseColor("#ADD8E6"));
        } else {
            // Set the background color for alternate row/itemF5FFFA
            rowView.setBackgroundColor(Color.parseColor("#F5FFFA"));
        }
        return view;
    }





    @Override

    public void remove(String  object) {

        DataList.remove(object);

        notifyDataSetChanged();

    }



    // get List after update or delete

    public  List<String> getMyList() {

        return DataList;

    }



    public void  toggleSelection(int position) {

        selectView(position, !mSelectedItemsIds.get(position));

    }



    // Remove selection after unchecked

    public void  removeSelection() {

        mSelectedItemsIds = new  SparseBooleanArray();

        notifyDataSetChanged();

    }



    // Item checked on selection

    public void selectView(int position, boolean value) {

        if (value)

            mSelectedItemsIds.put(position,  value);

        else

            mSelectedItemsIds.delete(position);

        notifyDataSetChanged();

    }



    // Get number of selected item

    public int  getSelectedCount() {

        return mSelectedItemsIds.size();

    }



    public SparseBooleanArray getSelectedIds() {

        return mSelectedItemsIds;

    }

}
