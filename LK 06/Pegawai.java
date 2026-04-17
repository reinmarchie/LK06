import java.util.*;
public class Pegawai {
    private static String nip;
    private static String nama;
    private static Date tanggalLahir;

    public Pegawai(String nip, String nama, Date tanggalLahir) {
        Pegawai.nip = nip;
        Pegawai.nama = nama;
        Pegawai.tanggalLahir = tanggalLahir;
    }

    public void setNama(String nama) {
        Pegawai.nama = nama;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        Pegawai.tanggalLahir = tanggalLahir;
    }

    public String getNip() {
        return nip;
    }

    public String getNama() {
        return nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public static String toFile() {
        return nip + "|" + nama + "|" + tanggalLahir.getTime();
    }

    public static void tambahPegawai() {
        FileHelper.write("pegawai.txt", toFile());
    }

    public static void tampilPegawai() {
        FileHelper.read("pegawai.txt");
    }
}
