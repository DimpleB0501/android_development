package com.example.callsmswebemailshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button call, sms, web,share, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call = findViewById(R.id.call);
        sms = findViewById(R.id.sms);
        web = findViewById(R.id.web);
        share = findViewById(R.id.share);
        email = findViewById(R.id.email);
        call.setOnClickListener(this);
        sms.setOnClickListener(this);
        web.setOnClickListener(this);
        share.setOnClickListener(this);
        email.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            //can do this as well
            //if (view == call)
            case R.id.call:
                Toast.makeText(this, "Call done", Toast.LENGTH_SHORT).show();
                Intent c= new Intent();
                c.setAction(Intent.ACTION_CALL); //what to do
                c.setData(Uri.parse("tel:+919167825551")); //whom to call universal resource identifier (uri)
                startActivity(c);
                //no permission added than crash happens add permission in manifests
                //go to app and set the permission
                break;

            case R.id.sms:
                Toast.makeText(this, "SMS done", Toast.LENGTH_SHORT).show();
                Intent sm = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7506084465"));
                sm.putExtra("sms_body","This is my first sms");
                startActivity(sm);
                break;

            case R.id.web:
                Toast.makeText(this, "WEB done", Toast.LENGTH_SHORT).show();
                Intent w = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(w);
                break;

            case R.id.share:
                Toast.makeText(this, "Share done", Toast.LENGTH_SHORT).show();
                Intent sh = new Intent(Intent.ACTION_SEND);
                sh.setType("text/plain");
                sh.putExtra(Intent.EXTRA_TEXT, "please gift me something");
                startActivity(Intent.createChooser(sh,"Mera app"));
                break;

            case R.id.email:
                //Toast.makeText(this, "EMAIL done", Toast.LENGTH_SHORT).show();
                Intent em = new Intent(Intent.ACTION_SEND);
                em.setType("message/rfc822");
                String[] to = {"abb@gmail.com", "dimple.bhuta@gmail.com"};
                em.putExtra(Intent.EXTRA_EMAIL, to);
                String[] cc = {"ssss@gmail.com"};
                em.putExtra(Intent.EXTRA_CC, cc);
                String sub = "Come to Birthday";
                em.putExtra(Intent.EXTRA_SUBJECT, sub);
                String body = "Come with gift compulsory or dont come";
                em.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(em, "My mail list"));

                break;
        }
    }
}