package com.example.afinal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wecare.R;

public class ReadInformation extends AppCompatActivity {


    TextView read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_information);
        read = (TextView) findViewById(R.id.read);
    }
}