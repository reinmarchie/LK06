import java.util.Scanner;

public class Buku {
    private String kode;
    private String judul;
    private String jenis;

    public Buku(String kode, String judul, String jenis) {
        this.kode = kode;
        this.judul = judul;
        this.jenis = jenis;
    }

    public String toFile() {
        return kode + "|" + judul + "|" + jenis;
    }

    public static void tambahBuku() {
        Scanner input = MainApp.input;
        System.out.print("Kode: ");
        String kode = input.nextLine();
        System.out.print("Judul: ");
        String judul = input.nextLine();
        System.out.print("Jenis: ");
        String jenis = input.nextLine();

        Buku b = new Buku(kode, judul, jenis);
        FileHelper.write("buku.txt", b.toFile());
        System.out.println("Buku berhasil ditambahkan!");
    }

    public static void tampilBuku() {
        System.out.println("Kode | Judul | Jenis");
        FileHelper.read("buku.txt");
    }
}
