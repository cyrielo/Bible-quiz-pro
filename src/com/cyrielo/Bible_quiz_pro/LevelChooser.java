package com.cyrielo.Bible_quiz_pro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelChooser extends AbstractQuiz implements View.OnClickListener {
    TextView rookieLevel,
            Enthusiast,
            Intermediate,
            Pro,
            Expert,
            Genius,
            Master,
            Grand_master,
            Legend,
            Out_of_this_world;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_chooser);

        this.rookieLevel = (TextView) findViewById(R.id.firstActivityButton);
        this.Enthusiast = (TextView) findViewById(R.id.secondActivityButton);
        this.Intermediate = (TextView) findViewById(R.id.thirdActivityButton);
        this.Pro = (TextView) findViewById(R.id.fourthActivityButton);
        this.Expert = (TextView) findViewById(R.id.fifthActivityButton);
        this.Genius = (TextView) findViewById(R.id.sixthActivityButton);
        this.Master = (TextView) findViewById(R.id.seventhActivityButton);
        this.Grand_master = (TextView) findViewById(R.id.eighthActivityButton);
        this.Legend = (TextView) findViewById(R.id.ninthActivityButton);
        this.Out_of_this_world = (TextView) findViewById(R.id.tenthActivityButton);


        this.rookieLevel.setOnClickListener(this);
        this.Enthusiast.setOnClickListener(this);
        this.Intermediate.setOnClickListener(this);
        this.Pro.setOnClickListener(this);
        this.Expert.setOnClickListener(this);
        this.Genius.setOnClickListener(this);
        this.Master.setOnClickListener(this);
        this.Grand_master.setOnClickListener(this);
        this.Legend.setOnClickListener(this);
        this.Out_of_this_world.setOnClickListener(this);

        this.setColorForActivatedLevel();

        ImageView backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, QuizQuestionAndAnswers.class);
        switch (v.getId()) {
            case R.id.firstActivityButton:
                intent.putExtra("SelectedLevel", R.string.first_activity);
                startActivity(intent);
                break;

            case R.id.secondActivityButton:
                intent.putExtra("SelectedLevel", R.string.second_activity);
                if (this.hasAccess(getResources().getString(R.string.second_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.thirdActivityButton:
                intent.putExtra("SelectedLevel", R.string.third_activity);
                if (this.hasAccess(getResources().getString(R.string.third_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.fourthActivityButton:
                intent.putExtra("SelectedLevel", R.string.fourth_activity);
                if (this.hasAccess(getResources().getString(R.string.fourth_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.fifthActivityButton:
                intent.putExtra("SelectedLevel", R.string.fifth_activity);
                if (this.hasAccess(getResources().getString(R.string.fifth_activity)))
                    startActivity(intent);
                break;

            case R.id.sixthActivityButton:
                intent.putExtra("SelectedLevel", R.string.sixth_activity);
                if (this.hasAccess(getResources().getString(R.string.sixth_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.seventhActivityButton:
                intent.putExtra("SelectedLevel", R.string.seventh_activity);
                if (this.hasAccess(getResources().getString(R.string.seventh_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.eighthActivityButton:
                intent.putExtra("SelectedLevel", R.string.eighth_activity);
                if (this.hasAccess(getResources().getString(R.string.eighth_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.ninthActivityButton:
                intent.putExtra("SelectedLevel", R.string.ninth_activity);
                if (this.hasAccess(getResources().getString(R.string.ninth_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;

            case R.id.tenthActivityButton:
                intent.putExtra("SelectedLevel", R.string.tenth_activity);
                if (this.hasAccess(getResources().getString(R.string.tenth_activity)))
                    startActivity(intent);
                else
                    this.playAudio(R.raw.soundclickoff);
                break;
        }
    }

    public boolean hasAccess(String x) {
        boolean hasAccess = false;
        SharedPreferences levels = getSharedPreferences("LEVELS", 0);
        String completed_levelsString = levels.getString("completed_level", "NONE");
        String[] completed_levelsArray = completed_levelsString.split(";");
        for (String levelName : completed_levelsArray) {
            if (levelName.contains(x)) {
                hasAccess = true;
                break;
            }
        }

        return hasAccess;
    }

    public void setColorForActivatedLevel() {

        if (this.hasAccess(getResources().getString(R.string.second_activity))) {
            this.Enthusiast.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.secondActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.third_activity))) {
            this.Intermediate.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.thirdActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.fourth_activity))) {
            this.Pro.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.fourthActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.fifth_activity))) {
            this.Expert.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.fifthActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.sixth_activity))) {
            this.Genius.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.sixthActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.seventh_activity))) {
            this.Master.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.seventhActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.eighth_activity))) {
            this.Grand_master.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.eightActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.ninth_activity))) {
            this.Legend.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.ninthActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
        if (this.hasAccess(getResources().getString(R.string.tenth_activity))) {
            this.Out_of_this_world.setBackgroundResource(R.drawable.ic_list_active_background);
            ImageView padLock = (ImageView) findViewById(R.id.tenthActivityButtonKey);
            padLock.setVisibility(View.GONE);
        }
    }
}
