package com.petrus.asus.sportrnd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";
    private static final String PREF_FONT_LARGE = "font_large" ;
    Button bu = null;
    Button bu2 = null;
    TextView tvEmail ;

///////////////////////////////////////////////////////////////////////////////////////////////

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
        setContentView(R.layout.activity_menu);

        ///tvEmail = (TextView) findViewById(R.id.welcomeuser);
        ///Intent i = getIntent();
        ///tvEmail.setText(i.getExtras().getString("Email"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bu = (Button) findViewById(R.id.logout);

    }
    //////tampilan layar
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getApplicationContext(),"Portait mode",Toast.LENGTH_SHORT).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getApplicationContext(),"Landscap mode",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //////untuk logout///////
    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view) {
        finish();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, Aboutactivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.help) {
            Intent intent = new Intent(this, activity_help.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_lokasi) {
            Intent intent = new Intent(activity_menu.this, MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(activity_menu.this, activity_setting.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void pilihfootball(View view) {
        Intent intent = new Intent(activity_menu.this, activity_football.class);
        startActivity(intent);
    }

    public void pilihbasket(View view) {
        Intent intent = new Intent(activity_menu.this, activity_basket.class);
        startActivity(intent);
    }

    public void pilihtennis(View view) {
        Intent intent = new Intent(activity_menu.this, activity_lapangan.class);
        startActivity(intent);
    }

    public void pilihbdmntn(View view) {
        Intent intent = new Intent(activity_menu.this, activity_lapangan.class);
        startActivity(intent);
    }
}