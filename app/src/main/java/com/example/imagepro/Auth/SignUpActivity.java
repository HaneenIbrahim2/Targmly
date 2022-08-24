package com.example.imagepro.Auth;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imagepro.R;
import com.example.imagepro.database.DATA;
import com.example.imagepro.database.DatabaseHelper;

public class SignUpActivity extends AppCompatActivity {
public static String PREFS_NAME="MyPrefsFile";

    EditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    Button signUpButton;
    Button Login_activity;
    DatabaseHelper dp;
     EditText editText;
     EditText Transelation;
     int i=0;
    SharedPreferences sp;
    private  final  static String username="name";
    private  final  static String email="email";
    private  final  static String password="password";
    private  final  static String confirmPassword="confirmPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usernameEditText = (EditText) findViewById(R.id.usernameSignUp);
        emailEditText = (EditText) findViewById(R.id.emailSignUp);
        passwordEditText = (EditText) findViewById(R.id.passwordSignUp);
        confirmPasswordEditText = (EditText) findViewById(R.id.confirmPassword);
        editText = findViewById(R.id.speechText);
        Transelation = findViewById(R.id.Transelation);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        Login_activity =(Button) findViewById(R.id.LogIn_btn);

        dp = new DatabaseHelper(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(SignUpActivity.PREFS_NAME,0);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(username, usernameEditText.getText().toString());
                editor.putString(email, emailEditText.getText().toString());
                editor.putString(password, passwordEditText.getText().toString());
                editor.putString(confirmPassword, confirmPasswordEditText.getText().toString());

                editor.apply();
                String name =sharedPreferences.getString(username,null);
//                String Email =sharedPreferences.getString(email,null);
//                String Pass =sharedPreferences.getString(password,null);


                editor.putBoolean("hasSignedUp",true);
                editor.commit();

                if (name!=null){
                    Intent intent =new Intent(SignUpActivity.this,AccountPage.class);
                    startActivity(intent);
                }


                if (TextUtils.isEmpty(usernameEditText.getText().toString())) {
                    usernameEditText.setError("Username is required");
                    usernameEditText.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(emailEditText.getText().toString())){
                    emailEditText.setError("Email is required");
                    emailEditText.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(passwordEditText.getText().toString())) {
                    passwordEditText.setError("Password is required");
                    passwordEditText.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(confirmPasswordEditText.getText().toString())) {
                    confirmPasswordEditText.setError("Confirm Password is required");
                    confirmPasswordEditText.requestFocus();
                    return;
                }
                if(valueOf(passwordEditText.getText().toString()).equals(valueOf(confirmPasswordEditText.getText().toString()))) {
                    Boolean checkUser = dp.checkEmail(email);
                    if(!checkUser) {
                        Boolean insertUser = dp.insertData(username,email, password);
                        i++;
                        if(insertUser) {
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "User Already Exist", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    confirmPasswordEditText.setError("Password Not Match!");
                    confirmPasswordEditText.requestFocus();
                    return;
                }



            }
        });

        Login_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this , LoginActivity.class));
                finish();
            }
        });

    }
}