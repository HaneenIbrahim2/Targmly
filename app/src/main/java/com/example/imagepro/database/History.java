package com.example.imagepro.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.imagepro.Auth.SettingActivity;
import com.example.imagepro.R;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    RecyclerView reco;

    ArrayList<String>  word=new ArrayList<>();
    ArrayList<String>  mean=new ArrayList<>();
    DATA  database = new DATA(this);
    Adpt adapter;

    void Display (){
        Cursor cursor= database.retrieve();
        if(cursor.getCount()==0){
            Toast.makeText(this , "No  History",Toast.LENGTH_LONG).show();

        }
        else{
            while(cursor.moveToNext()){

                word.add(cursor.getString(4));
                mean.add(cursor.getString(5));

            }

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.deleteHistory){
            database.deleteHis();
            Toast.makeText(this,"All deleted",Toast.LENGTH_LONG).show();
            recreate();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        reco=findViewById(R.id.reco);
        adapter= new Adpt(this,word,mean);
        reco.setAdapter(adapter);
        reco.setLayoutManager(new LinearLayoutManager(this));
        Display();

    }


}