public class Buku {
    private static String kode;
    private static String judul;
    private static String jenis;

    public Buku(String kode, String judul, String jenis) {
        Buku.kode = kode;
        Buku.judul = judul;
        Buku.jenis = jenis;
    }

    public void setJudul(String judul) {
        Buku.judul = judul;
    }

    public void setJenis(String jenis) {
        Buku.jenis = jenis;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public String getJenis() {
        return jenis;
    }

    public static String toFile() {
        return kode + "|" + judul + "|" + jenis;
    }

    public static void tambahBuku() {
        FileHelper.write("buku.txt", toFile());
    }

    public static void tampilBuku() {
        FileHelper.read("buku.txt");
    }
}
