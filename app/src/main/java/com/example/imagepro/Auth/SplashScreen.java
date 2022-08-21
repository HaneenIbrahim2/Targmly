package com.example.imagepro.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.imagepro.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences =getSharedPreferences(SignUpActivity.PREFS_NAME,MODE_PRIVATE);
                boolean hasSignedUp =sharedPreferences.getBoolean("hasSignedUp",false);
                if(hasSignedUp){
                    startActivity(new Intent(SplashScreen.this,HomeActivity.class));
                    finish();

                }
                else{
                    startActivity(new Intent(SplashScreen.this,SignUpActivity.class));
                    finish();
                }
            }
        },2000);


    }
}