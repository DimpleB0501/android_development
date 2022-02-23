package com.example.longpressdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, Menu.FIRST, Menu.NONE, "Android");
        menu.add(0, Menu.FIRST+1, Menu.NONE, "Blackberry");
        menu.add(0, Menu.FIRST+2, Menu.NONE, "IOS");
        menu.add(0, Menu.FIRST+3, Menu.NONE, "Windows");
        menu.add(0, Menu.FIRST+4, Menu.NONE, "Symbian");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv =  findViewById(R.id.iv);
        iv.setOnCreateContextMenuListener(this);
    }
}