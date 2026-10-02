package model;

public interface DapatDipesan {

    boolean dapatDipesan();

    default String statusPesanan() {
        if (dapatDipesan()) {
            return "Alat dapat dipesan.";
        }

        return "Alat tidak dapat dipesan.";
    }
}