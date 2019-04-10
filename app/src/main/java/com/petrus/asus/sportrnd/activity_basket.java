package com.petrus.asus.sportrnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_basket extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
    }
    public void rajawali(View view) {
        Intent intent = new Intent(activity_basket.this, activity_halamanutama.class);
        startActivity(intent);
    }

    public void reksana(View view) {
    }

    public void saksama(View view) {
    }

    public void antabaru(View view) {
    }
}