package com.example.android.developerquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton htmlButton;
    ImageButton androidButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        htmlButton = findViewById(R.id.html_quiz);
        androidButton = findViewById(R.id.android_quiz);
        htmlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent("android.intent.action.ACTIVITY1")); //if html imageButton (at the left) is clicked, Activity1 is started.

            }
        });
        androidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent("android.intent.action.ACTIVITY2")); //if android imageButton is clicked (at the right), Activity1 is started.

            }
        });

    }
}
