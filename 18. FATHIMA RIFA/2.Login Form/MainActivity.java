package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username=(TextView)findViewById(R.id.Username);
        TextView Password=(TextView)findViewById(R.id.Password);
        Button  loginbtn=(Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.onClickListener(){
            public void onClick(View view){
                if(username.getText().toString().equals("admin")&&Password.getText().toString().equals("123456"))
                {
                    Toast.makeText(MainActivity.this,text("Login successfull:"),Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}