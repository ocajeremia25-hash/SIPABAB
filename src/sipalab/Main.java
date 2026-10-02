package sipalab;

import koleksi.Keranjang;
import layanan.InventarisLab;
import model.*;
import pembanding.*;

public class Main {
    public static void main(String[] args) {
        // 1. Inisialisasi Inventaris
        InventarisLab lab = new InventarisLab();

        // 2. Buat Objek Laptop & Proyektor
        Laptop laptop = new Laptop("LP-002", "Lenovo ThinkPad", 2022, "Intel i7", 16);
        Proyektor proyektor = new Proyektor("PJ-003", "Epson EB-X51", 2021, 3300);

        // 3. Tambahkan ke Inventaris Lab
        lab.tambahAlat(laptop);
        lab.tambahAlat(proyektor);

        // 4. Uji Generics (Keranjang)
        Keranjang<Alat> keranjang = new Keranjang<>(5);
        keranjang.tambah(laptop);
        keranjang.tambah(proyektor);

        System.out.println("===== ISI KERANJANG =====");
        for (Alat a : keranjang) {
            System.out.println("- " + a.getNama());
        }

        // 5. Uji Pengurutan Comparator Nama
        System.out.println("\n===== URUT BERDASARKAN NAMA =====");
        for (Alat a : lab.urut(new UrutNama())) {
            System.out.println(a.getNama());
        }

        // 6. Uji Pengurutan Comparator Tahun
        System.out.println("\n===== URUT BERDASARKAN TAHUN =====");
        for (Alat a : lab.urut(new UrutTahun())) {
            System.out.println(a.getNama() + " (" + a.getTahun() + ")");
        }
    }
}