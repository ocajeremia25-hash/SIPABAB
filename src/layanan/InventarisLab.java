package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Alat;
import pembanding.UrutStatusLaluNama;

public class InventarisLab {
    // Tugas Mandiri: Menggunakan Map dengan kunci (key) kode alat
    private final Map<String, Alat> daftarAlat = new HashMap<>();

    public void tambahAlat(Alat alat) {
        daftarAlat.put(alat.getKode(), alat);
    }

    public List<Alat> getDaftarAlat() {
        return new ArrayList<>(daftarAlat.values());
    }

    // Tugas Mandiri: Pencarian cepat berbasis kode alat
    // Penjelasan: Map lebih tepat digunakan dibanding List untuk pencarian berdasarkan kode
    // karena Map menggunakan hashing sehingga pencarian bernilai O(1) (konstan),
    // sedangkan List membutuhkan penelusuran elemen satu per satu O(n).
    public Alat cariKode(String kode) {
        return daftarAlat.get(kode);
    }

    public List<Alat> urut(Comparator<Alat> pembanding) {
        List<Alat> salinan = new ArrayList<>(daftarAlat.values());
        salinan.sort(pembanding);
        return salinan;
    }

    public List<Alat> urutBawaan() {
        return urut(new UrutStatusLaluNama());
    }

    public void hapusYangTidakSiap() {
        daftarAlat.values().removeIf(a -> !a.siapDipinjam());
    }

    public List<Alat> cari(String kata) {
        String k = kata.toLowerCase();
        List<Alat> hasil = new ArrayList<>();
        for (Alat a : daftarAlat.values()) {
            if (a.getNama().toLowerCase().contains(k)
                || a.getKode().toLowerCase().contains(k)) {
                hasil.add(a);
            }
        }
        return hasil;
    }
}