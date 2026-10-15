package com.example.program6;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        ImageView imageView = findViewById(R.id.img1);
        String index = getIntent().getStringExtra("ImageIndex");

        if (index == null) {
            Toast.makeText(this, "Index not received",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        switch (index) {
            case "1":
                imageView.setImageResource(R.drawable.apple);
                break;

            case "2":
                imageView.setImageResource(R.drawable.pineapple);
                break;

            case "3":
                imageView.setImageResource(R.drawable.orange);
                break;

            case "4":
                imageView.setImageResource(R.drawable.pomegranates);
                break;

            default:
                Toast.makeText(this, "Invalid index",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}