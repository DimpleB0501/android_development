package com.example.foodorderingandpay;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class MyAdapter extends BaseAdapter {
    LayoutInflater li;
    Context con;
    String [] hdata,sdata;
    //Integer[] iurl;
    Integer[] iurl;
    Map<String,String> map =  new HashMap<String,String>();

    //MyAdapter (in case of stored images change iurl to Integer
    // Context con, Integer[] iurl, ....)
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
    public Object getItem(int position) {
        return iurl;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ImageView civ;
    TextView chead, csub;
    CheckBox item_sel;
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View v = li.inflate(R.layout.custom, null);
        civ = v.findViewById(R.id.civ);
        chead = v.findViewById(R.id.chead);
        csub = v.findViewById(R.id.csub);
        item_sel = v.findViewById(R.id.item_sel);

        civ.setImageResource(iurl[position]);
        chead.setText(hdata[position]);
        csub.setText(sdata[position]);
        

        item_sel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked){
                        Toast.makeText(con, ""+hdata[position]+" is selected.", Toast.LENGTH_SHORT).show();
                        map.put(hdata[position], sdata[position]);
                    }
                    if (!isChecked){
                        map.remove(hdata[position]);
                    }
            }
        });
        return v;
    }

    public Map<String, String> return_val(){
        return map;
    }
}