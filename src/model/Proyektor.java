
package model;

import java.io.Serializable;

// Bantuan AI: penambahan serialVersionUID
// sesuai Job Sheet 7 bagian E.3.

public class Proyektor extends Alat implements Serializable {

    private static final long serialVersionUID = 1L;

    private int kecerahan;

    public Proyektor(String kodeAlat, String nama, int tahunPerolehan, int kecerahan) {
        super(kodeAlat, nama, tahunPerolehan);
        this.kecerahan = kecerahan;
    }

    @Override
    public boolean siapDipinjam() {
        return true;
    }
}
