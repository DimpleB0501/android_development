package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdatePage extends AppCompatActivity {
EditText uphone, udept, uemail;
Button udata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);
        uphone = findViewById(R.id.uphone);
        udept = findViewById(R.id.udept);
        uemail = findViewById(R.id.uemail);
        udata = findViewById(R.id.udata);
        udata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper mh = new MyHelper(UpdatePage.this);
                mh.update(uphone.getText().toString(), uemail.getText().toString(),
                        udept.getText().toString());
                mh.close();
            }
        });

    }
}