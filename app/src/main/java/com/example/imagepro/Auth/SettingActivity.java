package com.example.imagepro.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.imagepro.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button Back;
        Button Account ;
        Button General_Language;

        Back=(Button) findViewById(R.id.Back_Button);
        Account = (Button) findViewById(R.id.account);
        General_Language=(Button) findViewById(R.id.language_btn);
//        Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(SettingActivity.this , AccountPage.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this , HomeActivity.class));
            }
        });


    }
}