package com.example.customlistviewdemo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.GenericLifecycleObserver;

import com.bumptech.glide.Glide;

public class MyAdapter extends BaseAdapter {
    LayoutInflater li;
    Context con;
    String [] hdata,sdata;
    //Integer[] iurl;
    String[] iurl;
    //MyAdapter (in case of stored images change iurl to Integer
    // Context con, Integer[] iurl, ....)
    public MyAdapter(Context con, String[] iurl, String[] hdata, String[] sdata) {
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
    public Object getItem(int position) {
        return iurl;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ImageView civ;
    TextView chead, csub;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = li.inflate(R.layout.custom, null);
        civ = v.findViewById(R.id.civ);
        chead = v.findViewById(R.id.chead);
        csub = v.findViewById(R.id.csub);
        //civ.setImageResource(iurl[position]);
        Glide.with(con).load(iurl[position]).into(civ);
        chead.setText(hdata[position]);
        csub.setText(sdata[position]);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(con, ""+hdata[position], Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}


/*
errors -> first click on bulb -> implement methods -> 4 methods will be shown
empty line after string -> right click -> generate -> constructor -> select 4 values
*/
