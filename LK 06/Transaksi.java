import java.io.*;
import java.util.*;

public class Transaksi {
    String kode, nis, kodeBuku, tglPinjam, tglKembali;
    int status;

    static Scanner input = MainApp.input;

    public Transaksi(String kode, String nis, String kodeBuku, String tglPinjam, String tglKembali, int status) {
        this.kode = kode;
        this.nis = nis;
        this.kodeBuku = kodeBuku;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.status = status;
    }

    public String toFile() {
        return kode + "|" + nis + "|" + kodeBuku + "|" + tglPinjam + "|" + tglKembali + "|" + status;
    }

    // pinjam buku
    public static void pinjam() {
        try {
            System.out.print("Kode: ");
            String kode = input.nextLine();
            System.out.print("NIS: ");
            String nis = input.nextLine();
            System.out.print("Kode Buku: ");
            String kb = input.nextLine();
            System.out.print("Tgl Pinjam: ");
            String tgl = input.nextLine();

            int count = 0;
            BufferedReader br = new BufferedReader(new FileReader("transaksi.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split("\\|");
                if (d[1].equals(nis) && d[5].equals("0"))
                    count++;
            }
            br.close();

            if (count >= 2) {
                System.out.println("Max 2 buku!");
                return;
            }

            Transaksi t = new Transaksi(kode, nis, kb, tgl, "-", 0);
            FileHelper.write("transaksi.txt", t.toFile());

        } catch (Exception e) {
            System.out.println("Error pinjam");
        }
    }

    // buku kembali
    public static void kembali() {
        try {
            System.out.print("Kode: ");
            String kode = input.nextLine();
            System.out.print("Tgl kembali: ");
            String tgl = input.nextLine();

            File in = new File("transaksi.txt");
            File temp = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split("\\|");
                if (d[0].equals(kode)) {
                    line = d[0] + "|" + d[1] + "|" + d[2] + "|" + d[3] + "|" + tgl + "|1";
                }
                bw.write(line + "\n");
            }

            br.close();
            bw.close();

            in.delete();
            temp.renameTo(in);

        } catch (Exception e) {
            System.out.println("Error kembali");
        }
    }

    // laporan buku
    public static void laporan() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("transaksi.txt"));
            String line;

            System.out.println("Kode | NIS | Buku | Tgl Pinjam | Tgl Kembali | Status");

            while ((line = br.readLine()) != null) {
                String[] d = line.split("\\|");

                for (int i = 0; i < d.length; i++) {
                    if (i == 5) {
                        String status = d[i].equals("0") ? "Dipinjam" : "Kembali";
                        System.out.print(status);
                    } else {
                        System.out.print(d[i] + " | ");
                    }
                }
                System.out.println();
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error laporan");
        }
    }
}
