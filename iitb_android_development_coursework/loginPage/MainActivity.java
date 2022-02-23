package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout hello;
    CheckBox ia;
    Button demo;
    TextView tv;
    EditText ip_name, ip_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ia = findViewById(R.id.ia);
        hello = findViewById(R.id.hello);
        demo = findViewById(R.id.demo);
        tv = findViewById(R.id.tv);
        ip_name = findViewById(R.id.ip_name);
        ip_pass = findViewById(R.id.ip_pass);

        ia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    demo.setEnabled(true);
                }
                else{
                    demo.setEnabled(false);
                }
            }
        });

        demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Hello " + ip_name.getText().toString()+ ", you have sucessfully logged in.");

            }
        });
    }
}







