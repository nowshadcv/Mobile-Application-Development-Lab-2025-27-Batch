package com.example.intent1;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_main_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String imgindex=bundle.getString("imageIndex") ;
            setImage(imgindex);

        }
    }
    private void setImage(String index){
        ImageView imageView=(ImageView)findViewById(R.id.img1);
        switch (index){
            case "1":
                imageView.setImageResource(R.drawable.apple);
                break;
            case "2":
                imageView.setImageResource(R.drawable.banana);
                break;
            case "3":
                imageView.setImageResource(R.drawable.pineapple);
                break;
            case "4":
                imageView.setImageResource(R.drawable.orange);
                break;
        }
    }
}
