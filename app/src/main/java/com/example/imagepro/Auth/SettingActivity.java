package com.example.imagepro.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.imagepro.R;
import com.example.imagepro.database.History;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button Back;
        Button Account;
        Button History_btn;
        Button General_Language;
        History_btn = findViewById(R.id.History_btn);
        History_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, History.class);
                startActivity(intent);
            }
        });

        Back=(Button) findViewById(R.id.Back_Button);
        Account = (Button) findViewById(R.id.account);

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