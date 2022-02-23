package com.example.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] item = {"Apple", "Strawberry", "Pineapple", "Mango","Kiwi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        ArrayAdapter ad = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,item);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               //Toast.makeText(MainActivity.this, ""+position+"\nItem is "+ item[position], Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Intent f1 = new Intent(MainActivity.this, Apple.class);
                        Bundle b1 = new Bundle();
                        b1.putString("str_val", item[position]);
                        f1.putExtras(b1);
                        startActivity(f1);
                        break;
                    case 1:
                        Intent f2 = new Intent(MainActivity.this, Strawberry.class);
                        Bundle b2 = new Bundle();
                        b2.putString("str_val", item[position]);
                        f2.putExtras(b2);
                        startActivity(f2);
                        break;
                    case 2:
                        Intent f3 = new Intent(MainActivity.this, Pineapple.class);
                        Bundle b3 = new Bundle();
                        b3.putString("str_val", item[position]);
                        f3.putExtras(b3);
                        startActivity(f3);
                        break;
                    case 3:
                        Intent f4 = new Intent(MainActivity.this, Mango.class);
                        Bundle b4 = new Bundle();
                        b4.putString("str_val", item[position]);
                        f4.putExtras(b4);
                        startActivity(f4);
                        break;
                    case 4:
                        Intent f5 = new Intent(MainActivity.this, Kiwi.class);
                        Bundle b5 = new Bundle();
                        b5.putString("str_val", item[position]);
                        f5.putExtras(b5);
                        startActivity(f5);
                        break;

                }
            }
        });
    }
}