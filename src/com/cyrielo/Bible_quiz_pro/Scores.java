package com.cyrielo.Bible_quiz_pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cyrielo on 2/5/2015.
 */
public class Scores extends AbstractQuiz {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);

        String resultTitle = getIntent().getExtras().getString("resultTitle");
        int correctAnswerCount = getIntent().getExtras().getInt("correctAnswerCount");
        int wrongAnswerCount = getIntent().getExtras().getInt("wrongAnswerCount");
        String total_scores = getIntent().getExtras().getString("total_scores");
        final int nextLevel = getIntent().getExtras().getInt("nextLevel");

        TextView resultTitleBar = (TextView) findViewById(R.id.AppTitle);
        TextView correctAnswerView = (TextView) findViewById(R.id.correctAnswerCount);
        TextView wrongAnswerView = (TextView) findViewById(R.id.wrongAnswerCount);
        TextView total_scoresView = (TextView) findViewById(R.id.total_scores);

        resultTitleBar.setText(resultTitle);
        correctAnswerView.setText("Number of correct answers: " + correctAnswerCount);
        wrongAnswerView.setText("Number of wrong answers: " + wrongAnswerCount);
        total_scoresView.setText("Total scores: " + total_scores);

        Button okButton = (Button) findViewById(R.id.okButton);
        if (nextLevel != 0 && correctAnswerCount >= (correctAnswerCount + wrongAnswerCount) - 4) {
            if (nextLevel != 0) {
                okButton.setText("Next level");
                this.playAudio(R.raw.applause);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mainIntent = new Intent(Scores.this, QuizQuestionAndAnswers.class);
                        mainIntent.putExtra("SelectedLevel", nextLevel);
                        startActivity(mainIntent);
                    }
                });
            } else {
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mainIntent = new Intent(Scores.this, MyActivity.class);
                        startActivity(mainIntent);
                    }
                });
            }


        } else {
            this.playAudio(R.raw.disappointed);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainIntent = new Intent(Scores.this, MyActivity.class);
                    startActivity(mainIntent);
                }
            });
        }

    }
}

