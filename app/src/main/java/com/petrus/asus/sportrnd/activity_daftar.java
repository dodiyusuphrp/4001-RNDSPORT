package com.petrus.asus.sportrnd;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

///////////////////////
///////////////////////


public class activity_daftar extends AppCompatActivity {
    private EditText username, password, namalengkap, phone, mail;
    private Button btnsave;


    ///////////////////////
    private FirebaseAuth firebaseAuth;
    ///////////////////////

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

                /////////////
                registerUser(addmail, addpassword);
                /////////////
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();
    }

    ////////////////////////////////////////////////////////

    private void registerUser(String email, String password){

        final ProgressDialog progressDialog = new ProgressDialog(activity_daftar.this);
        progressDialog.setMessage("Mendaftar...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(activity_daftar.this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(activity_daftar.this, "Registrasi gagal", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
    ////////////////////////////////////////////////////////
}

