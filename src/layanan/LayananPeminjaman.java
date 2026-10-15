
package layanan;

import eksepsi.AlatBelumSiapException;
import eksepsi.AlatSedangDipinjamException;
import eksepsi.DataTidakValidException;
import eksepsi.KuotaPeminjamanHabisException;
import model.Alat;
import model.Mahasiswa;
import model.Petugas;
import transaksi.Peminjaman;

// Atribusi AI: bantuan AI digunakan untuk menyusun layanan
// peminjaman dan validasi masukan sesuai Job Sheet 6.

public class LayananPeminjaman {

    private final int kuotaMaksimal;

    public LayananPeminjaman(int kuotaMaksimal) {
        this.kuotaMaksimal = kuotaMaksimal;
    }

    public Peminjaman buatPeminjaman(
            String nomorPeminjaman,
            Mahasiswa peminjam,
            Petugas penyetuju)
            throws DataTidakValidException {

        if (nomorPeminjaman == null
                || nomorPeminjaman.trim().isEmpty()) {
            throw new DataTidakValidException(
                    "nomorPeminjaman",
                    "Nomor peminjaman tidak boleh kosong."
            );
        }

        if (peminjam == null) {
            throw new DataTidakValidException(
                    "peminjam",
                    "Mahasiswa peminjam tidak boleh kosong."
            );
        }

        if (penyetuju == null) {
            throw new DataTidakValidException(
                    "penyetuju",
                    "Petugas penyetuju tidak boleh kosong."
            );
        }

        return new Peminjaman(
                nomorPeminjaman.trim(),
                peminjam,
                penyetuju
        );
    }

    public void validasiAlat(Alat alat)
            throws DataTidakValidException,
                   AlatBelumSiapException {

        if (alat == null) {
            throw new DataTidakValidException(
                    "alat",
                    "Alat tidak boleh kosong."
            );
        }

        if (!alat.siapDipinjam()) {
            throw new AlatBelumSiapException(
                    alat.getKode(),
                    "Periksa kondisi dan status alat."
            );
        }
    }

    public void tambahAlat(
            Peminjaman peminjaman,
            Alat alat,
            int jumlah)
            throws DataTidakValidException,
                   AlatBelumSiapException,
                   KuotaPeminjamanHabisException {

        if (peminjaman == null) {
            throw new DataTidakValidException(
                    "peminjaman",
                    "Data peminjaman tidak boleh kosong."
            );
        }

        if (jumlah <= 0) {
            throw new DataTidakValidException(
                    "jumlah",
                    "Jumlah alat harus lebih dari nol."
            );
        }

        validasiAlat(alat);

        if (peminjaman.totalItem() + jumlah > kuotaMaksimal) {
            throw new KuotaPeminjamanHabisException(
                    peminjaman.getPeminjam().toString(),
                    kuotaMaksimal
            );
        }

        peminjaman.tambahDetail(alat, jumlah);
    }

    public void validasiAlatSedangDipinjam(String kodeAlat)
            throws AlatSedangDipinjamException {

        // Pemeriksaan status peminjaman perlu data status alat
        // atau daftar peminjaman yang aktif.
        throw new UnsupportedOperationException(
                "Pemeriksaan alat yang sedang dipinjam "
                + "belum terhubung dengan data peminjaman aktif."
        );
    }
}