package com.example.orderingfood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;
    ListView listView;
    String contacts[]={"Dominos", "Pizza Hut", "Papa Jones"};

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.food, menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.call){
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.sms){
            Toast.makeText(this, "Sending SMS", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Menu.FIRST, Menu.NONE, "Pizza");
        menu.add(0, Menu.FIRST+1, Menu.NONE, "Pasta");
        menu.add(0, Menu.FIRST+2, Menu.NONE,"Burger");
        menu.add(0, Menu.FIRST+3, Menu.NONE,"HotDog");
        menu.add(0, Menu.FIRST+4, Menu.NONE, "Schewan pizza");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }
}