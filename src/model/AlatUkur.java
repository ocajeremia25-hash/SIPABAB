
package model;

import java.io.Serializable;
import java.time.LocalDate;

// Bantuan AI: penambahan serialVersionUID
// sesuai Job Sheet 7 bagian E.3.

public class AlatUkur extends Alat implements Kalibrasiable, Serializable {

    private static final long serialVersionUID = 1L;

    private String satuan;
    private LocalDate kalibrasiTerakhir;

    public AlatUkur(String kodeAlat, String nama, int tahunPerolehan,
                    String satuan, LocalDate kalibrasiTerakhir) {

        super(kodeAlat, nama, tahunPerolehan);

        this.satuan = satuan;
        this.kalibrasiTerakhir = kalibrasiTerakhir;
    }

    @Override
    public LocalDate jatuhTempoKalibrasi() {
        return kalibrasiTerakhir.plusMonths(12);
    }

    @Override
    public boolean perluKalibrasi() {
        return LocalDate.now().isAfter(jatuhTempoKalibrasi());
    }

    @Override
    public boolean siapDipinjam() {
        return !perluKalibrasi();
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " satuan " + satuan;
    }
}
