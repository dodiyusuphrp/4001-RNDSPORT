package com.petrus.asus.sportrnd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_daftar extends AppCompatActivity {
    private EditText username, password, namalengkap, phone, mail;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        username = findViewById(R.id.addusername);
        password = findViewById(R.id.addpassword);
        namalengkap = findViewById(R.id.addnamalengkap);
        phone = findViewById(R.id.addphone);
        mail = findViewById(R.id.addmail);
        btnsave = findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addusername = username.getText().toString();
                String addpassword = password.getText().toString();
                String addnamalengkap = namalengkap.getText().toString();
                String addphone = phone.getText().toString();
                String addmail = mail.getText().toString();

            }
        });

    }

}

