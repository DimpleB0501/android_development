package com.example.checkingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout hello;
    RadioGroup gender;
    RadioButton rb;
    CheckBox ia;
    Button demo;
    SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender = findViewById(R.id.gender);
        ia = findViewById(R.id.ia);
        hello = findViewById(R.id.hello);
        demo = findViewById(R.id.demo);
        sb = findViewById(R.id.sb);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                rb = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "Your Gender is: "+rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        ia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    demo.setEnabled(true);
                }
                else{
                    demo.setEnabled(false);
                }
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress > 50){
                    hello.setBackgroundColor(Color.parseColor("#B470C6"));
                }
                else{
                    hello.setBackgroundColor(Color.parseColor("#730E8F"));
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}