package com.example.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.database.DatabaseHandler;
import com.example.wecare.R;

public class Exercise extends AppCompatActivity {

    EditText inputExerciseTime;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        inputExerciseTime = (EditText) findViewById(R.id.inputExerciseTime);
        Submit =(Button) findViewById(R.id.submitTime);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTime();
            }
        });

    }


    DatabaseHandler db = new DatabaseHandler(this);

    public void addTime()
    {
        boolean result=db.addNewDay(inputExerciseTime.getText().toString());
        inputExerciseTime.getText().clear();
        if(result == false)
        {
            Toast.makeText(getApplicationContext(), "Already added for today", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();
        }
    }


}