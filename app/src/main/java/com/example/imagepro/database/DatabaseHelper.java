package com.example.imagepro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context con;
    public static final String DATABASE_NAME = "signup.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase dp) {
        dp.execSQL("create table users(email TEXT primary key, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");



    }


    public Boolean insertData(String username, String email, String password  ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        long result = db.insert("users", null, values);
        return result != -1;
    }
    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?", new String[] {email});
        return cursor.getCount() > 0;
    }

    public Boolean checkEmailAndPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?", new String[] {email, password});
        return cursor.getCount() > 0;
    }



}
