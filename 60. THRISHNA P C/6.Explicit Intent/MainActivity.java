package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnIndexSendButtonClicked(View view) {

        EditText editText = findViewById(R.id.text);
        String index = editText.getText().toString().trim();

        if (index.isEmpty()) {
            Toast.makeText(this, "Enter index 1 to 4",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(
                MainActivity.this,
                MainActivity2.class
        );

        intent.putExtra("ImageIndex", index);
        startActivity(intent);
    }
}