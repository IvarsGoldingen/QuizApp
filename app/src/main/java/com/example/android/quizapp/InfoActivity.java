package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ivars on 2017.01.31..
 */

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backActivity = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(backActivity);
            }
        });

        Button moreInfoButton = (Button) findViewById(R.id.more_info_button);
        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(getResources().getString(R.string.wiki));
                Intent moreInfoIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (moreInfoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(moreInfoIntent);
                }
            }
        });
    }
}
