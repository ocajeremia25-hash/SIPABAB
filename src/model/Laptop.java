package model;

public class Laptop extends Alat {
    private String prosesor;
    private int ram;

    public Laptop(String kodeAlat, String nama, int tahunPerolehan, String prosesor, int ram) {
        super(kodeAlat, nama, tahunPerolehan);
        this.prosesor = prosesor;
        this.ram = ram;
    }

    @Override
    public boolean siapDipinjam() {
        return true;
    }
}