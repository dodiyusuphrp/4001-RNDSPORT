package com.petrus.asus.sportrnd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

///////////////////////
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
///////////////////////

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    private Button btnLogin;
    EditText username;
    private EditText password;
    public static final String user="rndsportrnd";
    String namaNya;
    ///////////////////////
    private FirebaseAuth firebaseAuth;
    /////////////////////////
    ////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        ///////////////////////
        firebaseAuth = FirebaseAuth.getInstance();
        ///////////////////////
        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaNya = username.getText().toString();
                String passwordNya = password.getText().toString();

                Log.d("USERNAME", namaNya);
                Log.d("PASSWORD", passwordNya);


                ///////////////////////
                login(namaNya, passwordNya);
                ///////////////////////
//                if(namaNya.equals("rnd")&& passwordNya.equals("rnd")){
//                    Intent next = new Intent(MainActivity.this, activity_halamanutama.class);
//                    startActivity(next);
//                    finish();
//                } else if(namaNya.matches("")|| passwordNya.matches("")){
//                    Toast.makeText(getApplication(),"Usernmae atau password tidak boleh kosong", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(getApplication(), "Gagal Login, Username atau password Salah", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }

    public void tvOnclik(View view) {
        Intent intent = new Intent(MainActivity.this, activity_daftar.class);
        startActivity(intent);
    }
    ///////////////////////
    private void login(String email, String password){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Login...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        task.addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                e.printStackTrace();

                            }
                        });
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Login sukses", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this,activity_menu.class);
                            i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        } else {
//                            task.getResult().toString();
                            Toast.makeText(MainActivity.this, "Gagal login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void forget(View view) {
        Intent intent = new Intent(MainActivity.this, activity_forgetpass.class);
        startActivity(intent);
    }

    ///////////////////////
}
