
import java.io.File;
import java.io.InvalidClassException;
import java.io.IOException;
import java.util.List;

import berkas.PenyimpanBerkas;
import model.Alat;

// Bantuan AI: pemeriksaan file serialisasi
// sesuai Job Sheet 7 bagian E.4.

public class UjiE4 {

    public static void main(String[] args) {
        File file = new File("inventaris.dat");

        System.out.println("Lokasi file: "
                + file.getAbsolutePath());
        System.out.println("File ditemukan: "
                + file.exists());

        try {
            List<Alat> data =
        PenyimpanBerkas.baca("inventaris_backup.dat");

            System.out.println(
                    "Data berhasil dimuat: " + data.size());

        } catch (InvalidClassException e) {
            System.out.println(
                    "InvalidClassException berhasil diuji.");
            System.out.println(e);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error lain: " + e);
        }
    }
}
