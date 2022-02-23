package com.example.foodorderingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.R;

public class Burger extends AppCompatActivity {
    TextView tv1, tv2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);
        tv1 = findViewById(R.id.tv1);
        tv2 =findViewById(R.id.tv2);
        b = findViewById(R.id.b);
        Bundle bl = this.getIntent().getExtras();
        if (bl != null)
            tv1.setText("Burger");
        tv2.setText(bl.getString("price", null));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Burger.this);
                adb.setIcon(android.R.drawable.ic_menu_call);
                adb.setTitle("Placing Order");
                adb.setMessage("Do you want to order this");
                adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Burger.this, "You have sucessfully placed the order", Toast.LENGTH_LONG).show();
                    }
                });
                adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Burger.this, "Please select from other items.", Toast.LENGTH_LONG).show();
                    }
                });
                adb.setCancelable(false);
                adb.show();
            }
        });

    }
}