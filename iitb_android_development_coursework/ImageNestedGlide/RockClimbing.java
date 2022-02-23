package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class RockClimbing extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_climbing);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(RockClimbing.this).load("https://www.liveabout.com/thmb/MqReKZLWE8YiJHtB-hBqGpNPM3Q=/680x680/smart/filters:no_upscale()/ElevenmileCanyon_018_3-56a16a473df78cf7726a8850.jpg").into(iv);

            String str = "Rock climbing is a sport in which participants climb up, down or across natural rock formations or artificial rock walls. The goal is to reach the summit of a formation or the endpoint of a usually pre-defined route without falling.";
            tv2.setText(str);
        }
    }
}