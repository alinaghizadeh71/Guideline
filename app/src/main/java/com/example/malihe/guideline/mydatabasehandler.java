package com.example.malihe.guideline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malihe on 11/7/2017.
 */

public class mydatabasehandler extends SQLiteOpenHelper {
    public static final String namedatabase="favoritesManager.db";
    public static final String table="favorites";
    public static final  String key="key";
    public static final String name="name";
    public static final String status="status";
    public static final String pos="pos";
    public static final Integer version=1;

    public mydatabasehandler(Context context) {
        super(context, namedatabase, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlst="create table "+table +"("+ key+" Integer primary key autoincrement not null, "+name+" text," + status+" Integer, " + pos+" Integer)";
        db.execSQL(sqlst);
        //String sqlst="create table "+table +"("+ key+" Integer primary key autoincrement not null, "+name+" text)";
      //  "CREATE TABLE "+table+"("+name+" TEXT,"+family+" TEXT)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF exists"+table);
        onCreate(db);
    }
    public void additem(favclass fav)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cont=new ContentValues();
        cont.put("name",fav.getName());
        cont.put("status",fav.getstatus());
        cont.put("pos",fav.getpos());
        db.insert(table,null,cont);

    }
    public void deluser(String st)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(table ,name +"=?",new String[]{String.valueOf(st)});
        db.close();
    }
    public void delmultiuser(ArrayList fav)
    { SQLiteDatabase db=this.getWritableDatabase();
        int itemCount=fav.size();
        for(int i=itemCount-1; i >= 0; i--){
            db.delete(table ,name +"=?",new String[]{String.valueOf(fav.get(i))});
        }

      //  db.delete(table ,name +"=?",new String[]{String.valueOf(fav.getName())});
        db.close();


        /*String selectAllQuery = "DELETE FROM"+ table +"WHERE EXISTS( SELECT * FROM positions WHERE positions.position_id = employees.position_id )";

        SQLiteDatabase sql = this.getReadableDatabase();
        // Cursor c = sql.rawQuery(selectAllQuery, null);
        Cursor c = sql.query(table, new String[]{name, status}, status + "=?",
                new String[]{String.valueOf(1)}, null, null, null, null);

        if (c != null && c.getCount() > 0) {

            try {
                while (c.moveToNext()) {

                }
            } finally {
                c.close();
            }

        }*/
    }
public Integer updateuser(favclass fav)
{
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues cont=new ContentValues();
    cont.put("name",fav.getName());
    cont.put("status",fav.getstatus());
    return db.update(table,cont,name +"=? ",new String[]{String.valueOf(fav.getName())});
}
public String checkuser(favclass fav)
{
    SQLiteDatabase db=this.getReadableDatabase();

    Cursor c=db.query(table,new String[]{name,status},name +"=?",
           new String[]{String.valueOf(fav.getName())},null,null,null,null);

    if(c!=null && c.getCount()>0) {
        c.moveToNext();
        return "true";



        /* u = new user(Integer.parseInt(c.getString(0)), String.valueOf(c.getString(1)));*/
    }


        return "false";


}
    public String getstatususer(favclass fav)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.query(table,new String[]{name,status},name +"=?",
                new String[]{String.valueOf(fav.getName())},null,null,null,null);

        if(c!=null && c.getCount()>0) {
            c.moveToNext();


            if(c.getString(1).equals("1"))
            {

                return "1";
            }
            else  if(c.getString(1).equals("0")){
                return "0";


            }

        /* u = new user(Integer.parseInt(c.getString(0)), String.valueOf(c.getString(1)));*/
        }


        return "0";


    }

     public List<String>  getfavoriteslist() {
         final List<String> list = new ArrayList<String>();
         String selectAllQuery = " SELECT * FROM " + table;
         SQLiteDatabase sql = this.getReadableDatabase();
         // Cursor c = sql.rawQuery(selectAllQuery, null);
         Cursor c = sql.query(table, new String[]{name, status}, status + "=?",
                 new String[]{String.valueOf(1)}, null, null, null, null);

         if (c != null && c.getCount() > 0) {

             try {
                 while (c.moveToNext()) {
                     list.add(c.getString(c.getColumnIndex("name")));
                 }
             } finally {
                 c.close();
             }

         }
         return list;
     }


}

