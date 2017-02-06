package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Ivars on 2017.02.02..
 */

public class ResultActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Bundle extras = getIntent().getExtras();
        int correctAnswers = extras.getInt("correctAnswers");

        RatingBar testRating = (RatingBar)findViewById(R.id.rating);
        testRating.setRating(correctAnswers);

        ImageView faceImage = (ImageView)findViewById(R.id.face);
        if(correctAnswers>2) {
            faceImage.setImageResource(R.drawable.happy);
        }
        else {
            faceImage.setImageResource(R.drawable.sad);
        }

        TextView resultMessage = (TextView)findViewById(R.id.you_got_text);
        resultMessage.setText(getString(R.string.you_got)+" "+correctAnswers+" "+getString(R.string.out_of)+" 5");

        Button goToMainMenu = (Button)findViewById(R.id.go_to_main_menu);
        goToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(mainMenuIntent);
            }
        });

    }
}
