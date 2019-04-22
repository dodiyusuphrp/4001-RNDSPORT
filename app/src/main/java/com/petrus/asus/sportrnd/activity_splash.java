package com.petrus.asus.sportrnd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class activity_splash extends AppCompatActivity {

    ProgressBar progressBar;
    Handler handler = new Handler();

    private int progressStatus = 0;
    private final int SLEEP = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 250)
                {
                    progressStatus += 1;
                    handler.post(new Runnable()
                    {
                        public void run()
                        {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try
                    {
                        Thread.sleep(SLEEP);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                if (progressStatus==250)
                {
                    Intent i = new Intent(activity_splash.this, MainActivity.class);
                    startActivity(i);
                }
            }
        }).start();
    }
}
