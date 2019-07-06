package com.example.dbexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase myDB;
    Button btnAdd;
    TextView etName,etEmail;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);

        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS user (name VARCHAR(200), email VARCHAR(200))");

//        OnButtonClickHandler();

        int a = 1;




//        myDB.close();



    }


    public void onReadClick(View view)
    {



        TextView MyetName = (TextView)findViewById(R.id.etName);
        TextView MyetEmail = (TextView)findViewById(R.id.etEmail);

        String UserNameText = (String) MyetName.getText().toString();
        String EmailText = (String) MyetEmail.getText().toString();


        Cursor myCursor = myDB.rawQuery("select name, email from user", null);

        while(myCursor.moveToNext()) {
            String name = myCursor.getString(0);
            String email = myCursor.getString(1);

            MyetName.setText(name);
            MyetEmail.setText(email);
        }

//        Toast.makeText(this, UserNameText, Toast.LENGTH_SHORT).show();

    }



    public void onMyButtonClick(View view)
    {



        TextView MyetName = (TextView)findViewById(R.id.etName);
              TextView MyetEmail = (TextView)findViewById(R.id.etEmail);

              String UserNameText = (String) MyetName.getText().toString();
               String EmailText = (String) MyetEmail.getText().toString();


                        ContentValues row = new ContentValues();
                        row.put("name", UserNameText);
                        row.put("email",EmailText);

                        myDB.insert("user", null, row);

//        Toast.makeText(this, UserNameText, Toast.LENGTH_SHORT).show();

    }

    public void OnButtonClickHandler(){

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                TextView MyetName = (TextView)findViewById(R.id.etName);
////                TextView MyetEmail = (TextView)findViewById(R.id.etEmail);
//
////                String UserNameText = (String) UserName.getText().toString();
////                String EmailText = (String) Email.getText().toString();
//
//
////                        ContentValues row = new ContentValues();
////                        row.put("name", UserNameText);
////                        row.put("email",EmailText);
//
////                        myDB.insert("user", null, row);
//
//            }
//        });

    }
}
