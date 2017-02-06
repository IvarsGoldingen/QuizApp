package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button infoButton = (Button)findViewById(R.id.main_menu_info);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(infoIntent);
            }
        });

        Button testButton = (Button)findViewById(R.id.main_menu_test);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testIntent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(testIntent);
            }
        });

    }
}
