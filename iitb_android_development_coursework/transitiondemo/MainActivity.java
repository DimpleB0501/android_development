package com.example.imageanimdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv, iv1,iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.iv1);
        iv = findViewById(R.id.iv);
        iv2 = findViewById(R.id.iv2);

        iv1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                //Animation demo = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out);
                //iv1.startAnimation(demo);

                //Animation demo = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myanim);
                //iv1.startAnimation(demo);

                TransitionDrawable transition = (TransitionDrawable) getApplicationContext().getResources().getDrawable(R.drawable.transition_drawable, null);

                iv1.setImageDrawable(null);
                iv.setImageDrawable(null);
                iv2.setImageDrawable(null);
                iv.setImageDrawable(transition);
                //iv.setBackgroundResource();
                transition.setCrossFadeEnabled(true);
                transition.startTransition(10000);

                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
    }
}