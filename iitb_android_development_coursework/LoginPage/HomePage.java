package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    TextView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        cv = findViewById(R.id.cv);
        Bundle b = this.getIntent().getExtras();
        if (b!=null)
            cv.setText("Welcome "+ b.getString("un", null));
        else
            cv.setText("You are not using proper keys");
    }
}