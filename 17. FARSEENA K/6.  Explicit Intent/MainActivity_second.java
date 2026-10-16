package com.example.explicitintent;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_main_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String imgIndex = bundle.getString("ImageIndex");
            setImage(imgIndex);
        }
    }

    private void setImage(String index) {
        ImageView imageView = findViewById(R.id.img1);

        switch (index) {
            case "1":
                imageView.setImageResource(R.drawable.apple2);
                break;

            case "2":
                imageView.setImageResource(R.drawable.pineapple);
                break;

            case "3":
                imageView.setImageResource(R.drawable.orange);
                break;

            case "4":
                imageView.setImageResource(R.drawable.pomogranate);
                break;
        }
    }
}