package com.example.autoacceptpermission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button cp, rp;
    boolean checkperm(){ //Mainactivity.this or getApplicationcontext() is same
        int p1 = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE);
        int p2 = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.SEND_SMS);
        int p3 = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA);
        int p4 = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int p5 = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.BLUETOOTH);
        int p6 = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.BLUETOOTH_ADMIN);
      return p1== PackageManager.PERMISSION_GRANTED &&
              p2== PackageManager.PERMISSION_GRANTED &&
              p3== PackageManager.PERMISSION_GRANTED &&
              p4== PackageManager.PERMISSION_GRANTED &&
              p5== PackageManager.PERMISSION_GRANTED &&
              p6== PackageManager.PERMISSION_GRANTED;
    }

    void requestdialogperm(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS,
                        Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN},200);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cp = findViewById(R.id.cp);
        rp = findViewById(R.id.rp);
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkperm()){
                    Toast.makeText(MainActivity.this, "Granted ...", Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, "Granted", Snackbar.LENGTH_LONG)
                            .setAction("Click", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(MainActivity.this, "All permission successfully configured .....", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please click on REQUEST PERMISSION", Toast.LENGTH_SHORT).show();
                }

            }
        });
        rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkperm()){
                    //use func to grant
                    requestdialogperm();
                }
                else{
                    Toast.makeText(MainActivity.this, "Already granted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}