package com.example.singlerowdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText un, pwd;
Button lgn, rgr, del;
SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = (SharedPreferences) getSharedPreferences("Student", MODE_PRIVATE);

        un = findViewById(R.id.un);
        pwd = findViewById(R.id.pwd);
        lgn = findViewById(R.id.lgn);
        rgr = findViewById(R.id.rgr);
        del = findViewById(R.id.del);
        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent gthp =  new Intent(Login.this, Home.class);
                //startActivity(gthp);
                if (sp.contains("uname") && sp.contains("upass")) {
                    if (sp.getString("uname", null).equals(un.getText().toString()) &&
                            sp.getString("upass", null).equals(pwd.getText().toString())) {

                        Intent gthp = new Intent(Login.this, Home.class);
                        Bundle b = new Bundle();
                        b.putString("uname", un.getText().toString());
                        gthp.putExtras(b);
                        startActivity(gthp);
                    } else {
                        Toast.makeText(Login.this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Login.this, "No user", Toast.LENGTH_SHORT).show();
                }

            }
        });
        rgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sp.contains("uname") && !sp.contains("upass")) {
                    Intent gtrp = new Intent(Login.this, Register.class);
                    startActivity(gtrp);
                }
                else
                {
                    Toast.makeText(Login.this, "Only one account", Toast.LENGTH_SHORT).show();
                }
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp.contains("uname") && sp.contains("upass")) {
                   Intent gtdp =  new Intent(Login.this, Delete.class);
                   startActivity(gtdp);
                }
                else{
                    Toast.makeText(Login.this, "No data", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}