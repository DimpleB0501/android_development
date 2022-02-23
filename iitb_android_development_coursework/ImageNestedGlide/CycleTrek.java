package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CycleTrek extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_trek);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(CycleTrek.this).load("https://bijoor.me/images/cycling-trekking-peth-fort-8.jpg").into(iv);
            String str  = "Bicycle touring is the taking of self-contained cycling trips for pleasure, adventure or autonomy rather than sport, commuting or exercise. Touring can range from single-to multi-day trips, to years. Tours may be planned by the participant or organised by a holiday business, a club, or a charity as a fund-raising venture.";
            tv2.setText(str);
        }
    }
}