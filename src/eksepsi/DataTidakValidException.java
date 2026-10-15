
package eksepsi;

// Atribusi AI: bantuan AI untuk exception validasi data.
public class DataTidakValidException extends SipalabException {

    private final String namaKolom;

    public DataTidakValidException(String namaKolom, String pesan) {
        super(pesan);
        this.namaKolom = namaKolom;
    }

    public String getNamaKolom() {
        return namaKolom;
    }
}