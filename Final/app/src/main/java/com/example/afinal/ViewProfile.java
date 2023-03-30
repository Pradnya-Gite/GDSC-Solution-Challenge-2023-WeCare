package com.example.afinal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wecare.R;

public class ViewProfile extends AppCompatActivity {

    TextView name;
    TextView your_name;
    TextView age;
    TextView your_age;
    TextView weight;
    TextView your_weight;
    TextView carbs;
    TextView your_carbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        name = (TextView) findViewById(R.id.name);
    }
}