package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText un;
    Button gthp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un = findViewById(R.id.un);
        gthp = findViewById(R.id.gthp);
        gthp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(MainActivity.this, HomePage.class);
                Bundle b = new Bundle();
                b.putString("un",un.getText().toString()); //key and value
                go.putExtras(b);
                startActivity(go);
            }
        });
    }
}