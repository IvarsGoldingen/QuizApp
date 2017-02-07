package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Ivars on 2017.01.31..
 */

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        ImageButton seeResult = (ImageButton)findViewById(R.id.chicken_button);
        seeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean[] questionArray = new boolean[5];

                Intent resultIntent = new Intent(TestActivity.this, ResultActivity.class);
                int correctAnswers=0;
                if(((RadioButton) findViewById(R.id.question1_answer)).isChecked()){
                    correctAnswers+=1;
                    questionArray[0]=true;
                }
                else {
                    questionArray[0]=false;
                }
                if(((RadioButton) findViewById(R.id.question2_answer)).isChecked()){
                    correctAnswers+=1;
                    questionArray[1]=true;
                }
                else {
                    questionArray[1]=false;
                }
                String answer3=((EditText)findViewById(R.id.question3_answer)).getText().toString();
                if(answer3.equals(getResources().getString(R.string.acceptable_answer1))||answer3.equals(getResources().getString(R.string.acceptable_answer2))||answer3.equals(getResources().getString(R.string.acceptable_answer3))){
                    correctAnswers+=1;
                    questionArray[2]=true;
                }
                else {
                    questionArray[2]=false;
                }

                if(((CheckBox)findViewById(R.id.question4_answer1)).isChecked()&&((CheckBox)findViewById(R.id.question4_answer3)).isChecked()&&!((CheckBox)findViewById(R.id.question4_answer2)).isChecked()){
                    correctAnswers+=1;
                    questionArray[3]=true;
                }
                else {
                    questionArray[3]=false;
                }
                if(((RadioButton)findViewById(R.id.question5_answer)).isChecked()){
                    correctAnswers+=1;
                    questionArray[4]=true;
                }
                else {
                    questionArray[4]=false;
                }
                resultIntent.putExtra("questionArray", questionArray);
                resultIntent.putExtra("correctAnswers",correctAnswers);
                startActivity(resultIntent);
            }
        });

        RadioButton bestAnswer = (RadioButton)findViewById(R.id.best_answer);
        bestAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Great answer :)\nProbably not right";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
