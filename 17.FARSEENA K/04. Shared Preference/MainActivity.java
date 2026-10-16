package com.example.sharedpeference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,mobilenum,email,pass1,pass2;
    Button submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        mobilenum=(EditText)findViewById(R.id.number);
        email=(EditText)findViewById(R.id.email);
        pass1=(EditText)findViewById(R.id.password);
        pass2=(EditText)findViewById(R.id.conpassword);
        submit=(Button)findViewById(R.id.loginbtn);

        sharedPreferences=getSharedPreferences("UserDetails",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String usernames=username.getText().toString().trim();
                int mobilei=Integer.parseInt((mobilenum.getText().toString().trim()));
                String emails=email.getText().toString().trim();
                String pass1s=pass1.getText().toString().trim();
                String pass2s=pass2.getText().toString().trim();
                if(usernames.isEmpty()){
                    username.setError("Username is Empty");
                    username.requestFocus();
                    return;
                }
                if(emails.isEmpty()){
                    email.setError("input Email");
                    email.requestFocus();
                    return;
                }
                if(pass1s.isEmpty()){
                    pass1.setError("Enter Password");
                    pass1.requestFocus();
                    return;
                }
                if(pass2s.isEmpty()){
                    pass2.setError("Enter Password");
                    pass2.requestFocus();
                    return;
                }
                if(pass1s.length()<6){
                    pass1.setError("Length must be minimum 6 chracters");
                    pass1.requestFocus();
                    return;
                }
                if(!pass1s.equals(pass2s)){
                    pass2.setError("Passwords not matching");
                    pass2.requestFocus();
                    return;
                }
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                editor.putString("keyusername",usernames);
                editor.putInt("keymobile",mobilei);
                editor.putString("keyemail",emails);
                editor.putString("keypassword",pass2s);
                editor.apply();
            }
        });

    }
}