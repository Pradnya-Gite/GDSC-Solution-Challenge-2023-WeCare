package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wecare.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Today extends AppCompatActivity {


    ImageButton food;
    ImageButton exercise;
    ImageButton tablet;
    static String REFRESH_DAILY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        REFRESH_DAILY = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date());

        food = (ImageButton) findViewById(R.id.food);
        exercise = (ImageButton) findViewById(R.id.exercise);
        tablet = (ImageButton) findViewById(R.id.tablet);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Today.this,Food.class);
                startActivity(intent);
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Today.this,Exercise.class);
                startActivity(intent);
            }
        });
    }
}