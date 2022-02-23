package com.example.audioplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button b1, b2, b3, b4;
    SeekBar ss;
    Timer t = new Timer();
    boolean flag = false;
    boolean flag_seek = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        ss = findViewById(R.id.ss);

        mp = mp.create(MainActivity.this,R.raw.audio);
        int stopTime = mp.getDuration();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = true;
                flag_seek = false;
            }
        });

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (flag_seek == true)
                    ss.setProgress((mp.getCurrentPosition()*100)/mp.getDuration());
            }
        }, 0, 100);

        ss.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Toast.makeText(MainActivity.this, ""+progress, Toast.LENGTH_SHORT).show();
                int stopTime = mp.getDuration();
                int progress_val = (stopTime * progress)/100;

                if(mp!=null && mp.isPlaying() && flag == true)
                {
                    //Toast.makeText(MainActivity.this, ""+flag, Toast.LENGTH_SHORT).show();
                    mp.seekTo(progress_val);
                    ss.setProgress(progress);
                    flag = false;
                    flag_seek = true;

                }
                else if(mp!=null && !mp.isPlaying())
                {
                    mp.seekTo(progress_val);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}