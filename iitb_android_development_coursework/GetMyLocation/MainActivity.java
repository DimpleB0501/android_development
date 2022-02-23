package com.example.getmylocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView gml;
    LocationManager lm;
    LocationListener ll; //listen to location


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gml = findViewById(R.id.gml);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); //service to access location manager
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, new LocationListener() {
            @Override
            public void onLocationChanged( Location location) {
                gml.setText("Latitude: " + location.getLatitude() +
                        "\nLongitude: " + location.getLongitude() +
                        "\nSpeed: " + location.getSpeed() +
                        "\nAccuracy: " + location.getAccuracy() +
                        "\nHeight: " + location.getAltitude());            }
        });
    }
}