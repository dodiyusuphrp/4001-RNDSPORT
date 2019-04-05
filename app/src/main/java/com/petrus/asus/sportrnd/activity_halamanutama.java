package com.petrus.asus.sportrnd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class activity_halamanutama extends AppCompatActivity {
    Button bu=null;
    Button bu2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanutama);

        bu=(Button)findViewById(R.id.button2);
        bu2=(Button)findViewById(R.id.button3);
    }
    //////untuk logout///////
    public  void logout(View view){
        Intent intent = new Intent(this,  MainActivity.class);
        startActivity(intent);
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view){
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        ////////////////////////////////////////
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        ///////////////////////////////
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

    /////menu dasboard/////
    public void pilihfootball(View view) {
        Intent intent = new Intent(activity_halamanutama.this, activity_lapangan.class);
        startActivity(intent);
    }

    public void pilihbasket(View view) {
        Intent intent = new Intent(activity_halamanutama.this, activity_lapangan.class);
        startActivity(intent);
    }

    public void pilihtennis(View view) {
        Intent intent = new Intent(activity_halamanutama.this, activity_lapangan.class);
        startActivity(intent);
    }

    public void pilihbdmntn(View view) {
        Intent intent = new Intent(activity_halamanutama.this, activity_lapangan.class);
        startActivity(intent);
    }
}
