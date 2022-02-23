package com.example.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Mango extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mango);
        tv = findViewById(R.id.tv);
        Bundle b = this.getIntent().getExtras();
        if (b!=null)
            tv.setText(b.getString("str_val", null));
    }
}