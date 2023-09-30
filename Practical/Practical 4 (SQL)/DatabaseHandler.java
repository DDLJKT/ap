package com.example.sqlitetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "studentManager";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_STUDENT_TABLE="create table student(rollno text primary key, name text, age text, phonenumber text, email text, gender text, address text)";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS student");
        onCreate(sqLiteDatabase);
    }


    public Boolean addDetail(String rollno, String name, String age, String phonenumber,
                             String email, String gender, String address)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues add=new ContentValues();

        add.put("rollno",rollno);
        add.put("name",name);
        add.put("age",age);
        add.put("phonenumber",phonenumber);
        add.put("email",email);
        add.put("gender",gender);
        add.put("address",address);

        long r = sqLiteDatabase.insert("student",null,add);
        if(r==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean updateDetail(String rollno, String name, String age, String phonenumber,
                                String email, String gender, String address){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues add=new ContentValues();

        add.put("name",name);
        add.put("age",age);
        add.put("phonenumber",phonenumber);
        add.put("email",email);
        add.put("gender",gender);
        add.put("address",address);


        Cursor cursor=sqLiteDatabase.rawQuery("select * from student where rollno=?",new String[] {rollno} );

        if (cursor.getCount()>0){

            long r=sqLiteDatabase.update("student",add,"rollno=?",new String[]{rollno});

            if (r==-1){
                return false;
            }
            else {
                return true;
            }
        }else{
            return false;
        }

    }

    public boolean deleteDetails(String rollno){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from student where rollno=?",new String[]{rollno});
        if (cursor.getCount()>0){
            long r=db.delete("student","rollno=?",new String[]{rollno});
            if (r==-1){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

   Details selectData(String rollno){
       SQLiteDatabase db = this.getReadableDatabase();


       Cursor cursor = db.query("student", new String[] { "rollno",
                       "name", "age", "phonenumber","email","gender","address" }, "rollno=?",
               new String[] { String.valueOf(rollno) }, null, null, null, null);
       if (cursor != null) {
           cursor.moveToFirst();
       }
       Details details = new Details(cursor.getString(0),
               cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4)
       ,cursor.getString(5),cursor.getString(6));

       return details;
   }
}
