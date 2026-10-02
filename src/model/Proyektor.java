package model;

public class Proyektor extends Alat {
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