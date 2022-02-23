package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertPage extends AppCompatActivity {
    EditText ename, edept, eemail, ephone;
    Button idata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_page);
        ename = findViewById(R.id.ename);
        edept = findViewById(R.id.edept);
        eemail = findViewById(R.id.eemail);
        ephone = findViewById(R.id.ephone);
        idata = findViewById(R.id.idata);
        idata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper mh = new MyHelper(InsertPage.this);
                mh.createUser(ename.getText().toString(),
                             ephone.getText().toString(),
                             eemail.getText().toString(),
                        edept.getText().toString());
                mh.close();
            }
        });
    }
}