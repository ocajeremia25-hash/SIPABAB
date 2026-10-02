package model;

// Bantuan AI digunakan untuk membantu menambahkan method laporanRingkas
// agar pemrosesan status alat dapat menggunakan dynamic binding.

public abstract class Alat {

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

    // Getter untuk nama alat
    public String getNama() {
        return nama;
    }

    // Getter untuk kode alat (dibutuhkan oleh InventarisLab)
    public String getKode() {
        return kodeAlat;
    }

    // Getter untuk tahun perolehan (dibutuhkan oleh UrutTahun)
    public int getTahun() {
        return tahunPerolehan;
    }

    public String laporanRingkas() {
        String status = siapDipinjam() ? "SIAP" : "TIDAK SIAP";
        return String.format("%-8s %-22s %s", kodeAlat, nama, status);
    }
}