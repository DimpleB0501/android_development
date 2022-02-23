package com.example.hw_numbertype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EvenOrOdd extends AppCompatActivity {
    TextView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_or_odd);
        cv = findViewById(R.id.cv);
        Bundle b = this.getIntent().getExtras();
        //int num = Integer.valueOf(b.getString("int_val",null));
        int num = b.getInt("int_val",0);
        if (num  % 2 == 0){
            cv.setText("Number "+ num + " is an Even Number");        }
        else{
            cv.setText("Number "+num + " is an Odd Number");

        }

            }
}