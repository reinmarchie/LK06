import java.util.Date;
import java.util.Scanner;

public class Pegawai {
    private String nip;
    private String nama;
    private Date tanggalLahir;

    public Pegawai(String nip, String nama, Date tanggalLahir) {
        this.nip = nip;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
    }

    public String toFile() {
        return nip + "|" + nama + "|" + tanggalLahir.getTime();
    }

    public static void tambahPegawai() {
        Scanner input = MainApp.input;

        System.out.print("NIP: ");
        String nip = input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();

        Date tgl = new Date();

        Pegawai p = new Pegawai(nip, nama, tgl);
        FileHelper.write("pegawai.txt", p.toFile());
    }
}
