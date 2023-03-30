package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wecare.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    ImageButton home_remedies_image;
    ImageButton read_image;
    ImageButton video_image;
    ImageButton diary_image;

    TextView home_remedies_text;
    TextView read_text;
    TextView diary_text;
    TextView video_text;

    Button today;
    Button home;
    Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_remedies_image = (ImageButton) findViewById(R.id.home_remedies_image);
        read_image = (ImageButton) findViewById(R.id.read_image);
        video_image = (ImageButton) findViewById(R.id.video_image);
        diary_image = (ImageButton) findViewById(R.id.diary_image);

        home_remedies_text = (TextView) findViewById(R.id.home_remedies_text);
        read_text = (TextView) findViewById(R.id.read_text);
        diary_text = (TextView) findViewById(R.id.diary_text);
        video_text = (TextView) findViewById(R.id.video_text);

        today = (Button) findViewById(R.id.today);
        home = (Button) findViewById(R.id.home);
        profile = (Button) findViewById(R.id.profile);

        home_remedies_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, scrollRemedies.class);
                startActivity(intent);
            }
        });

        read_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, ReadInformation.class);
                startActivity(intent);
            }
        });

        diary_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, Diary.class);
                startActivity(intent);
            }
        });

        video_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, Video.class);
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Today.class);
                startActivity(intent);
            }
        });

        /*profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });*/
    }



}