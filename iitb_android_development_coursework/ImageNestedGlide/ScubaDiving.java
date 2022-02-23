package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ScubaDiving extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scuba_diving);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(ScubaDiving.this).load("https://plett.prodive.co.za/wp-content/uploads/2018/08/diving-_0000_travel.jpg").into(iv);
            String str = "One of the best parts of scuba diving is the feeling of weightlessness. ... Divers can move easily in three dimensions. The trick is to relax into the weightless feeling of the water and let the water and your buoyancy compensator support you.";
            tv2.setText(str);
        }
    }
}