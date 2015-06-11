package com.cyrielo.Bible_quiz_pro;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by cyrielo on 2/19/2015.
 */
public class About extends AbstractQuiz {
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.about);

        ImageView backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
