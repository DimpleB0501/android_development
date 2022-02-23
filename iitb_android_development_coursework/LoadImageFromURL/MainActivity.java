package com.example.loadimagefromurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView lifu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lifu = findViewById(R.id.lifu);
        //Glide.with(MainActivity.this).load("https://c.ndtvimg.com/2020-01/l842qabo_ms-dhoni-afp_625x300_16_January_20.jpg?output-quality=60&output-format=webp&downsize=555:*S").into(lifu);
        Picasso.get().load("https://i0.wp.com/odishabytes.com/wp-content/uploads/2020/07/deepika-padukone.jpg?fit=1280%2C720&ssl=1").into(lifu);
    }
}

//allows to load 3rd party applications