package com.example.foodorderingandpay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.example.foodorderingandpay.R.color.material_deep_teal_200;
import static com.example.foodorderingandpay.R.color.material_deep_teal_500;
import static com.example.foodorderingandpay.R.color.switch_thumb_normal_material_light;

public class PaymentPage extends AppCompatActivity {
    TableLayout tl;
    LinearLayout ll;
    Button b1;
    Button b_gp, b_pm, b_rp;
    //ImageButton b_gp, b_pm, b_rp;
    ArrayList<String> StringArray = new ArrayList<String>();
    Set<String> keys;
    Collection<String> values;
    Integer total_bill;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        ll = findViewById(R.id.ll);
        tl = findViewById(R.id.tl);
        b1 = findViewById(R.id.b1);
        b_gp = findViewById(R.id.b_gp);
        b_pm = findViewById(R.id.b_pm);
        b_rp = findViewById(R.id.b_rp);
        tl.setStretchAllColumns(true);
        total_bill = 0;
        Intent intent = getIntent();
        HashMap<String, String> hashMap = (HashMap<String, String>)intent.getSerializableExtra("val");

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            //System.out.println("Key: " + k + ", Value: " + v);
        }

        // Get all keys
        keys = hashMap.keySet();

        // Get all values
        values = hashMap.values();

        TableRow row=new TableRow(this);
        row=new TableRow(this);
        row.setBackgroundResource(material_deep_teal_500);
        TextView text1=new TextView(this.getApplicationContext());
        text1.setTypeface(null, Typeface.BOLD);
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        TextView text2=new TextView(this.getApplicationContext());
        text2.setTypeface(null, Typeface.BOLD);
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);

        String[] movieArray = keys.toArray(new String[keys.size()]);
        String[] payArray = values.toArray(new String[values.size()]);
        text1.setText("Item");
        row.addView(text1);
        text2.setText("Price");
        row.addView(text2);

        tl.addView(row);
        for ( int i=0;i<movieArray.length;i++)
        {

            row=new TableRow(this.getApplicationContext());
            row.setBackgroundResource(switch_thumb_normal_material_light);
            text1=new TextView(this.getApplicationContext());
            text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
            text2=new TextView(this.getApplicationContext());
            text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);


            text1.setText(movieArray[i]);
            row.addView(text1);
            text2.setText(payArray[i]);
            row.addView(text2);

            tl.addView(row);
            total_bill = total_bill +Integer.valueOf(payArray[i].split(" ")[1]);
        }
        row=new TableRow(this.getApplicationContext());
        row.setBackgroundResource(material_deep_teal_200);
        text1=new TextView(this.getApplicationContext());
        text1.setTypeface(null, Typeface.BOLD);
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        text2=new TextView(this.getApplicationContext());
        text2.setTypeface(null, Typeface.BOLD);
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);


        text1.setText("Total");
        row.addView(text1);
        text2.setText("Rs "+total_bill.toString());
        row.addView(text2);
        tl.addView(row);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SHOW the button
                b_gp.setVisibility(View.VISIBLE);
                b_pm.setVisibility(View.VISIBLE);
                b_rp.setVisibility(View.VISIBLE);
            }
        });

        b_rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentPage.this, RazorPay.class);
                Bundle b = new Bundle();
                b.putString("pay", total_bill.toString());
                i.putExtras(b);
                startActivity(i);
            }
        });
        b_gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ig = new Intent(PaymentPage.this, GooglePay.class);
                Bundle b1 = new Bundle();
                b1.putString("pay", total_bill.toString());
                ig.putExtras(b1);
                startActivity(ig);
            }
        });
    }
    // Toast.makeText(this, ""+keys + "\n"+values, Toast.LENGTH_LONG).show();
}