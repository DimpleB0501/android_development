package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeletePage extends AppCompatActivity {
    EditText dphone, ddept;
    Button ddata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_page);
        dphone = findViewById(R.id.dphone);
        ddept = findViewById(R.id.ddept);
        ddata = findViewById(R.id.ddata);
        ddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper mh = new MyHelper(DeletePage.this);
                mh.delete(ddept.getText().toString(), dphone.getText().toString());
                mh.close();
            }
        });
    }
}