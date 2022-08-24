package com.example.imagepro.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imagepro.R;

import com.example.imagepro.database.DATA;
import com.example.imagepro.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText, emailEditText, passwordEditText;
    Button LoginButton;
    DatabaseHelper dp;
    TextView t1,t2;
    private  final  static String username="name";
    private  final  static String email="email";
    private  final  static String password="password";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText=(EditText)findViewById(R.id.user_Name);
        emailEditText = (EditText) findViewById(R.id.emailLogin);
        passwordEditText = (EditText) findViewById(R.id.passwordLogin);
        LoginButton = (Button) findViewById(R.id.LoginButton);
        dp = new DatabaseHelper(this);

        t1=findViewById(R.id.textView3);
        t2=findViewById(R.id.textView5);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sharedPreferences=getSharedPreferences(SignUpActivity.PREFS_NAME,MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(username,usernameEditText.getText().toString());
                editor.putString(email,emailEditText.getText().toString());
                editor.putString(password,passwordEditText.getText().toString());

                editor.apply();
                editor.putBoolean("hasSignedUp",true);
                editor.commit();

                if(TextUtils.isEmpty(username)){
                    emailEditText.setError("User name is required");
                    emailEditText.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    emailEditText.setError("Email is required");
                    emailEditText.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    passwordEditText.setError("Password is required");
                    passwordEditText.requestFocus();
                    return;
                }
                else {
                    boolean checkpassword =dp.checkEmailAndPassword(email,password);
                    if(checkpassword){

                        Toast.makeText(LoginActivity.this,"login sucsessfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent (getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this,"Password is not  correct",Toast.LENGTH_SHORT).show();

                    }
                }


            }

        });

    }
}