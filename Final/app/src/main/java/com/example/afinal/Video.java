package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wecare.R;

public class Video extends AppCompatActivity {

    TextView textVideo1;
    TextView textVideo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        MediaController mediaController1 = new MediaController(this);
        //MediaController mediaController2 = new MediaController(this);

        VideoView sugarmd1 = (VideoView) findViewById(R.id.video1);
        textVideo1 = (TextView) findViewById(R.id.textVideo1);

        //VideoView sugarmd2 = (VideoView) findViewById(R.id.video2);
        //textVideo2 = (TextView) findViewById(R.id.textVideo2);

        sugarmd1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sugarmd1);
        //sugarmd2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sugarmd2);


        sugarmd1.setMediaController(mediaController1);
        //sugarmd1.setMediaController(mediaController2);

        mediaController1.setAnchorView(sugarmd1);
        //mediaController2.setAnchorView(sugarmd2);

        sugarmd1.start();
        //sugarmd2.start();

    }
}