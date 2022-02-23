package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText un, pwd;
    Button lgn, su;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        un = findViewById(R.id.un);
        pwd = findViewById(R.id.pwd);
        lgn = findViewById(R.id.lgn);
        su = findViewById(R.id.su);
        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (un.getText().toString().equals("dimple") && pwd.getText().toString().equals("1234")){
                    Intent gthp = new Intent(login.this, Home.class);
                            startActivity(gthp);
                }
                else{
                    Intent gtep = new Intent(login.this, Error.class);
                    startActivity(gtep);
                }
            }
        });
    }
}