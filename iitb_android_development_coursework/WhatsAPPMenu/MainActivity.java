package com.example.whatsappmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;
    @Override
    //top right 3 bars displaying the menus. This is called action bar. It doesnt require xml
    public boolean onCreateOptionsMenu(Menu menu) {
        //group id, item id, order,item name
        menu.add(0, Menu.FIRST, Menu.NONE, "Pizza");
        menu.add(0, Menu.FIRST+1, Menu.NONE, "Pasta");
        menu.add(0, Menu.FIRST+2, Menu.NONE,"Burger");
        menu.add(0, Menu.FIRST+3, Menu.NONE,"HotDog");
        menu.add(0, Menu.FIRST+4, Menu.NONE, "Schewan pizza");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.p1);
                break;
            case Menu.FIRST+1:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.p2);
                break;
            case Menu.FIRST+2:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.p3);
                break;
            case Menu.FIRST+3:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.p4);
                break;
            case Menu.FIRST+4:
                tv.setText(""+item.getTitle());
                iv.setImageResource(R.drawable.p5);
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