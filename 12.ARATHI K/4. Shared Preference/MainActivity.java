package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,mobilenum,email,pass1,pass2;
    Button  submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.username);
        mobilenum=(EditText) findViewById(R.id.number);
        email=(EditText) findViewById(R.id.email);
        pass1=(EditText) findViewById(R.id.password);
        pass2=(EditText) findViewById(R.id.conpassword);
        submit =(Button) findViewById(R.id.loginbtn);

        sharedPreferences=getSharedPreferences("user details",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String usernames=username.getText().toString().trim();
                int mobilei=Integer.parseInt(mobilenum.getText().toString().trim());
                String emails=email.getText().toString().trim();
                String pass1s=pass1.getText().toString().trim();
                String pass2s=pass2.getText().toString().trim();
                if(usernames.isEmpty())
                {
                    username.setError("username is empty");
                    username.requestFocus();
                    return;
                }
                if(emails.isEmpty())
                {
                    email.setError("input email");
                    email.requestFocus();
                    return;
                }
                if(pass1s.isEmpty())
                {
                    pass1.setError("enter password");
                    pass1.requestFocus();
                    return;
                }
                if(pass2s.isEmpty())
                {
                    pass2.setError("enter password");
                    pass2.requestFocus();
                    return;
                }
                if(pass1s.length()<6)
                {
                    pass1.setError("length must be minimum 6 characters");
                    pass1.requestFocus();
                    return;
                }
                if(!pass1s.equals(pass2s))
                {
                    pass2.setError("password not matched");
                    pass2.requestFocus();
                    return;
                }
                Toast.makeText(MainActivity.this,"registration successful",Toast.LENGTH_LONG).show();
                editor.putString("keyusername",usernames);
                editor.putInt("keymobile",mobilei);
                editor.putString("keyemail",emails);
                editor.putString("keypassword",pass2s);
                editor.apply();


            }
        });
    }
}