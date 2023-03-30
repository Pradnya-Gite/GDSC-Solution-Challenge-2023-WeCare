package com.example.afinal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wecare.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Food extends AppCompatActivity {

    public EditText food;
    public TextView carbs1;
    public Button showcarbs;
    public Button add;
   private ProgressBar progress_bar;
    public int progress=0;
    public TextView text_view_progress;
    int carbs=0;
    public int input = 120;
    public int percent;
    //ProgressBar dailyCarbs;
    private static final String spName ="key";

    private SharedPreferences.Editor editor1;
    //private String sharedPref = "MY_PREF1";
   // private String REFRESH_DAILY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        carbs1 = (TextView) findViewById(R.id.carbs);
        food = (EditText) findViewById(R.id.food);
        showcarbs = (Button) findViewById(R.id.showcarbs);
        add = (Button) findViewById(R.id.add);
        text_view_progress=(TextView) findViewById(R.id.text_view_progress);


       // REFRESH_DAILY1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date());

        //check for first time



        showcarbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carbs=0;
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                String n = food.getText().toString();
                carbs = databaseAccess.getCarbs(n);

                carbs1.setText(Integer.toString(carbs));

                percent = carbs*100/input;
                databaseAccess.close();

            }
        });

        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        // text_view_progress = (TextView) findViewById(R.id.text_view_progress);

       update();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              progress+=percent;

            if(progress<100)
            {

                    update();
                    food.getText().clear();
                    carbs1.setText("0");
                    Toast.makeText(getApplicationContext(), "food item submitted successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                progress -= percent;
                Toast.makeText(getApplicationContext(), "this much of carbs can not be added", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

    public void update()
    {
        progress_bar.setProgress(progress);
        text_view_progress.setText(String.valueOf(progress) + "%");      //we can also do this
                                                                          //Integer.toString(progress)  or
                                                                           // pass (progress along with any string example " ")
    }


    @Override
    public void onStop() {
        super.onStop();

         SharedPreferences sp= Food.this.getSharedPreferences(spName,MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sp.edit();
        editor1.putInt("key",progress_bar.getProgress());
        editor1.putInt("value",progress);
        editor1.commit();
       // Toast.makeText(getApplicationContext(), "progress"+progress, Toast.LENGTH_SHORT).show();
       // Toast.makeText(getApplicationContext(), "on stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
       // dailyCarbs =(ProgressBar) findViewById(R.id.progress_bar);
        SharedPreferences sp= Food.this.getSharedPreferences(spName,MODE_PRIVATE);
        progress=sp.getInt("key",0);
        //Toast.makeText(getApplicationContext(), "progress"+progress, Toast.LENGTH_SHORT).show();
       // Toast.makeText(getApplicationContext(), "on start called", Toast.LENGTH_SHORT).show();

        SharedPreferences mPrefs1= Food.this.getSharedPreferences("date",MODE_PRIVATE);
        Boolean today_Checkin1 =  mPrefs1.getBoolean(Today.REFRESH_DAILY, false);
        //Toast.makeText(Food.this, "todayCheck: "+today_Checkin1.toString(), Toast.LENGTH_SHORT).show();
        if (!today_Checkin1 ){
            progress=0;
            progress_bar.setProgress(progress);
            text_view_progress.setText("0"+"%");
            Toast.makeText(Food.this, "New Dayyyy", Toast.LENGTH_SHORT).show();
            //new day is here
        } else {
            progress_bar.setProgress(progress);
            text_view_progress.setText(String.valueOf(progress)+"%");
           // Toast.makeText(Food.this, "already done", Toast.LENGTH_SHORT).show();
        }

        //when you have done for today
        editor1 = mPrefs1.edit();
        editor1.putBoolean(Today.REFRESH_DAILY, false);
        editor1.apply();


    }
}



