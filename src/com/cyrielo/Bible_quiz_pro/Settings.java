package com.cyrielo.Bible_quiz_pro;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by cyrielo on 2/19/2015.
 */
public class Settings extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);


    }
}
