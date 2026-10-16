package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String index = getIntent().getStringExtra("ImageIndex");

        if (index != null) {
            setImage(index);
        } else {
            Toast.makeText(
                    this,
                    "No image index received",
                    Toast.LENGTH_SHORT
            ).show();
            finish();
        }
    }

    private void setImage(String index) {

        ImageView imageView = findViewById(R.id.img1);

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
                imageView.setImageResource(R.drawable.pomegranate);
                break;

            default:
                Toast.makeText(
                        this,
                        "Invalid image index. Enter 1 to 4.",
                        Toast.LENGTH_SHORT
                ).show();
                finish();
                break;
        }
    }
}