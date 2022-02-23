package com.example.sensoracc;

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
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (s!=null){
            sel = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    gsv.setText("X: "+event.values[0]+
                            "  \nY: "+event.values[1]+
                            "  \nZ: "+event.values[2]);
                }


                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
            sm.registerListener(sel, s, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else{
            Toast.makeText(this, "Accelerometer not present", Toast.LENGTH_SHORT).show();
        }
    }
}