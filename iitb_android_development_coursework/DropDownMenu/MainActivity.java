package com.example.dropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner food;
    Button gvfs;
    TextView op;
    String[] item = {"Panner", "Veg","Soup", "Rice", "Manchurian"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        food = findViewById(R.id.food);
        gvfs = findViewById(R.id.gvfs);
        op = findViewById(R.id.op);

        ArrayAdapter ad = new ArrayAdapter(MainActivity.this, android.R.layout.simple_dropdown_item_1line,item);
        food.setAdapter(ad);
        gvfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setText("You have selected: "+food.getSelectedItem().toString());

            }
        });
    }
}