package com.example.webdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv =  findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true); //permission required
        //ask for permission
        wv.loadUrl("https://www.google.com");

    }
}