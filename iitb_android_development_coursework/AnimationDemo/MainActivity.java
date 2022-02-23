//custom animation (predefined)
package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on click some animation must happen
                //Animation demo = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_out_right); //custom animation
                Animation demo = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myanim); // self created animation
                iv.startAnimation(demo);
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

// To create your own animation
//own animation res -> New -> Android resource directory -> anim
//right click -> anim -> New -> Animation Resource File -> myanim