package com.petrus.asus.sportrnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class activity_halamanutama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanutama);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        ////////////////////////////////////////
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //////////////////////////////
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this,  Aboutactivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.help) {
            Intent intent = new Intent(this,  activity_help.class);
            startActivity(intent);
        }

        return true;
    }
}
