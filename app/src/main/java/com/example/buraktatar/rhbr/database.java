package com.example.buraktatar.rhbr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="database";
    private static final int DATABASE_VERSION=1 ;

    private static final String AD ="ad" ;
    private static final String SOYAD ="soyad" ;
    private static final String NUMARA ="numara" ;
    private String rehber;

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE Table rehber (ad TEXT,soyad TEXT,numara TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
        onCreate(db);
    }
public boolean insertData(String name ,String surname ,String number ){
SQLiteDatabase db=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(AD,name);
    contentValues.put(SOYAD,surname);
    contentValues.put(NUMARA,number);

    long result =db.insert(rehber,null,contentValues);
    if(result==-1)
        return false;
    else
        return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery(rehber,"select * from rehber",null);

        return res;
    }


    public boolean updateData(String name,String surname,String number){
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(AD,name);
        contentValues.put(SOYAD,surname);
        contentValues.put(NUMARA,number);
        db.update(rehber,contentValues,"AD ?",new String[]{name});



        return true;

    }
public Integer deleteData(String name){
            SQLiteDatabase db=this.getWritableDatabase();
            return db.delete(rehber,"AD=?",new String[]{name});



}
    }

