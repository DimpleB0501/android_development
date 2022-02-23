package com.example.androidphpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        new ConnectServer().execute("http://10.0.2.2:8080/global/hello.php");
        //calling url of xammp
    }

    class ConnectServer extends AsyncTask<String, String, String>{
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Please wait for some time......");
            pd.show();

        }

        @Override
        protected String doInBackground(String... strings) {
            //fetch data
            try{
            OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(strings[0])
                        .build();

                Response response = client.newCall(request).execute();
                String data = response.body().string();
                if (data != null)
                    return data;

            } catch (Exception e){
                Log.d("myerror", e+"");

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!= null)
                tv.setText(s);

            else
                tv.setText("Sorry null");
            pd.dismiss();
        }
    }
}