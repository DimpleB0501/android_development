package com.example.hw_numbertype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(MainActivity.this, EvenOrOdd.class);
                Bundle b = new Bundle();
                //b.putString("int_val", et.getText().toString());
                b.putInt("int_val", Integer.parseInt(et.getText().toString()));
                go.putExtras(b);
                startActivity(go);

            }
        });
    }
}