package com.example.submenudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu veg=menu.addSubMenu("Veg");
        SubMenu nveg=menu.addSubMenu("Non-Veg");

        veg.add(0, Menu.FIRST, Menu.NONE, "Palak Panner");
        veg.add(0, Menu.FIRST+1, Menu.NONE, "Gobi masala");
        veg.add(0, Menu.FIRST+2, Menu.NONE, "Handi Biryani");
        nveg.add(0, Menu.FIRST+3, Menu.NONE, "Chicken tikka");
        nveg.add(0, Menu.FIRST+4, Menu.NONE, "keema");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}