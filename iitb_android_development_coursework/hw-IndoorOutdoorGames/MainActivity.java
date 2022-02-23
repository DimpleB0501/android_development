package com.example.subgames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu ingames = menu.addSubMenu("Indoor games");
        SubMenu outgames = menu.addSubMenu("Outdoor games");

        ingames.add(0, Menu.FIRST, Menu.NONE, "Chess");
        ingames.add(0, Menu.FIRST+1, Menu.NONE, "Cards");
        ingames.add(0, Menu.FIRST+2, Menu.NONE, "Pool");
        outgames.add(0, Menu.FIRST+3, Menu.NONE, "Tennis");
        outgames.add(0, Menu.FIRST+4, Menu.NONE,"Cricket");
        outgames.add(0, Menu.FIRST+5, Menu.NONE, "Swimming");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.i1);
                break;
            case Menu.FIRST+1:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.i2);
                break;
            case Menu.FIRST+2:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.i3);
                break;
            case Menu.FIRST+3:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.o1);
                break;
            case Menu.FIRST+4:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.o2);
                break;
            case Menu.FIRST+5:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.o3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);
    }
}