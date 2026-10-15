
package eksepsi;

// Atribusi AI: bantuan AI untuk exception alat yang masih dipinjam.
public class AlatSedangDipinjamException extends SipalabException {

    public AlatSedangDipinjamException(String kodeAlat) {
        super("Alat " + kodeAlat
                + " sedang dipinjam dan belum dikembalikan.");
    }
}