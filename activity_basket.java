package com.petrus.asus.sportrnd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_basket extends AppCompatActivity {
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";
    private static final String PREF_FONT_LARGE = "font_large" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean theme = preferences.getBoolean(PREF_DARK_THEME, false);
        boolean font = preferences.getBoolean(PREF_FONT_LARGE, false);
        if (theme && font) {
            setTheme(R.style.AppTheme_Dark_FontLarge);
        } else if (theme) {
            setTheme(R.style.AppTheme_Dark_FontNormal);
        } else if (font) {
            setTheme(R.style.AppTheme_FontLarge);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
    }

    public void reksana(View view) {
        Intent intent = new Intent(activity_basket.this, PesanActivity.class);
        startActivity(intent);
    }

    public void saksama(View view) {
        Intent intent = new Intent(activity_basket.this, PesanActivity.class);
        startActivity(intent);
    }

    public void antabaru(View view) {
        Intent intent = new Intent(activity_basket.this, PesanActivity.class);
        startActivity(intent);
    }
}