package com.example.imagepro.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.imagepro.R;
import com.example.imagepro.database.History;

import java.util.Locale;

public class SettingActivity extends AppCompatActivity {
    public  static final String[] languages={"General Language","English","Arabic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button Back;
        Button Account;
        Button History_btn;

        final SharedPreferences setting = getSharedPreferences("setting", MODE_PRIVATE);
        final SharedPreferences.Editor editor = setting.edit();
        boolean darkmodeon = setting.getBoolean("NightMode", false);


        Spinner spinner;
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String se = adapterView.getItemAtPosition(i).toString();
                if (se.equals("English")) {

                    setLocale("en");
                    startActivity(getIntent());

                } else if (se.equals("Arabic")) {
                    setLocale("ar");
                    startActivity(getIntent());


                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        History_btn = findViewById(R.id.History_btn);
        History_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, History.class);
                startActivity(intent);
            }
        });

        Back = (Button) findViewById(R.id.Back_Button);
        Account = (Button) findViewById(R.id.account);

        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, AccountPage.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, HomeActivity.class));
            }
        });

        if(darkmodeon)

        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else

        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
//        Button btn = findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (darkmodeon) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    editor.putBoolean("NightMode", false);
//                    editor.apply();
//
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    editor.putBoolean("NightMode", true);
//                    editor.apply();
//
//                }
//            }
//
//        });


    }
    public void  setLocale(String lang) {
        Locale locale=new Locale(lang);
        Resources res=getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, HomeActivity.class);
        startActivity(refresh);
        finish();

    }
}