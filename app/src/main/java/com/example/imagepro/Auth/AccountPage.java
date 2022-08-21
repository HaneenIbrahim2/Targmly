package com.example.imagepro.Auth;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.imagepro.R;

public class AccountPage extends AppCompatActivity{
    TextView Name_text,Email_text;
    Button Logout_btn , Back_btn;
    private  final  static String username="name";
    private  final  static String email="email";
    private  final  static String password="password";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        sharedPreferences = getSharedPreferences(SignUpActivity.PREFS_NAME, MODE_PRIVATE);
        String name =sharedPreferences.getString(username,null);
        String Email =sharedPreferences.getString(email,null);
        Name_text=findViewById(R.id.textView3);
        Email_text=findViewById(R.id.textView5);

        if (name!=null||Email!=null){
            Name_text.setText(name);
            Email_text.setText(Email);

        }


        Logout_btn=findViewById(R.id.button2);
        Logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
                Intent intent= new Intent(AccountPage.this , LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Toast.makeText(AccountPage.this,"You have been logged out",Toast.LENGTH_LONG).show();
            }
        });
        Back_btn=(Button) findViewById(R.id.Back_btn);
        Back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountPage.this , SettingActivity.class));
            }
        });



    }
    private  void logout( ) {
        sharedPreferences = getSharedPreferences(SignUpActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}