package com.example.malihe.guideline;

/**
 * Created by malihe on 11/4/2017.
 */

public class favclass {
    //private variables
    int _id;
    String _name;
    Integer _status;
    Integer _pos;
    // Empty constructor
    public favclass(){

    }
    // constructor
    public favclass(int id, String name){
        this._id = id;
        this._name = name;

    }
    public favclass(String name){

        this._name = name;

    }
    public favclass( String name,Integer _status){

        this._name = name;
        this._status = _status;
    }
    public favclass( Integer _pos,Integer _status){

        this._pos = _pos;
        this._status = _status;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    public int getstatus(){
        return this._status;
    }

    // setting id
    public void setstatus(Integer status){
        this._status = status;
    }
    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }
    public int getpos(){
        return this._pos;
    }

    // setting id
    public void setpos(Integer _pos){
        this._pos = _pos;
    }


}
