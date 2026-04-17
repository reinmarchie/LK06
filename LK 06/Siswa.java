public class Siswa{
    private static String nis;
    private static String nama;
    private static String alamat;

    public Siswa(String nis, String nama, String alamat) {
        Siswa.nis = nis;
        Siswa.nama = nama;
        Siswa.alamat = alamat;
    }

    public static void setNama(String nama) {
        Siswa.nama = nama;
    }

    public static void setAlamat(String alamat) {
        Siswa.alamat = alamat;
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

    public static String toFile() {
        return nis + "|" + nama + "|" + alamat;
    }

    public static void tambahSiswa() {
        FileHelper.write("siswa.txt", toFile());
    }

    public static void tampilSiswa() {
        FileHelper.read("siswa.txt");
    }
}