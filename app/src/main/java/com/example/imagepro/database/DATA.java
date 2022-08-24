package com.example.imagepro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DATA extends SQLiteOpenHelper {
    private Context con;
    public  static final String DName="Translate.db";
    public  static final String Table ="History";
    public  static final String COL_ID ="ID";
    public  static final String Mean_column ="Meaning";
    public  static final String Word ="Word";
    public  static final int Dversion=1;

    public DATA( Context context) {
        super(context,DName,null,Dversion);
        this.con=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query ="CREATE TABLE "+Table+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Word+ " TEXT, " +Mean_column+" TEXT);";
        db.execSQL(Query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS "+Table);
        onCreate(db);


    }
    public void Translate(String word,String mean ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put(Word,word);
        cont.put(Mean_column,mean);
        long res=db.insert(Table,null,cont);
        if(res==-1){
            Toast.makeText(con,"Failed",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(con,"Translated ",Toast.LENGTH_LONG).show();
        }

    }
    public Cursor retrieve(){
        String Query = " SELECT * FROM "+Table;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur = null;
        if(db!= null){
            cur= db.rawQuery(Query,null);
        }

        return cur;

    }
    public void deleteHis(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ Table) ;
    }
}
