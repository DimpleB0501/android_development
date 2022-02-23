package com.example.imagesnestedurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Skiing extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skiing);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iv = findViewById(R.id.iv);
        Bundle b = this.getIntent().getExtras();

        if (b != null) {
            tv1.setText(b.getString("str_val", null));
            Glide.with(Skiing.this).load("https://res-4.cloudinary.com/jnto/image/upload/w_750,h_750,c_fill,f_auto,fl_lossy,q_auto/v1/media/filer_public/76/07/7607a19e-94d7-4330-bf5d-356920534336/l_155641-50_tnkjxl").into(iv);

            String str = "Skiing is a means of transport using skis to glide on snow. Variations of purpose include basic transport, a recreational activity, or a competitive winter sport. Many types of competitive skiing events are recognized by the International Olympic Committee (IOC), and the International Ski Federation (FIS).";
            tv2.setText(str);
        }
    }
}