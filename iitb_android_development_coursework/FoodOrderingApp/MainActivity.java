package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView food;
    Integer[] iurl = {R.drawable.j1, R.drawable.j2, R.drawable.j3, R.drawable.j4, R.drawable.j5};
    String[] hdata = {"Pizza", "Pasta", "Burger", "Sandwich", "Sushi"};
    String[] sdata = {"Rs 250", "Rs 200", "Rs 200", "Rs 100", "Rs 300"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        food = findViewById(R.id.food);
        //Create Adapter
        MyAdapter ma = new MyAdapter(MainActivity.this, iurl, hdata, sdata);
        food.setAdapter(ma);
    }
}