package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.afinal.database.DatabaseHandler;
import com.example.wecare.R;

import java.util.ArrayList;


public class Diary extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> date, time;
    MyAdapter adapter;
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        date = new ArrayList<>();
        time = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, date, time);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showdata();
    }

        //TableView table = (TableView) findViewById(R.id.table);


        private void showdata()
        {
            Cursor cursor = db.getData();
            if(cursor.getCount()==0)
            {
                Toast.makeText(Diary.this, "No more Entries", Toast.LENGTH_SHORT).show();
                return;
            }
            else
            {
                while(cursor.moveToNext())
                {
                    date.add(cursor.getString(0));
                    time.add(cursor.getString(1));
                }
            }
        }


}