package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView msl;
    ArrayList<String> name, vendor;
    SensorManager sm;
    SensorEventListener sel; // will do later
    List<Sensor> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msl = findViewById(R.id.msl);
        name = new ArrayList<>();
        vendor = new ArrayList<>();
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        ls = sm.getSensorList(Sensor.TYPE_ALL);
        Toast.makeText(this, "Toast sensors: "+ls.size(), Toast.LENGTH_SHORT).show();
        //multiple items
        for (int i = 0; i < ls.size();i++){
            name.add(ls.get(i).getName());
            vendor.add(ls.get(i).getVendor());
        }
        ArrayAdapter ad = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, name);
        msl.setAdapter(ad);
    }
}