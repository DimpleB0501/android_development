package com.example.homeworkdisplay;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    ImageView iv;
    Button b;
    TextView t;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl = findViewById(R.id.rl);
        iv = findViewById(R.id.iv);
        b = findViewById(R.id.b1);
        t = findViewById(R.id.res);
        counter = 0;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter + 1;
                if (counter == 1) {
                    iv.setImageResource(R.drawable.i1);
                    t.setText("Count 1");
                }
                if (counter == 2){
                    iv.setImageResource(R.drawable.i2);
                    t.setText("Count 2");
                }
                if (counter == 3){
                    iv.setImageResource(R.drawable.i3);
                    t.setText("Count 3");
                }
                if (counter == 4){
                    iv.setImageResource(R.drawable.i4);
                    t.setText("Count 4");
                }
                if (counter == 5) {
                    iv.setImageResource(R.drawable.i5);
                    t.setText("Count 5");
                    Toast.makeText(MainActivity.this, "Final image, Closing App", Toast.LENGTH_LONG).show();
                    finish();
                }

            }

        });
    }
}