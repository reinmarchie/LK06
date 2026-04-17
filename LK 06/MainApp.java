import java.io.File;
import java.util.Scanner;

public class MainApp {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("    SISTEM PERPUSTAKAAN    ");

        try {
            // buat file
            File pegawai = new File("pegawai.txt");
            File siswa = new File("siswa.txt");
            File buku = new File("buku.txt");
            File transaksi = new File("transaksi.txt");

            pegawai.createNewFile();
            siswa.createNewFile();
            buku.createNewFile();
            transaksi.createNewFile();

            // isi data awal
            if (pegawai.length() == 0) {
                Pegawai p = new Pegawai("123", "admin", new java.util.Date());
                FileHelper.write("pegawai.txt", p.toFile());
                System.out.println("Admin dibuat");
            }

            if (siswa.length() == 0) {
                Siswa s1 = new Siswa("001", "Budi", "Malang");
                Siswa s2 = new Siswa("002", "Siti", "Blitar");

                FileHelper.write("siswa.txt", s1.toFile());
                FileHelper.write("siswa.txt", s2.toFile());
            }

            if (buku.length() == 0) {
                Buku b1 = new Buku("B01", "Laskar Pelangi", "Novel");
                Buku b2 = new Buku("B02", "Fisika Dasar", "Pelajaran");

                FileHelper.write("buku.txt", b1.toFile());
                FileHelper.write("buku.txt", b2.toFile());
            }
        //exception handling
        } catch (Exception e) {
            System.out.println("Error inisialisasi file");
        }

        // login
        if (Admin.login()) {
            System.out.println("Login berhasil!");
            Admin.menu();
        } else {
            System.out.println("Login gagal!");
        }
    }
}
