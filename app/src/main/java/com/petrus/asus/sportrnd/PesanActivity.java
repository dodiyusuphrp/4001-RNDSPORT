package com.petrus.asus.sportrnd;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class PesanActivity extends AppCompatActivity {
    private EditText edtnama, edtuangmuka, edtharga;
    private Button btnproses;
    private Button btnkonfirmasi;
    private Button btnout;
    private TextView txtpelanggan;
    private TextView tanggal;
    private TextView waktu;
    private TextView txtharga;
    private TextView txtuangbayar;
    private TextView txtname;
    private TextView txttanggal;
    private TextView txtwaktu;
    private TextView txttotal;
    private TextView txtkembalian;
    DatePickerDialog dpd;
    TimePickerDialog tpd;
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";
    private static final String PREF_FONT_LARGE = "font_large" ;
    private DatabaseReference mDatabase;


    String namapelanggan;
    String pilihtanggal;
    String pilihwaktu;
    String harga;
    String uangbayar;

    int h;
    int ub;

    @SuppressLint("WrongViewCast")
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
        setContentView(R.layout.activity_pesan);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtnama = (EditText) findViewById(R.id.namapelanggan);
        edtuangmuka = (EditText) findViewById(R.id.uangbayar);
        edtharga = (EditText) findViewById(R.id.harga);
        btnproses = (Button) findViewById(R.id.tombol1);
        btnkonfirmasi = (Button) findViewById(R.id.tombol2);
        btnout = (Button) findViewById(R.id.tombol3);
        txtpelanggan = (TextView) findViewById(R.id.namapelanggan);
        tanggal = (TextView) findViewById(R.id.pilihtanggal);
        waktu = (TextView) findViewById(R.id.pilihwaktu);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbayar = (TextView) findViewById(R.id.uangbayar);
        txtname = (TextView) findViewById(R.id.customer);
        txttanggal = (TextView) findViewById(R.id.date);
        txtwaktu = (TextView) findViewById(R.id.time);
        txttotal = (TextView) findViewById(R.id.total);
        txtkembalian = (TextView) findViewById(R.id.sisa);


        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namapelanggan = edtnama.getText().toString().trim();
                pilihtanggal = tanggal.getText().toString().trim();
                pilihwaktu = waktu.getText().toString().trim();
                harga = edtharga.getText().toString().trim();
                uangbayar = txtuangbayar.getText().toString().trim();
                h = Integer.parseInt(harga);
                ub = Integer.parseInt(uangbayar);
                double total = (h - ub);
                txtname.setText("Nama Pelanggan : " + namapelanggan );
                txttanggal.setText("Tanggal : " + pilihtanggal );
                txtwaktu.setText("Jam : " + pilihwaktu);
                txttotal.setText("Harga : " + h);
                txtkembalian.setText("Sisa Kembalian : " + total);
            }
        });

        //memberikan action pada tombol konfirmasi
        btnkonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transaksi transaksi = new Transaksi(namapelanggan, pilihtanggal, pilihwaktu, h, ub);
                mDatabase.child("transaksi").push().setValue(transaksi).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(PesanActivity.this, "Sukses menambahkan transaksi", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PesanActivity.this, activity_feedback.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });

        // memberikan action pada tombol keluar
        btnout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });
    }
    public void setTime(final View view) {
        tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                if (view.getId() == R.id.pilihwaktu) {
                    waktu.setText(i + ":" + i1);
                }
                tpd.dismiss();
            }
        }, Calendar.getInstance().get(Calendar.HOUR), Calendar.getInstance().get(Calendar.MINUTE), true);

        tpd.show();
    }

    public void setDate(final View view) {

        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                if (view.getId() == R.id.pilihtanggal) {
                    tanggal.setText(i2 + "/" + (i1 + 1) + "/" + i);
                }
                dpd.dismiss();
            }
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }
}
