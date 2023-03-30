package com.example.afinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.afinal.database.DatabaseHandler;

public class ExerciseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static ExerciseAccess instance;
    Cursor c=null;

    private ExerciseAccess(Context context){
        this.openHelper=new DatabaseHandler(context);
    }

    public static ExerciseAccess getInstance(Context context){
        if(instance==null){
            instance =new ExerciseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    int carbs=0;
    public int getExercise(String food){
        c =db.rawQuery("select * from exercise_time",null);

        while(c.moveToNext()){
            carbs =c.getInt(0);

        }
        return carbs;
    }
}
