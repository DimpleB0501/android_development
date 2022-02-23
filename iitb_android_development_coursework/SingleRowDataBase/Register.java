package com.example.singlerowdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText run, rph, rpwd, rcpwd;
    Button rrgr;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sp = (SharedPreferences) getSharedPreferences("Student", MODE_PRIVATE);
        run = findViewById(R.id.run);
        rph = findViewById(R.id.rph);
        rpwd = findViewById(R.id.rpwd);
        rcpwd = findViewById(R.id.rcpwd);
        rrgr = findViewById(R.id.rrgr);
        rrgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //It is for storing the data
               if (rpwd.getText().toString().equals(rcpwd.getText().toString())) {
                   SharedPreferences.Editor ed = sp.edit();
                   ed.putString("uname", run.getText().toString());
                   ed.putString("uphone", rph.getText().toString());
                   ed.putString("upass", rpwd.getText().toString());
                   ed.commit(); //Saved values
                   Toast.makeText(Register.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                    finish();
               }
               else{
                   //Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                    rcpwd.setError("Both are not matching");
               }
            }
        });
    }
}
//data base shared preference. database name is student will be stored as xml file.
//device explorer