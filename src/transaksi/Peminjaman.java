package transaksi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Alat;
import model.Mahasiswa;
import model.Petugas;

public class Peminjaman {

    private final String nomorPeminjaman;
    private final LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    // ASOSIASI: mahasiswa dan petugas hidup mandiri, hanya dirujuk
    private final Mahasiswa peminjam;
    private final Petugas penyetuju;

    // KOMPOSISI: detail dibuat di dalam kelas Peminjaman
    private final List<DetailPeminjaman> detail = new ArrayList<>();

    public Peminjaman(
            String nomorPeminjaman,
            Mahasiswa peminjam,
            Petugas penyetuju) {

        this.nomorPeminjaman = nomorPeminjaman;
        this.peminjam = peminjam;
        this.penyetuju = penyetuju;
        this.tanggalPinjam = LocalDate.now();
    }

    public void tambahDetail(Alat alat, int jumlah) {
        detail.add(new DetailPeminjaman(alat, jumlah));
    }

    public List<DetailPeminjaman> getDetail() {
        return Collections.unmodifiableList(detail);
    }

    public int totalItem() {
        int total = 0;

        for (DetailPeminjaman d : detail) {
            total += d.getJumlah();
        }

        return total;
    }

    public String getNomorPeminjaman() {
        return nomorPeminjaman;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public Mahasiswa getPeminjam() {
        return peminjam;
    }

    public Petugas getPenyetuju() {
        return penyetuju;
    }

    public void kembalikan() {
        tanggalKembali = LocalDate.now();
    }

    public long hitungHariTerlambat() {
        LocalDate batasKembali = tanggalPinjam.plusDays(7);

        LocalDate tanggalHitung;

        if (tanggalKembali != null) {
            tanggalHitung = tanggalKembali;
        } else {
            tanggalHitung = LocalDate.now();
        }

        if (tanggalHitung.isAfter(batasKembali)) {
            return ChronoUnit.DAYS.between(
                    batasKembali,
                    tanggalHitung
            );
        }

        return 0;
    }
}