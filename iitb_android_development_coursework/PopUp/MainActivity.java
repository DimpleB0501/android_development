package com.example.popup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void robo(View view) {
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setIcon(android.R.drawable.ic_menu_call);
        adb.setTitle("Mera dialog");
        adb.setMessage("Do you want to close me ?");

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNeutralButton("May be", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Maybe", Toast.LENGTH_SHORT).show();
            }
        });
        adb.setCancelable(false);
        adb.show();
//        Toast sk = Toast.makeText(MainActivity.this, "Hello dimple", Toast.LENGTH_LONG);
//        sk.setGravity(Gravity.CENTER, 500, 400);
//        sk.show();
        //Toast.makeText(this, "New way", Toast.LENGTH_SHORT).show();
    }
}