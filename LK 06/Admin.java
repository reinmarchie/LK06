import java.io.*;
import java.util.*;

public class Admin {
    static Scanner input = new Scanner(System.in);

    public static boolean login() {
    try {
        BufferedReader br = new BufferedReader(new FileReader("pegawai.txt"));

        System.out.print("NIP: ");
        String nip = input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split("\\|");
            if (d[0].equals(nip) && d[1].equalsIgnoreCase(nama)) {
                br.close();
                return true;
            }
        }
        br.close();

    } catch (Exception e) {
        System.out.println("Error login");
    }
    return false;
}

    //pilihan menu utama
    public static void menu() {
        int pilih;
        do {
            System.out.println("\n1. Siswa\n2. Buku\n3. Transaksi\n4. Laporan\n5. Keluar");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> menuSiswa();
                case 2 -> menuBuku();
                case 3 -> menuTransaksi();
                case 4 -> Transaksi.laporan();
            }
        } while (pilih != 5);
    }

    // menu aksi untuk siswa
    public static void menuSiswa() {
        System.out.println("1. Tambah\n2. Lihat");
        int p = input.nextInt();
        input.nextLine();

        if (p == 1) {
            Siswa.tambahSiswa();
        } else {
            Siswa.tampilSiswa();
        }
    }

    // menu aksi untuk buku
    public static void menuBuku() {
        System.out.println("1. Tambah\n2. Lihat");
        int p = input.nextInt();
        input.nextLine();

        if (p == 1) {
            Buku.tambahBuku();
        } else {
            Buku.tampilBuku();
        }
    }

    // menu aksi untuk transaksi
    public static void menuTransaksi() {
        System.out.println("1. Pinjam\n2. Kembali");
        int p = input.nextInt();
        input.nextLine();

        if (p == 1) Transaksi.pinjam();
        else Transaksi.kembali();
    }
}
