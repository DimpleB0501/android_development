package com.example.sensorproximity;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView gsv;
    SensorManager sm;
    Sensor s;
    SensorEventListener sel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gsv = findViewById(R.id.gsv);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (s != null){
            sel = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    if (event.values[0] == 0){
                        gsv.setText("Dont touch me");
                    }
                    else{
                        gsv.setText("Touch me");
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
            sm.registerListener(sel, s, SensorManager.SENSOR_DELAY_NORMAL);

        }
        else{
            Toast.makeText(this, "No proximity sensor", Toast.LENGTH_SHORT).show();
        }
    }
}