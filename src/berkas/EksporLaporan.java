
package berkas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import model.Alat;

// Bantuan AI: penyesuaian ekspor laporan teks dan CSV
// sesuai Job Sheet 7, dengan menyesuaikan method
// yang tersedia pada kelas Alat di project SIPALAB.

public class EksporLaporan {

    public static void eksporLaporan(String namaBerkas, List<Alat> daftarAlat)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(namaBerkas)))) {

            writer.println("LAPORAN INVENTARIS SIPALAB");
            writer.println("Tanggal: " + LocalDate.now());
            writer.println();

            writer.printf("%-15s %-25s %-15s %-15s%n",
                    "Kode Alat", "Nama Alat", "Jenis", "Status");

            for (Alat a : daftarAlat) {
                writer.printf("%-15s %-25s %-15s %-15s%n",
                        a.getKode(),
                        a.getNama(),
                        a.getClass().getSimpleName(),
                        a.siapDipinjam() ? "SIAP" : "TIDAK SIAP");
            }

            writer.println();
            writer.println("Jumlah alat: " + daftarAlat.size());
        }
    }

    public static void tulisCSV(String namaBerkas, List<Alat> daftarAlat)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(namaBerkas)))) {

            writer.println("Kode Alat,Nama Alat,Jenis,Status");

            for (Alat a : daftarAlat) {
                writer.println(
                        csv(a.getKode()) + ","
                        + csv(a.getNama()) + ","
                        + csv(a.getClass().getSimpleName()) + ","
                        + csv(a.siapDipinjam() ? "SIAP" : "TIDAK SIAP")
                );
            }
        }
    }

    private static String csv(String nilai) {
        if (nilai == null) {
            return "\"\"";
        }

        return "\"" + nilai.replace("\"", "\"\"") + "\"";
    }
}
