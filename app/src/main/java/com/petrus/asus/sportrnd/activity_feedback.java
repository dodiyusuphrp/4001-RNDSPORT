package com.petrus.asus.sportrnd;

import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_feedback extends AppCompatActivity {
    EditText namedata,emaildata,messagedata;
    Button send_feedback,feedback_detail;
    private DatabaseReference mDatabase;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        namedata = findViewById(R.id.namedata);
        emaildata = findViewById(R.id.emaildata);
        messagedata = findViewById(R.id.messagedata);

        send_feedback = findViewById(R.id.send_feedback);
        feedback_detail = findViewById(R.id.feedback_detail);
        Firebase.setAndroidContext(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String UniqueID =
                Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
        firebase= new Firebase("https://sportrnd-83f09.firebaseio.com"+UniqueID);
        send_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback_detail.setEnabled(true);
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();

                Feedback feedback = new Feedback(name, email, message);
                mDatabase.child("feedback").push().setValue(feedback).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(activity_feedback.this, "Sukses menambahkan feedback", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

//            Firebase child_name = firebase.child("Name");
//            child_name.setValue(name);
//
//            if (name.isEmpty()){
//                namedata.setError("This field!");
//                send_feedback.setEnabled(false);
//            }else{
//                namedata.setError(null);
//                send_feedback.setEnabled(true);
//            }
//
//            Firebase child_email = firebase.child("Email");
//            child_email.setValue(email);
//            if (email.isEmpty()){
//                emaildata.setError("This field!");
//                send_feedback.setEnabled(false);
//            }else{
//                emaildata.setError(null);
//                send_feedback.setEnabled(true);
//            }
//            Firebase child_message = firebase.child("Message");
//            child_message.setValue(message);
//            if (message.isEmpty()){
//                messagedata.setError("This field!");
//                send_feedback.setEnabled(false);
//            }else{
//                messagedata.setError(null);
//                send_feedback.setEnabled(true);
//            }
//            Toast.makeText(activity_feedback.this,"data terkirim",Toast.LENGTH_SHORT).show();
                feedback_detail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(activity_feedback.this)
                                .setTitle("send Detail:")
                                .setMessage("Name=" + name + "\n\nEmail "+email+"\n\nMessage="+message)
                                .show();
                    }
                });
            }
        });
    }
}
