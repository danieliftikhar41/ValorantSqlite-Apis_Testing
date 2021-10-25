package com.example.logginvalorant.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.DB.ValorantContract.*;
import com.example.logginvalorant.Moduls.Weapon;

import java.util.ArrayList;

public class ValorantDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "valorant.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + WeaponEntry.TABLE_NAME + "(" + WeaponEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WeaponEntry.COLUMN_NAME_TITLE + " TEXT,"+ WeaponEntry.COLUMN_Des_TITLE + " TEXT)";
    public ValorantDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertContact(SQLiteDatabase db, Weapon c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(WeaponEntry.COLUMN_NAME_TITLE, c.getNom());
            values.put(WeaponEntry.COLUMN_Des_TITLE, c.getDtl());

            db.insert(WeaponEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }
    public void deleteContact(SQLiteDatabase db, int i) {
        //Check the bd is open
        if (db.isOpen()){

            db.delete(WeaponEntry.TABLE_NAME, "id=?", new String[]{Integer.toString(i)});
        }else{
            Log.i("sql","Database is closed");
        }

    }
    public void selectData(SQLiteDatabase db, ArrayList<Weapon> arrayWeapon){
        Cursor c = db.rawQuery("SELECT id,name,Text FROM  "+WeaponEntry.TABLE_NAME,null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
                arrayWeapon.add(new Weapon(column2,column3));

                // Do something Here with values

            } while(c.moveToNext());
            c.close();
        }

    }
    public void DeleteTable(SQLiteDatabase db) {
        //Check the bd is open
        if (db.isOpen()){

            db.execSQL("delete  from " + WeaponEntry.TABLE_NAME);
        }else{
            Log.i("sql","Database is closed");
        }

    }


}