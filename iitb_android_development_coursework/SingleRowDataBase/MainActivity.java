package com.example.singlerowdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t = new Thread()
        {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                    Intent gtlp =  new Intent(MainActivity.this, Login.class);
                    startActivity(gtlp);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}