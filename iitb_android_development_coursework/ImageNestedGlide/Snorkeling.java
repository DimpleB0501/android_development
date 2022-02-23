package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Snorkeling extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snorkeling);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(Snorkeling.this).load("https://freetimemallorca.com/758-tm_large_default/snorkeling-2h.jpg").into(iv);
            String str = "Snorkeling (British and Commonwealth English spelling: snorkelling) is the practice of swimming on or through a body of water while equipped with a diving mask, a shaped breathing tube called a snorkel, and usually swimfins.";
            tv2.setText(str);
        }
    }
}