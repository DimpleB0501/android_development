package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Skydiving extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skydiving);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(Skydiving.this).load("https://cdn-imgix.headout.com/tour/16289/TOUR-IMAGE/135f963c-16d5-4ce0-bf42-360fc2783e34-9036-dubai-SkyDiveDubai-Tandem-02.jpg?auto=compress&fm=pjpg&w=500&h=500&crop=faces&fit=min&q=10").into(iv);
            String str = "Skydiving, also called parachuting, is a sport in which athletes jump out of an airplane at a certain altitude and perform acrobatic movements in free fall.";
            tv2.setText(str);
        }
    }
}