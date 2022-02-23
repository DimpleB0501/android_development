package com.example.singlerowdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView homes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homes = findViewById(R.id.homes);
        Bundle b =this.getIntent().getExtras();
        homes.setText("Welcome "+b.getString("uname", null));
    }
}