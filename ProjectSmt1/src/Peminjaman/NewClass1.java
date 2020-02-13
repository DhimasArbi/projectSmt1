package Peminjaman;

import java.util.Scanner;

public class NewClass1 {

    static String[] kategori = {"Umum", "Filsafat dan Psikologi", "Sosial", "Sains dan Matematika", "Teknologi"};
    static String[] umum = {"Publikasi Umum, informasi umum dan komputer", "Bibiliografi", "Perpustakaan dan informasi", "Ensiklopedia dan buku yang memuat fakta-fakta",
        "Tidak ada klasifikasi", "Majalah dan Jurnal", "Asosiasi, Organisasi dan Museum", "Media massa, junalisme dan publikasi", "Kutipan", "Manuskrip dan buku langka"};
    static String[] filsafat = {"Filsafat dan psikologi", "Metafisika", "Epistimologi", "Parapsikologi dan Okultisme", "Pemikiran Filosofis",
        "Psikologi", "Filosofis Logis", "Etik", "Filosofi kuno, zaman pertengahan, dan filosofi ketimuran", "Filosofi barat modern"};
    static String[] sosial = {"Ilmu sosial, sosiologi dan antropologi", "Statistik", "Ilmu politik", "Ekonomi", "Hukum", "Administrasi publik dan ilmu kemiliteran",
        "Masalah dan layanan sosial", "Pendidikan", "Perdagangan, komunikasi dan transportasi", "Norma, etika dan tradisi"};
    static String[] sains = {"Sains", "Matematika", "Astronomi", "Fisika", "Kimia", "Ilmu kebumian dan geologi",
        "Fosil dan kehidupan prasejarah", "Biologi", "Tanaman", "Zoologi"};
    static String[] tekno = {"Teknologi", "Kesehatan dan Obat-Obatan", "Teknik", "Pertanian", "Managemen Rumah Tangga dan Keluarga",
        "Manajemen dan Hubungan dengan Publik", "Teknik Kimia", "Manufaktur", "Manufaktur untuk Keperluan Khusus", "Konstruksi"};
    static String[][] daftarBuku = {umum, filsafat, sosial, sains, tekno};
    static int[] jmlu = {10, 5, 3, 8, 4, 7, 10, 5, 5, 3};
    static int[] jmlf = {10, 5, 5, 5, 5, 8, 8, 8, 5, 5};
    static int[] jmls = {5, 5, 5, 5, 5, 7, 10, 20, 10, 5};
    static int[] jmlsm = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    static int[] jmlt = {8, 10, 10, 10, 5, 5, 5, 5, 5, 10};
    static int[][] jmlBuku = {jmlu, jmlf, jmls, jmlsm, jmlt};
    static int[][] jmlPinjam = new int[daftarBuku.length][10];
    static String[][] peminjam = {
        {"Riski", daftarBuku[3][0]},
        {"Wahyu", daftarBuku[2][1]},
        {"Adan", daftarBuku[1][0]}
    };
    static int tglPeminjam[] = {8, 11, 13};
    static int denda[] = {0, 0, 0};
    static int tglSaatIni = 10;
    static Scanner dhimas = new Scanner(System.in);
    static Scanner arbi = new Scanner(System.in);

    public static void main(String[] args) {
        jmlPinjam[3][0] = 1;
        jmlPinjam[1][0] = 1;
        jmlPinjam[2][1] = 1;
        menu();
    }

    static void menu() {
        String[] menu = {"Data master", "Pinjam", "Kembalikan", "Denda / Perpanjang", "Pencarian", "pengurutan buku", "Keluar"};
        int pilih;

        System.out.println("Daftar Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
        System.out.print("Pilih menu[]: ");
        pilih = dhimas.nextInt();
        switch (pilih) {
            case 1:
                dataMaster();
                break;
            case 2:
                peminjaman();
                break;
            case 3:
                kembalikan();
                break;
            case 4:
                denda_perpanjang();
                break;
            case 5:
                pencarian();
                backToMenu();
                break;
            case 6:
                sort(daftarBuku, jmlBuku);
                break;
            case 7:
                break;
            default:
                System.out.println("Inputan salah!!Program kembali ke awal");
                menu();
                break;
        }
    }

    static void dataMaster() {
        char tampil;
        int pilih;
        System.out.println("Data Master");
        System.out.println("--------------------");
        System.out.println("1. Daftar Buku\n2. Daftar Peminjam\n3. Tambah buku");
        System.out.print("Pilihan > ");
        pilih = dhimas.nextInt();
        switch (pilih) {
            case 1:
                System.out.println("Daftar Buku");
                System.out.println("-----------");
                if (peminjam.length != 0) {
                    for (int i = 0; i < daftarBuku.length; i++) {
                        for (int j = 0; j < daftarBuku[i].length; j++) {
                            if (daftarBuku[i][j].equalsIgnoreCase(peminjam[0][1])) {
                                jmlBuku[i][j] -= jmlPinjam[i][j];
                            } else if (daftarBuku[i][j].equalsIgnoreCase(peminjam[1][1])) {
                                jmlBuku[i][j] -= jmlPinjam[i][j];
                            } else if (daftarBuku[i][j].equalsIgnoreCase(peminjam[2][1])) {
                                jmlBuku[i][j] -= jmlPinjam[i][j];
                            } else {
                                jmlBuku[i][j] -= jmlPinjam[i][j];
                            }
                        }
                    }
                }
                for (int i = 0; i < daftarBuku.length; i++) {
                    int totalBukuKategori = 0, totalJenis = 0;
                    System.out.println("Kategori: " + kategori[i]);
                    for (int j = 0; j < jmlBuku[i].length; j++) {
                        totalBukuKategori += jmlBuku[i][j];
                        totalJenis = daftarBuku[i].length;
                    }
                    System.out.println("Jumlah buku dalam satu kategori: " + totalJenis);
                    System.out.println("jumlah total per Kategori: " + totalBukuKategori);
                    System.out.println("------------------------------------");
                }
                System.out.print("Tampilkan Semua Buku? [y/t]> ");
                tampil = dhimas.next().charAt(0);
                if (tampil == 'Y' || tampil == 'y') {
                    for (int i = 0; i < daftarBuku.length; i++) {
                        System.out.println("Kategori: " + kategori[i]);
                        System.out.println("Jumlah\t|    Nama Buku");
                        System.out.println("----------------------");
                        for (int j = 0; j < daftarBuku[i].length; j++) {
                            System.out.println(jmlBuku[i][j] + "\t|    " + daftarBuku[i][j]);
                        }
                        System.out.println();
                    }

                }
                backToMenu();
                break;
            case 2:
                System.out.println("Nama\t|    Buku yang Dipinjam");
                System.out.println("--------|----------------------");
                for (int i = 0; i < peminjam.length; i++) {
                    System.out.println(peminjam[i][0] + "\t|    " + peminjam[i][1]);
                }
                backToMenu();
                break;
            case 3:
                tambahBuku();
                break;
        }
    }

    static void tambahBuku() {
        String[][] cp = daftarBuku;
        int[][] cq = jmlBuku;
        int[][] cw = jmlPinjam;
        int jm, kt;
        System.out.println("Kategori yang ada adalah");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.print("Masukkan kategori: ");
        kt = dhimas.nextInt();
        if (kt<=5) {
            System.out.print("Masukkan banyak Judul: ");
            jm = dhimas.nextInt();
            if (kt == 1) {
                umum = new String[10 + jm];
                jmlu = new int[10 + jm];
            } else if (kt == 2) {
                filsafat = new String[10 + jm];
                jmlf = new int[10 + jm];
            } else if (kt == 3) {
                sosial = new String[sosial.length + jm];
                jmls = new int[jmls.length + jm];

            } else if (kt == 4) {
                sains = new String[sains.length + jm];
                jmlsm = new int[jmlsm.length + jm];

            } else if (kt == 5) {
                tekno = new String[tekno.length + jm];
                jmlt = new int[jmlt.length + jm];

            }
            for (int i = 0; i < cp.length; i++) {
                for (int j = 0; j < cp[i].length; j++) {
                    umum[j] = cp[0][j];
                    filsafat[j] = cp[1][j];
                    sosial[j] = cp[2][j];
                    sains[j] = cp[3][j];
                    tekno[j] = cp[4][j];
                    jmlu[j] = cq[0][j];
                    jmlf[j] = cq[1][j];
                    jmls[j] = cq[2][j];
                    jmlsm[j] = cq[3][j];
                    jmlt[j] = cq[4][j];
                }
            }
            String[][] f = {umum, filsafat, sosial, sains, tekno};
            int[][] g = {jmlu, jmlf, jmls, jmlsm, jmlt};
            jmlBuku = g;
            daftarBuku = f;
            jmlPinjam = new int[jmlBuku.length][15];
            for (int i = 0; i < cq.length; i++) {
                for (int j = 0; j < cq[i].length; j++) {
                    jmlPinjam[i][j] = cw[i][j];
                }
            }
            for (int i = (kt - 1); i < kt; i++) {
                for (int j = 0; j < daftarBuku[i].length; j++) {
                    if (j > daftarBuku[i].length - jm - 1) {
                        System.out.print("Masukkan nama Buku: ");
                        String nm = arbi.nextLine();
                        System.out.print("Masukkan jumlah Buku " + nm + ": ");
                        int jml = dhimas.nextInt();
                        daftarBuku[i][j] = nm;
                        jmlBuku[i][j] = jml;
                        jmlPinjam[i][j] = 0;
                    }
                }
            }
            System.out.println("---Buku berhasil diinputkan---");
            backToMenu();
        } else {
            System.out.println("Masukkan Kategori dengan benar!!!\n");
            tambahBuku();
        }
    }

    static void peminjaman() {
        int[] copyTgl = tglPeminjam;
        String[][] copy = peminjam;
        int[] denda1 = denda;
        int tgl, jml;
        String namaBuku = "y";
        System.out.println("Peminjaman Buku");
        System.out.print("Masukkan Jumlah Peminjam: ");
        jml = dhimas.nextInt();
        denda = new int[denda1.length + jml];
        tglPeminjam = new int[copyTgl.length + jml];
        peminjam = new String[copy.length + jml][copy[0].length];
        for (int i = 0; i < copyTgl.length; i++) {
            tglPeminjam[i] = copyTgl[i];
            denda[i] = denda1[i];
        }
        System.out.print("Masukkan tanggal peminjaman: ");
        tgl = dhimas.nextInt();
        for (int i = copyTgl.length; i < tglPeminjam.length; i++) {
            tglPeminjam[i] = tgl;
            tglSaatIni = tgl;
            denda[i] = 0;
        }
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                peminjam[i][j] = copy[i][j];
            }
        }
        for (int i = copy.length; i < peminjam.length; i++) {
            System.out.print("Masukkan nama peminjam: ");
            peminjam[i][0] = arbi.nextLine();
            System.out.println("----------------------------");
            namaBuku = pencarian();
            System.out.println("Buku yang anda pinjam adalah " + namaBuku);
            peminjam[i][1] = namaBuku;
            System.out.println("Peminjaman telah terdata. Pastikan untuk mengembalikan buku pada hari " + hari(tglPeminjam[i] + 7) + " tanggal " + (tglPeminjam[i] + 7));
        }
        for (int j = 0; j < jmlBuku.length; j++) {
            for (int k = 0; k < jmlBuku[j].length; k++) {
                if (namaBuku.equalsIgnoreCase(daftarBuku[j][k])) {
                    jmlPinjam[j][k] += 1;
                    jmlBuku[j][k] -= 1;
                }
            }
        }
        backToMenu();
    }

    static void kembalikan() {
        String namaP, namaB, a = "x", b = "x";
        String copy[][] = peminjam;
        peminjam = new String[copy.length - 1][2];
        int save = 0;
        System.out.println("Pengembalian Buku");
        System.out.println("-----------------");
        System.out.println("Nama\t|    Buku yang Dipinjam");
        System.out.println("--------|----------------------");
        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i][0] + "\t|    " + copy[i][1]);
        }
        System.out.print("Masukkan nama peminjam: ");
        namaP = dhimas.next();
        System.out.print("Masukkan nama buku yang dikembalikan: ");
        namaB = arbi.nextLine();
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (namaP.equalsIgnoreCase(copy[i][0]) && namaB.equalsIgnoreCase(copy[i][1])) {
                    a = copy[i][0];
                    b = copy[i][1];
                    save = i;
                    jmlPinjam[i][j] = 0;
                    jmlBuku[i][j] += 1;
                } else if (namaP != a && namaB != b) {
                    System.out.println("Nama Peminjam dan Nama Buku Salah!!!");
                    break;
                }
            }
        }
        if (namaP.equalsIgnoreCase(a) && namaB.equalsIgnoreCase(b)) {
            for (int i = 0; i < peminjam.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    if (i < save) {
                        peminjam[i][j] = copy[i][j];
                    } else if (i == save) {
                        if (i == 0) {
                            peminjam[i][j] = copy[i + 1][j];
                        } else {
                            peminjam[i][j] = copy[i + 1][j];
                        }
                    } else {
                        if (i > save) {
                            peminjam[i][j] = copy[i + 1][j];
                        } else {
                            peminjam[i - 1][j] = copy[i][j];
                        }
                    }
                }
            }
        } else {
            peminjam = copy;
        }
        backToMenu();
    }

    static void denda_perpanjang() {
        int pilih, perpjg = 7, bayar = 1000;
        char Pilih;
        String nama;
        int[] waktu = new int[tglPeminjam.length];
        System.out.println("\nDenda / Perpanjang Peminjaman Buku");
        System.out.println("----------------------------------");
        for (int i = 0; i < peminjam.length; i++) {
            waktu[i] = tglPeminjam[i] - tglSaatIni;
        }
        System.out.println("1. Cek waktu peminjaman\n2. Perpanjang\n3. Denda");
        System.out.print("Pilihan ||> ");
        pilih = dhimas.nextInt();
        if (pilih == 1) {
            System.out.println("Cek Waktu peminjaman\n");
            for (int i = 0; i < peminjam.length; i++) {
                System.out.println("Nama : " + peminjam[i][0]);
                System.out.println("Buku : " + peminjam[i][1]);
                System.out.println("Waktu peminjaman: " + waktu[i] + " hari");
                System.out.println();
            }
            backToMenu();
        } else if (pilih == 2) {
            System.out.println("Perpanjang");
            System.out.print("Siapa nama peminjam? ");
            nama = arbi.nextLine();
            for (int i = 0; i < peminjam.length; i++) {
                if (nama.equalsIgnoreCase(peminjam[i][0])) {
                    System.out.print("Apakah buku yang dipinjam " + peminjam[i][1] + "? ");
                    Pilih = dhimas.next().charAt(0);
                    if (Pilih == 'Y' || Pilih == 'y') {
                        tglPeminjam[i] += perpjg;
                        System.out.println("Berhasil Diperpanjang selama 7 hari\n");
                        backToMenu();
                    } else if (Pilih == 'T' || Pilih == 't') {
                        System.out.println("Input salah!!!");
                        denda_perpanjang();
                    }
                }
            }
        } else if (pilih == 3) {
            System.out.println("Denda");
            System.out.print("Siapa nama peminjam? ");
            nama = arbi.nextLine();
            for (int i = 0; i < peminjam.length; i++) {
                if (nama.equalsIgnoreCase(peminjam[i][0])) {
                    System.out.print("Apakah buku yang dipinjam " + peminjam[i][1] + "? ");
                    Pilih = dhimas.next().charAt(0);
                    if (Pilih == 'Y' || Pilih == 'y') {
                        if (waktu[i] < 0) {
                            denda[i] = bayar * (-waktu[i]);
                            System.out.println("Denda: Rp." + denda[i]);

                        } else {
                            System.out.println("Anda Belum didenda");
                        }
                        backToMenu();
                    } else if (Pilih == 'T' || Pilih == 't') {
                        System.out.println("Program kembali!");
                        denda_perpanjang();
                    }
                }
            }
        }
    }

    static String pencarian() {
        String namaBuku = "x";
        int kgri;
        System.out.println("\n");
        System.out.println("Dikategori mana buku yg anda cari");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.print("Pilihan |>");
        kgri = dhimas.nextInt();
        for (int i = (kgri - 1); i < kgri; i++) {
            System.out.println();
            System.out.println("Daftar buku di Kategori " + kategori[kgri - 1]);
            System.out.println("-------------------------------------------");
            for (int j = 0; j < daftarBuku[i].length; j++) {
                System.out.println(daftarBuku[i][j]);
            }
            System.out.println("-------------------------------------------");
            System.out.print("Masukkan nama buku yang Anda cari: ");
            namaBuku = arbi.nextLine();
            for (int j = 0; j < daftarBuku[i].length; j++) {
                if (namaBuku.equalsIgnoreCase(daftarBuku[i][j])) {
                    namaBuku = daftarBuku[i][j];
                    System.out.println("Buku: " + daftarBuku[i][j]);
                    System.out.println("Kategori: " + kategori[kgri - 1]);
                    System.out.println("Buku yang tersedia adalah " + jmlBuku[i][j]);
                    System.out.println("Letak buku di rak " + i + "| deret " + j);
                }
            }
        }
        return namaBuku;
    }

    static void sort(String[][] a, int[][] b) {
        String temp, y;
        int temp1;
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 1; j < (a[i].length); j++) {
                    if (b[i][j - 1] > b[i][j]) {
                        temp = a[i][j - 1];
                        a[i][j - 1] = a[i][j];
                        a[i][j] = temp;
                        temp1 = b[i][j - 1];
                        b[i][j - 1] = b[i][j];
                        b[i][j] = temp1;
                    }
                }
            }
        }
        System.out.println("Urutan dari jumlah buku terkecil");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(b[i][j] + "\t|  " + a[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
        backToMenu();
    }

    static void backToMenu() {
        System.out.print("Kembali ke menu > ");
        String y = arbi.nextLine();
        if (y.equalsIgnoreCase("y")) {
            menu();
        } else {
            System.exit(0);
        }
    }

    static String hari(int a) {
        String hari = "Senin";
        if (a == 2 || a == 9 || a == 16 || a == 23 || a == 30) {
            hari = "Senin";
        } else if (a == 3 || a == 10 || a == 17 || a == 24 || a == 31) {
            hari = "Selasa";
        } else if (a == 4 || a == 11 || a == 18 || a == 25) {
            hari = "Rabu";
        } else if (a == 5 || a == 12 || a == 19 || a == 26) {
            hari = "Kamis";
        } else if (a == 6 || a == 13 || a == 20 || a == 27) {
            hari = "Jum'at";
        } else if (a == 7 || a == 14 || a == 21 || a == 28) {
            hari = "Sabtu";
        } else if (a == 1 || a == 8 || a == 15 || a == 22 || a == 29) {
            hari = "Minggu";
        }
        return hari;
    }
}
