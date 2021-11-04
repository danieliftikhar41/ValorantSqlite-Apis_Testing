package com.example.logginvalorant.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.DB.ValorantContract.*;
import com.example.logginvalorant.Moduls.Weapon;

import java.util.ArrayList;

public class ValorantDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "valorant.db";
    private static final String SQL_CREATE_ENTRIES1 = "CREATE TABLE " + ValorantEntry.TABLE_Agent + "(" + ValorantEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ValorantEntry.COLUMN_NAME_TITLE + " TEXT)";
    private static final String SQL_CREATE_ENTRIES2 = "CREATE TABLE " + ValorantEntry.TABLE_Weapon + "(" + ValorantEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ValorantEntry.COLUMN_NAME_TITLE + " TEXT, "+ValorantEntry.COLUMN_WeaponType_TITLE + " TEXT ,"+ValorantEntry.COLUMN_Cost_TITLE + " TEXT)";
    private static final String SQL_CREATE_ENTRIES3 = "CREATE TABLE " + ValorantEntry.TABLE_Map + "(" + ValorantEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ValorantEntry.COLUMN_NAME_TITLE + " TEXT)";
    public ValorantDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES1);
        db.execSQL(SQL_CREATE_ENTRIES2);
        db.execSQL(SQL_CREATE_ENTRIES3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertWeapon(SQLiteDatabase db, Weapon c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ValorantEntry.COLUMN_NAME_TITLE, c.getName());
            values.put(ValorantEntry.COLUMN_WeaponType_TITLE, c.getType());
            values.put(ValorantEntry.COLUMN_Cost_TITLE, c.getCost());


            db.insert(ValorantEntry.TABLE_Weapon, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    } public void insertAgent(SQLiteDatabase db, Agent c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ValorantEntry.COLUMN_NAME_TITLE, c.getName());


            db.insert(ValorantEntry.TABLE_Agent, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }
    public void insertMap(SQLiteDatabase db, Map c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ValorantEntry.COLUMN_NAME_TITLE, c.getName());


            db.insert(ValorantEntry.TABLE_Map, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public void DeleteTable(SQLiteDatabase db,String TABLE_NAME) {
        //Check the bd is open
        if (db.isOpen()){

            db.execSQL("delete  from " + TABLE_NAME);
        }else{
            Log.i("sql","Database is closed");
        }

    }public void selectData_Weapon(SQLiteDatabase db, ArrayList<Weapon> arrayWeapon){
        Cursor c = db.rawQuery("SELECT id,Name,weapontype,cost FROM "+ValorantEntry.TABLE_Weapon,null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String column1 = c.getString(1);
                String column2 = c.getString(2);
                String column3 = c.getString(3);
               // String column4 = c.getString(3);
                arrayWeapon.add(new Weapon(column1,column2,column3));

                // Do something Here with values

            } while(c.moveToNext());
            c.close();
        }

    }
    public void selectData_Map(SQLiteDatabase db, ArrayList<Map> arrayMap){
        Cursor c = db.rawQuery("SELECT id,Name FROM "+ValorantEntry.TABLE_Map,null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                arrayMap.add(new Map(column2));

                // Do something Here with values

            } while(c.moveToNext());
            c.close();
        }

    }
    public void selectData_Agent(SQLiteDatabase db, ArrayList<Agent> arrayAgent){
        Cursor c = db.rawQuery("SELECT id,Name FROM "+ValorantEntry.TABLE_Agent,null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                arrayAgent.add(new Agent(column2));

                // Do something Here with values

            } while(c.moveToNext());
            c.close();
        }

    }



}


