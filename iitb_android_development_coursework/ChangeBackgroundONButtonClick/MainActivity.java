package com.example.setbgdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//global area
    LinearLayout mylayout;
    Button f1, f2, f3, f4;
    TextView t1;
    //declaring variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //local area
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylayout = findViewById(R.id.merabg);
        f1 = findViewById(R.id.b1);
        f2 = findViewById(R.id.b2);
        f3 = findViewById(R.id.b3);
        f4 = findViewById(R.id.b4);
        t1 = findViewById(R.id.res);

        //above line definition completed
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here is function for click - change background color when click button
                mylayout.setBackgroundColor(Color.GREEN);
                t1.setText("Button1 clicked");
                //click this button remove fourth button
                f4.setVisibility(View.INVISIBLE);
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here function back to original screen
                mylayout.setBackgroundResource(R.drawable.hp);
                t1.setText("Button2 clicked");
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change font of second button
                f2.setTextSize(10.0f);
                //or f2.setText("change background image");
                t1.setText("Button3 clicked");
                //click this button reappear fourth button
                f4.setVisibility(View.VISIBLE);
            }
        });
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click this button get some message for few seconds
                //Toast message is very important
                Toast.makeText(MainActivity.this, "Welcome to program", Toast.LENGTH_LONG).show();
                finish(); //close the application, app gets closed
            }
        });
    }
}