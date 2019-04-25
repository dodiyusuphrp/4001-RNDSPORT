package com.petrus.asus.sportrnd;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class PesanActivity extends AppCompatActivity {
    private EditText edtnama, edtuangmuka, edtharga;
    private Button btnproses;
    private TextView txtnama;
    TextView pilihtanggal;
    TextView pilihwaktu;
    private TextView txtuangmuka;
    private TextView txtharga;
    DatePickerDialog dpd;
    TimePickerDialog tpd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        btnproses = (Button) findViewById(R.id.tombol1);
        edtnama = (EditText) findViewById(R.id.edtnama);
        edtuangmuka = (EditText) findViewById(R.id.uangmuka);
        edtharga = (EditText) findViewById(R.id.harga);
        txtnama = (TextView) findViewById(R.id.txtnama);
        pilihtanggal = (TextView) findViewById(R.id.pilihtanggal);
        pilihwaktu = (TextView) findViewById(R.id.pilihwaktu);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangmuka = (TextView) findViewById(R.id.uangmuka);


        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnama.getText().toString().trim();
                String uangmuka = edtuangmuka.getText().toString().trim();
                String tanggal= pilihtanggal.getText().toString().trim();
                String waktu= pilihwaktu.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();

                double um = Double.parseDouble(uangmuka);
                double h = Double.parseDouble(harga);
                double total = (h - um);

            }
        });

    }

    public void setTime(final View view) {
        tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                if (view.getId() == R.id.pilihwaktu) {
                    pilihwaktu.setText(i + ":" + i1);
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
                    pilihtanggal.setText(i2 + "/" + (i1 + 1) + "/" + i);
                }
                dpd.dismiss();
            }
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }
}
