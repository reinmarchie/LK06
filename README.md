# LK06

## Class

### File Utama: MainApp.java

File MainApp.java berperan sebagai titik masuk utama dari aplikasi sistem perpustakaan.

1. Program dimulai dengan menampilkan judul "SISTEM PERPUSTAKAAN".
2. Membuat objek File untuk file-file teks (pegawai.txt, siswa.txt, buku.txt, transaksi.txt) dan memanggil createNewFile() untuk masing-masing jika belum ada.
3. Mengecek panjang file: jika pegawai.txt kosong, buat objek Pegawai default dan tulis ke file menggunakan FileHelper.write().
4. Jika siswa.txt kosong, buat objek Siswa contoh (Budi dan Siti) dan tulis ke file.
5. Jika buku.txt kosong, buat objek Buku contoh (Laskar Pelangi dan Fisika Dasar) dan tulis ke file.
6. Jika terjadi error selama inisialisasi, tampilkan pesan "Error inisialisasi file".
7. Jalankan Admin.login(): jika berhasil, tampilkan "Login berhasil!" dan panggil Admin.menu() untuk navigasi utama.
8. Jika login gagal, tampilkan "Login gagal!" dan program berakhir.

### Admin.java

kelas Admin ini berfungsi sebagai pusat kendali atau controller untuk aplikasi sistem informasi perpustakaan. Program diawali dengan fungsi login() yang melakukan verifikasi keamanan dengan cara membaca file pegawai.txt, di mana setiap baris data dipisahkan oleh karakter pipa (|) untuk membandingkan NIP dan Nama yang diinput pengguna dengan data yang tersimpan. Jika berhasil masuk, pengguna akan diarahkan ke metode menu() yang menggunakan struktur perulangan do-while dan switch-case untuk menampilkan navigasi utama,mulai dari manajemen data siswa, koleksi buku, hingga pencatatan transaksi.

Setiap pilihan dalam menu utama kemudian dipecah ke dalam metode-metode spesifik seperti menuSiswa(), menuBuku(), dan menuTransaksi(). Di dalam metode-metode tersebut, program memberikan opsi lanjutan kepada pengguna, seperti menambah data baru atau melihat data yang sudah ada, yang eksekusinya didelegasikan ke kelas-kelas lain yang relevan (seperti kelas Siswa, Buku, atau Transaksi). Seluruh proses input dalam kelas ini memanfaatkan objek Scanner yang bersifat statis, memastikan bahwa aliran data dari pengguna tetap konsisten di seluruh bagian aplikasi hingga pengguna memilih opsi untuk keluar.

### Buku.java

Kode dalam kelas Buku ini berfungsi sebagai representasi data buku atau model objek sekaligus sebagai penyedia layanan untuk mengelola informasi buku dalam sistem perpustakaan. Kelas ini mendefinisikan tiga atribut utama—yaitu kode, judul, dan jenis—yang diinisialisasi melalui sebuah constructor. Salah satu bagian pentingnya adalah metode toFile(), yang berfungsi mengubah objek buku menjadi baris teks dengan format yang dipisahkan oleh tanda pipa (|), sehingga data tersebut siap untuk disimpan secara terorganisir ke dalam file eksternal.

Selain mendefinisikan struktur data, kelas ini juga memiliki fungsi operasional statis, yaitu tambahBuku() dan tampilBuku(). Metode tambahBuku() bertugas mengambil input langsung dari pengguna melalui konsol, membuat objek buku baru, lalu menggunakan bantuan kelas FileHelper untuk menuliskan data tersebut ke dalam file buku.txt. Sementara itu, tampilBuku() berfungsi untuk menyajikan seluruh daftar koleksi buku kepada pengguna dengan cara membaca isi file tersebut dan menampilkannya dalam format tabel sederhana di layar. Secara keseluruhan, kelas ini menerapkan konsep enkapsulasi sederhana dan menjembatani interaksi antara input pengguna dengan penyimpanan data permanen.

### FileHelper.java

Kelas FileHelper ini adalah sebuah kelas utilitas (kelas bantuan) yang khusus menangani operasi input dan output (I/O) ke dalam file teks. Kelas ini dirancang dengan dua metode statis utama, yaitu write() dan read(), sehingga kelas-kelas lain (seperti Buku, Siswa, atau Admin) dapat langsung menggunakannya tanpa perlu membuat objek (instansiasi) terlebih dahulu.

Metode write() menggunakan FileWriter dengan tambahan parameter true, yang mengaktifkan mode append; artinya, setiap kali ada data baru yang disimpan, data tersebut akan ditambahkan ke baris paling bawah tanpa menimpa atau menghapus data yang sudah ada sebelumnya di dalam file. Sementara itu, metode read() memanfaatkan BufferedReader dan FileReader untuk membuka file, membacanya baris demi baris menggunakan perulangan while, dan langsung mencetaknya ke layar konsol. Kedua metode ini juga telah dilengkapi dengan blok try-catch (penanganan eksepsi) agar jika terjadi masalah—seperti file tidak ditemukan atau memori penuh—program tidak akan langsung crash, melainkan hanya menampilkan pesan peringatan sederhana seperti "Error tulis file" atau "Error baca file".

### Pegawai.java

kelas Pegawai ini berfungsi sebagai cetak biru atau model data untuk merepresentasikan informasi pengguna sistem, yang mencakup atribut pribadi seperti NIP, nama, dan tanggal lahir. Saat metode statis tambahPegawai() dijalankan, program akan meminta input NIP dan nama dari pengguna, lalu secara otomatis mengambil waktu saat ini menggunakan objek Date untuk mengisi data tanggal lahir tanpa perlu input manual. Setelah data terkumpul, objek tersebut akan diproses oleh metode toFile(), yang bertugas menggabungkan informasi menjadi satu baris teks dengan pemisah karakter pipa (|), di mana data waktu secara khusus dikonversi menjadi format angka (Long) menggunakan getTime() agar lebih stabil saat disimpan ke dalam dokumen. Baris teks tersebut kemudian ditulis secara permanen ke dalam file pegawai.txt menggunakan bantuan kelas FileHelper, yang mana file inilah yang nantinya menjadi sumber data utama yang dibaca oleh sistem saat melakukan proses login di kelas Admin.

### Siswa.java

kelas Siswa ini berfungsi sebagai cetak biru (model) yang merepresentasikan data siswa dengan menerapkan prinsip enkapsulasi, di mana informasi seperti NIS, nama, dan alamat dilindungi secara private dan hanya bisa diakses atau diubah melalui metode getter dan setter. Menariknya, ketiadaan metode setter untuk NIS membuat nomor induk tersebut bersifat permanen dan tidak bisa diubah lagi setelah data pertama kali dibuat. Saat metode tambahSiswa() dipanggil, program akan meminta input langsung dari pengguna, mengubahnya menjadi objek siswa, lalu menggunakan metode toFile() untuk merangkai data tersebut menjadi satu baris teks dengan pemisah karakter pipa (|). Baris teks ini kemudian ditulis dan disimpan secara permanen ke dalam file siswa.txt menggunakan fungsi dari FileHelper, sementara metode tampilSiswa() bertugas sebaliknya, yakni membaca dan menyajikan seluruh isi file tersebut ke layar agar pengguna dapat melihat daftar koleksi data siswa.

### Transaksi.java

kelas Transaksi ini berfungsi untuk mengelola data transaksi peminjaman dan pengembalian buku dalam sistem perpustakaan. Mendefinisikan atribut seperti kode transaksi, NIS siswa, kode buku, tanggal pinjam, tanggal kembali, dan status (0 untuk dipinjam, 1 untuk dikembalikan). Atribut-atribut tersebut dapat diinisialisasi melalui konstruktor

- Method toFile(): Mengubah objek transaksi menjadi baris teks dengan pemisah pipa (|) untuk melakukan formatting pada objek menjadi teks yang siap dimasukkan ke file transaksi.txt.
- Method pinjam(): Menangani peminjaman buku dengan validasi maksimal 2 buku per siswa, menambahkan transaksi baru ke file.
- Method kembali(): Mencatat pengembalian buku dengan memperbarui tanggal kembali dan status melalui manipulasi file sementara.
- Method laporan(): Menampilkan riwayat transaksi dalam format tabel menggunakan FileHelper untuk membaca data.
