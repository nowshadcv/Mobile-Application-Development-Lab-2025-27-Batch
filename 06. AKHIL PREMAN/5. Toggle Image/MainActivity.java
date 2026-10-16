package com.example.toggleimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView i1, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1 = findViewById(R.id.img1);
        i2 = findViewById(R.id.img2);

        i1.setOnClickListener(this::onClick);
        i2.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.img1) {
            // Banana → Orange
            i1.setVisibility(View.GONE);
            i2.setVisibility(View.VISIBLE);
        }
        else if (v.getId() == R.id.img2) {
            // Orange → Banana
            i2.setVisibility(View.GONE);
            i1.setVisibility(View.VISIBLE);
        }
    }
}