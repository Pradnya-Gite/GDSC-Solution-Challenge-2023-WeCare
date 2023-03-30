package com.example.afinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c=null;

    private DatabaseAccess(Context context){
        this.openHelper=new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance =new DatabaseAccess(context);
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
    public int getCarbs(String food){
        c =db.rawQuery("select carbs from foodData where food='"+food+"'",new String[]{});

        while(c.moveToNext()){
             carbs =c.getInt(0);

        }
        return carbs;
    }
}
