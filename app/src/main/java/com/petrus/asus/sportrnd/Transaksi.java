package com.petrus.asus.sportrnd;

public class Transaksi {
    private String nama;
    private String tanggal;
    private String waktu;
    private int harga;
    private int bayar;

    public Transaksi(String nama, String tanggal, String waktu, int harga, int bayar) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.harga = harga;
        this.bayar = bayar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }
}
