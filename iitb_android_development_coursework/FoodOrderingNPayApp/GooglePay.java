package com.example.foodorderingandpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GooglePay extends AppCompatActivity {
    String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
    int GOOGLE_PAY_REQUEST_CODE = 123;
    TextView tv;
    Button button;
    String amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_pay);
        tv = findViewById(R.id.tv);
        button = findViewById(R.id.btn_pay);
        Bundle b = this.getIntent().getExtras();
        if (b!=null){
            tv.setText(b.getString("pay", null) + " Rs");
        }
        amount = b.getString("pay", null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri =
                        new Uri.Builder()
                                .scheme("upi")
                                .authority("pay")
                                .appendQueryParameter("pa", "dimple.bhuta@upi")
                                .appendQueryParameter("pn",  "BCR2DN6TVPZNNNLL")
                                .appendQueryParameter("mc", "5815")
                                .appendQueryParameter("tr", "GP425")
                                .appendQueryParameter("tn", "Food delivery")
                                .appendQueryParameter("am", "100")
                                .appendQueryParameter("cu", "INR")
                                .appendQueryParameter("url", "https://test.merchant.website")
                                .build();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setPackage(GOOGLE_PAY_PACKAGE_NAME);
                startActivityForResult(intent, GOOGLE_PAY_REQUEST_CODE);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOOGLE_PAY_REQUEST_CODE){
            Toast.makeText(GooglePay.this, "Your order is sucessfully placed", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(GooglePay.this, "Payment Issues, Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}