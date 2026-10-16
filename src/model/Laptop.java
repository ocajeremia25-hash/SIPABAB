
package model;

import java.io.Serializable;

// Bantuan AI: pengujian perubahan struktur kelas
// sesuai Job Sheet 7 bagian E.4.

public class Laptop extends Alat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String prosesor;
    private int ram;
    private double beratKg;

    public Laptop(String kodeAlat, String nama, int tahunPerolehan, String prosesor, int ram) {
        super(kodeAlat, nama, tahunPerolehan);
        this.prosesor = prosesor;
        this.ram = ram;
    }

    public double getBeratKg() {
        return beratKg;
    }

    @Override
    public boolean siapDipinjam() {
        return true;
    }
}