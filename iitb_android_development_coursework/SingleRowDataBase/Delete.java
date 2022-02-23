package com.example.singlerowdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    EditText ph;
    Button b;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        sp = (SharedPreferences) getSharedPreferences("Student", MODE_PRIVATE);
        ph = findViewById(R.id.ph);
        b = findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp.getString("uphone", null).equals(ph.getText().toString()))
                {
                    SharedPreferences.Editor ed = sp.edit();
                    ed.clear();
                    ed.commit();
                    Toast.makeText(Delete.this, "Removed sucessfully", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    Toast.makeText(Delete.this, "Cannot delete the user. \nEnter correct phone number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}