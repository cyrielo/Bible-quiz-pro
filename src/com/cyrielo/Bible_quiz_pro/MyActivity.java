package com.cyrielo.Bible_quiz_pro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyActivity extends AbstractQuiz implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView homeMenu1 = (TextView) findViewById(R.id.homeMenu1);
        TextView homeMenu2 = (TextView) findViewById(R.id.homeMenu2);
        TextView homeMenu3 = (TextView) findViewById(R.id.homeMenu3);
        TextView homeMenu4 = (TextView) findViewById(R.id.homeMenu4);
        ImageView help = (ImageView) findViewById(R.id.help);
        ImageView shareApp = (ImageView) findViewById(R.id.shareApp);
        ImageView about = (ImageView) findViewById(R.id.about);


        homeMenu1.setOnClickListener(this);
        homeMenu2.setOnClickListener(this);
        homeMenu3.setOnClickListener(this);
        homeMenu4.setOnClickListener(this);
        help.setOnClickListener(this);
        shareApp.setOnClickListener(this);
        about.setOnClickListener(this);

        SharedPreferences levels = getSharedPreferences("LEVELS", 0);
        SharedPreferences.Editor editor = levels.edit();
        editor.putString("All_levels", this.getAllLevels());


    }

    public void onClick(View v) {
        this.playAudio(R.raw.tapanywhere);
        Intent intent;
        switch (v.getId()) {
            case R.id.homeMenu1:
                this.resumeQuizProgress();
                break;
            case R.id.homeMenu2:
                intent = new Intent(this, LevelChooser.class);
                startActivity(intent);
                break;
            case R.id.homeMenu3:
                this.rateApp();
                break;
            case R.id.homeMenu4:
                intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;

            case R.id.help:
                intent = new Intent(this, Help.class);
                startActivity(intent);
                break;

            case R.id.shareApp:
                this.shareApp();
                break;
            case R.id.about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;

        }

    }

    public String getAllLevels() {
        StringBuilder levels = new StringBuilder();

        levels.append(getResources().getString(R.string.first_activity));
        levels.append("," + getResources().getString(R.string.second_activity));
        levels.append("," + getResources().getString(R.string.third_activity));
        levels.append("," + getResources().getString(R.string.fourth_activity));
        levels.append("," + getResources().getString(R.string.fifth_activity));
        levels.append("," + getResources().getString(R.string.sixth_activity));
        levels.append("," + getResources().getString(R.string.seventh_activity));
        levels.append("," + getResources().getString(R.string.eighth_activity));
        levels.append("," + getResources().getString(R.string.ninth_activity));
        levels.append("," + getResources().getString(R.string.tenth_activity));

        return levels.toString();
    }

    public void resumeQuizProgress() {
        SharedPreferences levels = getSharedPreferences("LEVELS", 0);
        String completed_levelsString = levels.getString("completed_level", "NONE");
        String[] completed_levelsArray = completed_levelsString.split(";");
        for (int i = 0; i < completed_levelsArray.length; i++) {
            if (i == completed_levelsArray.length - 1) {
                if (!completed_levelsArray[i].equalsIgnoreCase("NON") &&
                        !completed_levelsArray[i].equalsIgnoreCase("End")) {
                    this.startQuiz(completed_levelsArray[i]);
                }
            }
        }
    }

    public void startQuiz(String selectedLevel) {
        Intent intent = new Intent(this, QuizQuestionAndAnswers.class);
        if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.first_activity))) {
            intent.putExtra("SelectedLevel", R.string.first_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.second_activity))) {
            intent.putExtra("SelectedLevel", R.string.second_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.third_activity))) {
            intent.putExtra("SelectedLevel", R.string.third_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.fourth_activity))) {
            intent.putExtra("SelectedLevel", R.string.fourth_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.fifth_activity))) {
            intent.putExtra("SelectedLevel", R.string.fifth_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.sixth_activity))) {
            intent.putExtra("SelectedLevel", R.string.sixth_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.seventh_activity))) {
            intent.putExtra("SelectedLevel", R.string.seventh_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.eighth_activity))) {
            intent.putExtra("SelectedLevel", R.string.eighth_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.ninth_activity))) {
            intent.putExtra("SelectedLevel", R.string.ninth_activity);
            startActivity(intent);
        } else if (selectedLevel.equalsIgnoreCase(getResources().getString(R.string.tenth_activity))) {
            intent.putExtra("SelectedLevel", R.string.tenth_activity);
            startActivity(intent);
        } else
            intent.putExtra("SelectedLevel", R.string.first_activity);
        startActivity(intent);
    }
}
