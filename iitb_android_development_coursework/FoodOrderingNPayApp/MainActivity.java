package com.example.foodorderingandpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    ListView food;
    Button bp;
    Integer[] iurl = {R.drawable.j1, R.drawable.j2, R.drawable.j3, R.drawable.j4, R.drawable.j5, R.drawable.j6, R.drawable.j7, R.drawable.j8, R.drawable.j9, R.drawable.j10};
    String[] hdata = {"Pizza", "Pasta", "Burger", "Sandwich", "Sushi", "Fries", "Garlic Bread", "Waffle", "Truffle Pastry", "Chocolate Dessert Jar"};
    String[] sdata = {"Rs 250", "Rs 200", "Rs 200", "Rs 100", "Rs 300", "Rs 100", "Rs 120", "Rs 150", "Rs 200", "Rs 180"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        food = findViewById(R.id.food);
        bp = findViewById(R.id.bp);
        //Create Adapter
        final MyAdapter ma = new MyAdapter(MainActivity.this, iurl, hdata, sdata);
        food.setAdapter(ma);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ma.return_val();
                Intent i = new Intent(MainActivity.this, PaymentPage.class);
                i.putExtra("val", (Serializable) ma.return_val());
                startActivity(i);
                //Toast.makeText(MainActivity.this, ""+ma.return_val(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}