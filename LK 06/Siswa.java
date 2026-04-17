import java.util.Scanner;
public class Siswa{
    private String nis;
    private String nama;
    private String alamat;

    public Siswa(String nis, String nama, String alamat) {
        this.nis = nis;
        this.nama = nama;
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNis() {
        return nis;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String toFile() {
        return nis + "|" + nama + "|" + alamat;
    }

    public static void tambahSiswa() {
        Scanner input = MainApp.input;

        System.out.print("NIS: ");
        String nis = input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.print("Alamat: ");
        String alamat = input.nextLine();

        Siswa s = new Siswa(nis, nama, alamat);
        FileHelper.write("siswa.txt", s.toFile());
        System.out.println("Siswa berhasil ditambahkan!");
    }

    public static void tampilSiswa() {
        System.out.println("NIS | Nama | Alamat");
        FileHelper.read("siswa.txt");
    }
}
