
package model;

import java.io.Serializable;

// Bantuan AI: penambahan serialVersionUID
// sesuai Job Sheet 7 bagian E.3.

public class Komponen extends Alat implements Serializable {

    private static final long serialVersionUID = 1L;

    private int jumlahStok;
    private int jumlahMinimum;

    public Komponen(String kodeAlat, String nama, int tahunPerolehan,
                    int jumlahStok, int jumlahMinimum) {

        super(kodeAlat, nama, tahunPerolehan);

        this.jumlahStok = jumlahStok;
        this.jumlahMinimum = jumlahMinimum;
    }

    @Override
    public boolean siapDipinjam() {
        return jumlahStok > jumlahMinimum;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " stok " + jumlahStok
                + " minimum " + jumlahMinimum;
    }
}
