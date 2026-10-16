
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Alat;
import model.Laptop;
import model.Proyektor;
import model.AlatUkur;
import model.Komponen;
import berkas.EksporLaporan;
import berkas.PenyimpanBerkas;

public class Main {

    public static void main(String[] args) {
        try {
            // E.1: Pengujian penulisan berkas
            tulisTanpaMenutup();
            tulisDenganAman();

            System.out.println("Pengujian E.1 selesai.");

            // Membuat data contoh inventaris
            List<Alat> daftarAlat = new ArrayList<>();

            daftarAlat.add(new Laptop(
                    "LP-002", "Laptop", 2024, "Intel Core i5", 8));

            daftarAlat.add(new Proyektor(
                    "PJ-003", "Proyektor", 2023, 3500));

            daftarAlat.add(new AlatUkur(
                    "AU-004", "Alat Ukur", 2022,
                    "cm", LocalDate.of(2025, 3, 10)));

            daftarAlat.add(new Komponen(
                    "KP-005", "Komponen", 2024, 10, 2));

            // E.2: Ekspor laporan inventaris ke TXT
            EksporLaporan.eksporLaporan(
                    "laporan_inventaris.txt", daftarAlat);

            System.out.println("Laporan TXT berhasil dibuat.");

            // E.3: Serialisasi objek ke berkas
            PenyimpanBerkas.simpan(
                    "inventaris.dat", daftarAlat);

            System.out.println("Data inventaris berhasil disimpan.");

            // Membaca kembali data hasil serialisasi
            List<Alat> hasilMuat =
                    PenyimpanBerkas.baca("inventaris.dat");

            System.out.println("Jumlah data sebelum disimpan: "
                    + daftarAlat.size());

            System.out.println("Jumlah data setelah dimuat: "
                    + hasilMuat.size());

            if (daftarAlat.size() == hasilMuat.size()) {
                System.out.println(
                        "Pengujian serialisasi berhasil.");
            } else {
                System.out.println(
                        "Pengujian serialisasi gagal.");
            }

            // Bagian F: Ekspor laporan CSV
            EksporLaporan.tulisCSV(
                    "laporan_inventaris.csv", daftarAlat);

            System.out.println("Laporan CSV berhasil dibuat.");
            System.out.println("Semua pengujian selesai.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(
                    "Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Atribusi AI: bantuan pengujian penulisan berkas
    // sesuai Job Sheet 7 bagian E.1.
    public static void tulisTanpaMenutup() throws IOException {
        FileWriter tulis = new FileWriter("uji_lupa_tutup.txt");
        tulis.write("Baris ini seharusnya tersimpan.");
        // Sengaja tidak memanggil close() untuk pengujian.
    }

    // Atribusi AI: bantuan penggunaan try-with-resources.
    public static void tulisDenganAman() throws IOException {
        try (FileWriter tulis = new FileWriter("uji_aman.txt")) {
            tulis.write("Baris ini pasti tersimpan.");
        }
    }
}
