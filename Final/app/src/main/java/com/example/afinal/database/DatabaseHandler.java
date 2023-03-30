package com.example.afinal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseHandler extends SQLiteOpenHelper {

public static final String DATE = "date";
public static final String TIME = "time";
    public DatabaseHandler(Context context) {
        super(context, "database_name", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        String create = "CREATE TABLE exercise_time (date TEXT, time TEXT)";
        MyDB.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS exercise_time");
        onCreate(MyDB);
    }




    String day;
    String month;
    String year;
    public boolean addNewDay(String time)
    {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        String full = new SimpleDateFormat("yyyy-MM-dd").format(date);
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, full);
        values.put(TIME, time);


       // values.put(Parameters.KEY_INCREMENT, "subtraction");

        long result =db.insert("exercise_time", null, values);
        db.close();
        if(result==-1)
        {

            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getData()
    {
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  exercise_time", null);
        return cursor;
    }
}
