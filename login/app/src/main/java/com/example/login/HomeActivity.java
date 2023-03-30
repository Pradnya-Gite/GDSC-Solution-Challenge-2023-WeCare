package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    EditText name;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String fullName = nameEditText.getText().toString();
        EditText currentWeightEditText = (EditText) findViewById(R.id.current_weight);
        String currentWeight = currentWeightEditText.getText().toString();
        EditText ageEditText = (EditText) findViewById(R.id.age);
        String age = ageEditText.getText().toString();
        EditText carbsEditText = (EditText) findViewById(R.id.carbs);
        String carbs = ageEditText.getText().toString();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
    }
    public void onClick(View view){
        //Decide what happens when the user clicks the submit button
        Intent intent = new Intent(getApplicationContext(),LastActivity.class);
        startActivity(intent);
    }


}