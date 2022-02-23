package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class GetPage extends AppCompatActivity {
ListView guser;
MyHelper mh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_page);
        guser = findViewById(R.id.guser);
        final MyHelper mh = new MyHelper(GetPage.this);
        ArrayAdapter ad = new ArrayAdapter(GetPage.this,
                android.R.layout.simple_list_item_1,
                mh.storelist().get("name"));
        guser.setAdapter(ad);
        guser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GetPage.this,   "Dept: "+mh.storelist().get("dept").get(position) +
                                "\nPhone: "+ mh.storelist().get("phone").get(position)+
                                "\nMail: "+ mh.storelist().get("mail").get(position)
                        , Toast.LENGTH_SHORT).show();

            }
        });

    }
}
