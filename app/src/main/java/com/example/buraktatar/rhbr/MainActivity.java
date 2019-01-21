package com.example.buraktatar.rhbr;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button but1, btn2,btn3,btn4;
    EditText ad;
    TextView tc;
    EditText numara;
    EditText soyad;
    private database vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vt = new database(this);
        but1 = (Button) findViewById(R.id.button);
        tc = (TextView) findViewById(R.id.textView);
        ad = (EditText) findViewById(R.id.editText);
        soyad = (EditText) findViewById(R.id.editText2);
        btn2 = (Button) findViewById(R.id.button2);
        numara = (EditText) findViewById(R.id.editText3);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
deletedata();
updatedata();
addData();
viewall();
    }
    public void deletedata() {
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows=vt.deleteData(ad.getText().toString());
            }
        });
    }
    public void updatedata(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate =vt.updateData(ad.getText().toString()
                ,soyad.getText().toString(),numara.getText().toString());
            }
        });
    }
    public  void addData(){
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =vt.insertData(ad.getText().toString(),
                soyad.getText().toString(),numara.getText().toString());
            }
        });
    }
    public  void viewall(){
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=vt.getAllData();

                StringBuffer buffer=new StringBuffer();
               while (res.moveToNext()){
                   buffer.append("name="+res.getString(0)+"\n");
                   buffer.append("surname="+res.getString(1)+"\n");
                   buffer.append("number="+res.getString(2)+"\n");
Toast.makeText(getApplicationContext(),"Data"+buffer.toString(),Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}