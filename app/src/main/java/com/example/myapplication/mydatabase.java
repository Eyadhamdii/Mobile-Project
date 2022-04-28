package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class mydatabase extends SQLiteOpenHelper {
    public static final String db_name="usersdb";
    public static final String tb_users_name="users";
    public static final String user_name="username";
    public static final String user_pass="password";

    public static final int db_version=2;
    public mydatabase(Context context){
        super(context,db_name,null,db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  "+tb_users_name+" ( "+user_name+" TEXT UNIQUE, "+user_pass+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
    public boolean insertuser(person person){
        ContentValues values=new ContentValues();
        values.put(user_name,person.getName());
        values.put(user_pass,person.getPassword());
        SQLiteDatabase db=getWritableDatabase();
        Long result=db.insert(tb_users_name,null,values);
        return result !=-1;
    }
    public ArrayList<person> getallusers(){
        ArrayList<person> users=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+tb_users_name,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(user_name));
                @SuppressLint("Range") String pass = cursor.getString(cursor.getColumnIndex(user_pass));
                person person=new person(name,pass);
                users.add(person);
            }
            while (cursor.moveToNext());
            cursor.close();
        }

        return users;
    }
    public ArrayList<person> getuser(String uname){
        ArrayList<person> users=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+tb_users_name+" WHERE "+user_name+"=?",new String[]{uname});
        if(cursor!=null && cursor.moveToFirst()){
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(user_name));
                @SuppressLint("Range") String pass = cursor.getString(cursor.getColumnIndex(user_pass));
                person person=new person(name,pass);
                users.add(person);
            }
            while (cursor.moveToNext());
            cursor.close();
        }

        return users;
    }
}
