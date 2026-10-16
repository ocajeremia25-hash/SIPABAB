
package model;

import java.io.Serializable;

// Bantuan AI digunakan untuk menambahkan Serializable
// dan serialVersionUID sesuai Job Sheet 7 bagian E.3.
// Method laporanRingkas tetap dipertahankan dari Job Sheet 6.

public abstract class Alat implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String kodeAlat;
    protected String nama;
    protected int tahunPerolehan;

    public Alat(String kodeAlat, String nama, int tahunPerolehan) {
        this.kodeAlat = kodeAlat;
        this.nama = nama;
        this.tahunPerolehan = tahunPerolehan;
    }

    public String deskripsi() {
        return kodeAlat + " - " + nama + " (" + tahunPerolehan + ")";
    }

    public abstract boolean siapDipinjam();

    public String getNama() {
        return nama;
    }

    public String getKode() {
        return kodeAlat;
    }

    public int getTahun() {
        return tahunPerolehan;
    }

    public String laporanRingkas() {
        String status = siapDipinjam() ? "SIAP" : "TIDAK SIAP";
        return String.format("%-8s %-22s %s", kodeAlat, nama, status);
    }
}
