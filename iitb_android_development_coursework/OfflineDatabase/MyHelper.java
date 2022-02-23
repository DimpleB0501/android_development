package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class MyHelper extends SQLiteOpenHelper {

    Context con;
    HashMap<String, ArrayList<String>> hm;
    public  HashMap<String, ArrayList<String>> storelist(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> name, dept, phone, mail;
        hm = new HashMap<>();
        String[] cols= {"ename", "edept", "ephone","email"};
        Cursor cur = db.query("employee", cols, null, null,
                null, null, null); //order ascending or decending
        name = new ArrayList<>();
        dept = new ArrayList<>();
        phone = new ArrayList<>();
        mail = new ArrayList<>();
        // select * from employee where ename = "shahsank"
        if (cur.moveToFirst())
            do{
               name.add(cur.getString(0));
                dept.add(cur.getString(1));
                phone.add(cur.getString(2));
                mail.add(cur.getString(3));
            }while(cur.moveToNext());
        cur.close();
        hm.put("name", name);
        hm.put("phone", phone);
        hm.put("dept", dept);
        hm.put("mail", mail);
        db.close();
        return hm;

    }

    public boolean checkuser(String m,String p)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] cols={"ename","edept","ephone","email"};
        Cursor cur=db.query("employee",cols,"email = ? and ephone = ?",
                new String[]{m,p},
                null,null,null);
        if(cur.getCount()!=0)
            return true;

        cur.close();
        db.close();
        return false;
    }


    public void getdata(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols= {"ename", "edept", "ephone","email"};
        Cursor cur = db.query("employee", cols, null, null,
                null, null, null); //order ascending or decending
        // select * from employee where ename = "shahsank"
        if (cur.moveToFirst())
            do{
                Toast.makeText(con, "Name: "+cur.getString(0)+
                        "\n EDept: "+cur.getString(1), Toast.LENGTH_SHORT).show();
            }while(cur.moveToNext());
            cur.close();
            db.close();

    }

    public void update (String phone, String email, String dept){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("edept", dept);
        cv.put("email", email);
        String[] values = {phone};
        db.update("employee", cv, "ephone = ?",values);
        db.close();
        Toast.makeText(con, "Update Done", Toast.LENGTH_SHORT).show();
    }

    public void delete(String dept, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] values = {dept, phone};
        db.delete("employee", "edept = ? and ephone = ?", values);
        db.close();
        Toast.makeText(con, "Deleted", Toast.LENGTH_SHORT).show();
    }

    public void createUser(String ename, String ephone, String eemail, String edept){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ename", ename);
        cv.put("ephone", ephone);
        cv.put("email", eemail);
        cv.put("edept", edept);
        db.insert("employee", null, cv);
        db.close();
        Toast.makeText(con, "Inserted Successfully", Toast.LENGTH_LONG).show();
    }

    public MyHelper( Context context) {
        super(context, "COLLEGE", null, 1);
        con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "create table employee(ename text, ephone text, email text, edept text );"; //syntax to create table
                                            // name datatype
        db.execSQL(table); //table creation
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
//right => generator => Implement methods
//or click on blub and implement methods

//rightclick -> generate contructor -> first -> double click -> none ->ok