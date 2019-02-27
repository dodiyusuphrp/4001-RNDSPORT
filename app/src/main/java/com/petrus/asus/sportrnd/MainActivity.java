package com.petrus.asus.sportrnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaNya = username.getText().toString();
                String passwordNya = password.getText().toString();

                if(namaNya.equals("rnd")&& passwordNya.equals("rnd")){
                    Intent next = new Intent(MainActivity.this, activity_halamanutama.class);
                    startActivity(next);
                    finish();
                } else if(namaNya.matches("")|| passwordNya.matches("")){
                    Toast.makeText(getApplication(),"Usernmae atau password tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplication(), "Gagal Login, Username atau password Salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void tvOnclik(View view) {
        Intent intent = new Intent(MainActivity.this, activity_daftar.class);
        startActivity(intent);
    }
}
