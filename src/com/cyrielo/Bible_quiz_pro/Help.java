package com.cyrielo.Bible_quiz_pro;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by cyrielo on 2/19/2015.
 */
public class Help extends AbstractQuiz {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        ImageView backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
