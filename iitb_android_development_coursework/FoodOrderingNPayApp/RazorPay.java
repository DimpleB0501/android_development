package com.example.foodorderingandpay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class RazorPay extends Activity implements PaymentResultListener {
    private static final String TAG = RazorPay.class.getSimpleName();
    TextView tv;
    Integer val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor_pay);
        tv = findViewById(R.id.tv);
        Bundle b = this.getIntent().getExtras();
        if (b != null){
            tv.setText(b.getString("pay", null) + " Rs");
        }
        val = Integer.valueOf(b.getString("pay", null));

        //To ensure faster loading of checkout form
        Checkout.preload(getApplicationContext());
        Button button = findViewById(R.id.btn_pay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RazorPay.this, "Value: "+val, Toast.LENGTH_SHORT).show();
                val = val * 100;
                startPayment(val);
            }
        });

        TextView privacyPolicy = findViewById(R.id.txt_privacy_policy);


        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent httpIntent = new Intent(Intent.ACTION_VIEW);
                httpIntent.setData(Uri.parse("https://razorpay.com/sample-application/"));
                startActivity(httpIntent);
            }
        });

    }

    public void startPayment(Integer value_purchase){
        //you need to pass current activity in order to let razorpay create checkoutactivity
        Activity activity = this;
        Checkout co = new Checkout();

        try{
            JSONObject options = new JSONObject();
            options.put("name", "Razorpay Corp");
            options.put("description", "Charge");
            //you can omit the image option to fetch the image from dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount",value_purchase);

            JSONObject preFill = new JSONObject();
            preFill.put("email", "dimple.bhuta@razorpay.com");
            preFill.put("contact","7506084465");

            options.put("prefill", preFill);
            co.open(activity, options);
        } catch (Exception e){
            Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        try{
            Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Log.e(TAG, "Exception in onPaymentSucess",e);
        }
    }

    @Override
    public void onPaymentError(int code, String response) {
        try{
            Toast.makeText(this, "Payment failed: "+code +" "+response, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.e(TAG, "Exception in onPayment Error", e);
        }
    }
}