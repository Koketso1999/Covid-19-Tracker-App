package com.example.mk17000504;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegistrationDatabase extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "visitor.db";
    public static final String TABLE_NAME = "tbl_visitor";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "firstname";
    public static final String COL_3 = "lastname";
    public static final String COL_4 = "contact";
    public static final String COL_5 = "dateVisit";
    public static final String COL_6 = "temperature";



    public RegistrationDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertData(String firstname, String lastname, String dateVisit, String contact, String temperature){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, firstname);
        contentValues.put(COL_3, lastname);
        contentValues.put(COL_4, contact);
        contentValues.put(COL_5, dateVisit);
        contentValues.put(COL_6, temperature);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return  true;
        }
    }






}
