package com.petrus.asus.sportrnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_football extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
    }
    public void rajawali(View view) {
        Intent intent = new Intent(activity_football.this, activity_lapangan.class);
        startActivity(intent);
    }
}
