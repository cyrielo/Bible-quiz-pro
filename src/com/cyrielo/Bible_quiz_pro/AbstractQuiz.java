package com.cyrielo.Bible_quiz_pro;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cyrielo on 2/6/2015.
 */


public class AbstractQuiz extends Activity implements QuizInterface {
    public int questionId = 1;
    public int correctAnswerCount = 0,
            wrongAnswerCount = 0, nextLevelId = 0;
    public static final String saveQuestionId = "questionId";
    public static final String saveCorrectAnswerCount = "correctAnswerCount";
    public static final String saveWrongAnswerCount = "wrongAnswerCount";
    public static final String saveRandomQuestionKeys = "RandomQuestionKeys";
    public int[] randomQuestionKeys;

    public String[] questions, answers;


    public String[][] options;
    public Button optionA, optionB, optionC, optionD;
    public TextView questionNumber, questionText;
    public String levelName, nextLevelName;


    public void setNextQuestion() {
        this.questionNumber.setText(questionId + "/" + this.questions.length);
        int randomKey = this.randomQuestionKeys[this.questionId - 1];
        this.questionText.setText(this.questions[randomKey]);

        for (int i = 0; i < this.options[randomKey].length; i++) {
            if (i == 0)
                this.optionA.setText(this.options[randomKey][i]);
            else if (i == 1)
                this.optionB.setText(this.options[randomKey][i]);
            else if (i == 2)
                this.optionC.setText(this.options[randomKey][i]);
            else if (i == 3)
                this.optionD.setText(this.options[randomKey][i]);
        }
    }

    public void checkAnswer(String user_answer) {

        int randomKey = this.randomQuestionKeys[this.questionId - 1];
        String computer_answer = this.answers[randomKey];
        if (user_answer.equalsIgnoreCase(computer_answer)) {
            this.correctAnswerCount++;
            this.playAudio(R.raw.quiztrue);
        } else {
            this.wrongAnswerCount++;
            this.playAudio(R.raw.quizwrong);
        }

        this.questionId++;
        if (this.questionId > this.questions.length)
            this.endQuiz(this.levelName, this.nextLevelId);
        else {
            Log.d("quiz", "computer_answer is " + computer_answer);
            Log.d("quiz", "Question id is " + this.questionId);
            Log.d("quiz", "Question length is " + this.questions.length);

            Log.d("quiz", "Number of correct answers are " + this.correctAnswerCount);
            Log.d("quiz", "Number of wrong answers are " + this.wrongAnswerCount);

            this.setNextQuestion();
            Log.d("quiz", "Continue playing");
        }

    }

    public void endQuiz(String levelName, int nextLevel) {
        String total_scores = this.correctAnswerCount + "/" + this.questions.length;
        Intent viewScore = new Intent(this, Scores.class);
        viewScore.putExtra("correctAnswerCount", this.correctAnswerCount);
        viewScore.putExtra("resultTitle", levelName + " level results");
        viewScore.putExtra("wrongAnswerCount", this.wrongAnswerCount);
        viewScore.putExtra("total_scores", total_scores);
        viewScore.putExtra("nextLevel", nextLevel);
        boolean Completed = false;
        boolean alreadyExist = false;
        if (this.correctAnswerCount >= (this.correctAnswerCount + this.wrongAnswerCount) - 4) {
            Completed = true;
            SharedPreferences levels = getSharedPreferences("LEVELS", 0);
            String completed_levelsString = levels.getString("completed_level", "NONE");
            String[] completed_levelsArray = completed_levelsString.split(";");
            for (int i = 0; i < completed_levelsArray.length; i++) {
                if (completed_levelsArray[i].contains(this.nextLevelName)) {
                    alreadyExist = true;
                    break;
                }
            }
            if (Completed && !alreadyExist) {
                SharedPreferences.Editor editor = levels.edit();
                String new_value = completed_levelsString + ";" + this.nextLevelName;
                editor.putString("completed_level", new_value);
                editor.commit();
            }
        }
        startActivity(viewScore);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt(this.saveCorrectAnswerCount, this.correctAnswerCount);
        savedInstanceState.putInt(this.saveWrongAnswerCount, this.wrongAnswerCount);
        savedInstanceState.putInt(this.saveQuestionId, this.questionId);
        savedInstanceState.putIntArray(this.saveRandomQuestionKeys, this.randomQuestionKeys);
        super.onSaveInstanceState(savedInstanceState);
        Log.d("cyrielo", "Activity value has been saved");
    }

    public static int[] generateRandomKeys(int size) {
        int[] keys = new int[size];
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (true) {
            int rand = random.nextInt(size);
            if (!arrayList.contains(rand)) {
                arrayList.add(rand);
                if (arrayList.size() == size)
                    break;
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            keys[i] = arrayList.get(i);
        }
        return keys;
    }

    public void playAudio(int resId) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        boolean enableSound = settings.getBoolean("enableSound", true);
        if (enableSound) {
            MediaPlayer player = MediaPlayer.create(this, resId);
            player.start();
        }


    }

    public void shareApp() {
        String appLink = "http://play.google.com/store/apps/details?id=" + getPackageName();
        String mimeType = "text/plain";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_TEXT, "Hey download this awesome  bible quiz app for free!\n" + appLink);
        share.setType(mimeType);

        startActivity(share);
    }

    public void rateApp() {
        String playStoreLink = "market://details?id=" + getPackageName();
        Uri uriLink = Uri.parse(playStoreLink);
        Intent androidMarket = new Intent(Intent.ACTION_VIEW, uriLink);

        try {
            startActivity(androidMarket);
        } catch (ActivityNotFoundException e) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setCancelable(true);
            alertBuilder.setMessage("Sorry unable to launch Google playstore!");
            alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alert = alertBuilder.create();
            alert.show();
        }
    }
}

