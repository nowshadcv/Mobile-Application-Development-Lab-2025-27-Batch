package com.example.alc2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","OnCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","OnStart invoked");
    }
    protected void onResume(){
        super.onResume();
        Log.d("lifecycle","OnResume invoked");
    }
    protected void onPause(){
        super.onPause();
        Log.d("lifecycle","OnPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","OnStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","OnRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","OnDestroy invoked");
    }
}