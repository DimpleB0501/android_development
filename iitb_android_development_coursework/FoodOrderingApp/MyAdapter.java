package com.example.foodorderingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {
    LayoutInflater li;
    Context con;
    String[] hdata, sdata;
    Integer[] iurl;

    public MyAdapter(Context con, Integer[] iurl, String[] hdata, String[] sdata) {
        this.con = con;
        this.iurl = iurl;
        this.hdata = hdata;
        this.sdata = sdata;
        li = LayoutInflater.from(con);
    }



    @Override
    public int getCount() {
        return iurl.length;
    }

    @Override
    public Object getItem(int i) {
        return iurl;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    ImageView civ;
    TextView chead, csub;
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View v = li.inflate(R.layout.custom, null);
        civ = v.findViewById(R.id.civ);
        chead = v.findViewById(R.id.chead);
        csub = v.findViewById(R.id.csub);
        civ.setImageResource(iurl[position]);
        chead.setText(hdata[position]);
        csub.setText(sdata[position]);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(hdata[position]) {
                    case "Pizza":
                        Intent i1 = new Intent(con, Pizza.class);
                        Bundle b1 =  new Bundle();
                        b1.putString("price", sdata[position]);
                        i1.putExtras(b1);
                        con.startActivity(i1);
                        break;
                    case "Pasta":
                        Intent i2 = new Intent(con, Pasta.class);
                        Bundle b2 =  new Bundle();
                        b2.putString("price", sdata[position]);
                        i2.putExtras(b2);
                        con.startActivity(i2);
                        break;
                    case "Burger":
                        Intent i3 = new Intent(con,  Burger.class);
                        Bundle b3 =  new Bundle();
                        b3.putString("price", sdata[position]);
                        i3.putExtras(b3);
                        con.startActivity(i3);
                        break;
                    case "Sandwich":
                        Intent i4 = new Intent(con,  Sandwich.class);
                        Bundle b4 =  new Bundle();
                        b4.putString("price", sdata[position]);
                        i4.putExtras(b4);
                        con.startActivity(i4);
                        break;

                    case "Sushi":
                        Intent i5= new Intent(con,  Sushi.class);
                        Bundle b5 =  new Bundle();
                        b5.putString("price", sdata[position]);
                        i5.putExtras(b5);
                        con.startActivity(i5);
                        break;
                }

                //Toast.makeText(con, ""+hdata[position], Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
