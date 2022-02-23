package com.example.opernum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    int num1 =10, num2=5;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Menu.FIRST, Menu.NONE, "Add");
        menu.add(0, Menu.FIRST+1, Menu.NONE, "Subtract");
        menu.add(0, Menu.FIRST+2, Menu.NONE,"Multiply");
        menu.add(0, Menu.FIRST+3, Menu.NONE,"Divide");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST:
                tv1.setText(String.valueOf(num1)+"+"+String.valueOf(num2));
                tv2.setText(num1+num2+ "");
                break;
            case Menu.FIRST+1:
                tv1.setText(String.valueOf(num1)+"-"+String.valueOf(num2));
                tv2.setText(num1-num2+ "");
                break;
            case Menu.FIRST+2:
                tv1.setText(String.valueOf(num1)+"x"+String.valueOf(num2));
                tv2.setText(num1*num2+ "");
                break;
            case Menu.FIRST+3:
                tv1.setText(String.valueOf(num1)+"/"+String.valueOf(num2));
                tv2.setText(num1/num2+ "");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
    }
}