package com.example.afinal;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wecare.R;

public class scrollRemedies extends AppCompatActivity {

    ImageView remedies_image;
    TextView remedies_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_remedies);

        remedies_image = (ImageView) findViewById(R.id.remedies_image);
        remedies_text = (TextView) findViewById(R.id.remedies_text);
    }
}