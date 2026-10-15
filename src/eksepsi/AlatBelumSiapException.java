
package eksepsi;

// Atribusi AI: bantuan AI untuk exception alat yang belum siap.
public class AlatBelumSiapException extends SipalabException {

    public AlatBelumSiapException(String kodeAlat, String alasan) {
        super("Alat " + kodeAlat
                + " belum siap dipinjam. " + alasan);
    }
}