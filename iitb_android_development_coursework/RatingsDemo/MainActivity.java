package com.example.feedbackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    LinearLayout fblay;
    ImageView iv;
    RatingBar fb;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fblay = findViewById(R.id.fblay);
        iv = findViewById(R.id.iv);
        fb = findViewById(R.id.fb);
        res = findViewById(R.id.res);

        fb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                switch ((int)rating)
                {
                    case 1:
                        iv.setImageResource(R.drawable.i1);
                        res.setText("You are poor");
                        Toast.makeText(MainActivity.this, ""+rating, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.i2);
                        res.setText("You are good");
                        Toast.makeText(MainActivity.this, ""+rating, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.i3);
                        res.setText("You are very good");
                        Toast.makeText(MainActivity.this, ""+rating, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        iv.setImageResource(R.drawable.i4);
                        res.setText("You are excellent");
                        Toast.makeText(MainActivity.this, ""+rating, Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        iv.setImageResource(R.drawable.i5);
                        Toast.makeText(MainActivity.this, ""+rating, Toast.LENGTH_SHORT).show();
                        res.setText("You are fabulous");
                        break;
                }
            }
        });
    }
}