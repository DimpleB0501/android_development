package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText lmail,lphone;
    Button lgn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lmail=findViewById(R.id.lmail);
        lphone=findViewById(R.id.lphone);
        lgn=findViewById(R.id.lgn);
        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHelper mh=new MyHelper(Login.this);
                if(mh.checkuser(lmail.getText().toString(),lphone.getText().toString()))
                {
                    Toast.makeText(Login.this, "Valid User", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this, "Invalid", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}