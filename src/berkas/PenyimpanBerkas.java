
package berkas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Alat;

// Bantuan AI: kode penyimpanan dan pembacaan objek
// sesuai Job Sheet 7 bagian E.3.

public class PenyimpanBerkas {

    public static void simpan(String namaBerkas, List<Alat> daftarAlat)
            throws IOException {

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(namaBerkas))) {

            output.writeObject(new ArrayList<>(daftarAlat));
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Alat> baca(String namaBerkas)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(namaBerkas))) {

            return (List<Alat>) input.readObject();
        }
    }
}
