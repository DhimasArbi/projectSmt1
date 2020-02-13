package Peminjaman;

import static Peminjaman.NewClass2.daftarBuku;
import java.util.Scanner;

public class NewClass {

    static Scanner dhimas = new Scanner(System.in);
    static Scanner arbi = new Scanner(System.in);
    static String[] kategori = {"Umum", "Filsafat dan Psikologi", "Sosial", "Sains dan Matematika", "Teknologi"};
    //umum
    static String[] umum = {"Publikasi Umum, informasi umum dan komputer", "Bibiliografi", "Perpustakaan dan informasi", "Ensiklopedia dan buku yang memuat fakta-fakta",
        "Tidak ada klasifikasi", "Majalah dan Jurnal", "Asosiasi, Organisasi dan Museum", "Media massa, junalisme dan publikasi", "Kutipan", "Manuskrip dan buku langka"};
    //Filsafat dan psikologi
    static String[] filsafat = {"Filsafat dan psikologi", "Metafisika", "Epistimologi", "Parapsikologi dan Okultisme", "Pemikiran Filosofis",
        "Psikologi", "Filosofis Logis", "Etik", "Filosofi kuno, zaman pertengahan, dan filosofi ketimuran", "Filosofi barat modern"};
    //sosial
    static String[] sosial = {"Ilmu sosial, sosiologi dan antropologi", "Statistik", "Ilmu politik", "Ekonomi", "Hukum", "Administrasi publik dan ilmu kemiliteran",
        "Masalah dan layanan sosial", "Pendidikan", "Perdagangan, komunikasi dan transportasi", "Norma, etika dan tradisi"};
    //Sains dan Matematika
    static String[] sains = {"Sains", "Matematika", "Astronomi", "Fisika", "Kimia", "Ilmu kebumian dan geologi",
        "Fosil dan kehidupan prasejarah", "Biologi", "Tanaman", "Zoologi"};
    //Teknologi
    static String[] tekno = {"Teknologi", "Kesehatan dan Obat-Obatan", "Teknik", "Pertanian", "Managemen Rumah Tangga dan Keluarga",
        "Manajemen dan Hubungan dengan Publik", "Teknik Kimia", "Manufaktur", "Manufaktur untuk Keperluan Khusus", "Konstruksi"};
    static String[][] daftarBuku = {umum, filsafat, sosial, sains, tekno};
    static int[] jmlu = {10, 5, 3, 8, 4, 7, 10, 5, 5, 3};
    static int[] jmlf = {10, 5, 5, 5, 5, 8, 8, 8, 5, 5};
    static int[] jmls = {5, 5, 5, 5, 5, 7, 10, 20, 10, 5};
    static int[] jmlsm = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    static int[] jmlt = {8, 10, 10, 10, 5, 5, 5, 5, 5, 10};
    static int[][] jmlBuku = {jmlu, jmlf, jmls, jmlsm, jmlt};

    public static void main(String[] args) {
        
        menu();
    }

    static void menu() {
        String[] menu = {"Data master", "Pinjam", "Kembalikan", "Stok Buku", "Pencarian", "pengurutan buku", "Keluar"};
        int pilih;
        System.out.println("Daftar Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }

        System.out.print("Pilih menu[]: ");
        pilih = dhimas.nextInt();
        switch (pilih) {
            case 1:
                dataMaster(daftarBuku, jmlBuku);
                break;
            case 2:
                //peminjaman(daftarBuku, jmlBuku);
                break;
            case 3:
                break;
            case 4:
                //stock(kategori, jmlBuku);
                break;
            case 5:
                //pencarian(daftarBuku);
                break;
            case 6:
                //sort(daftarBuku, jmlBuku);
                break;
            default:

                break;
        }
    }

    static void dataMaster(String[][] a, int[][] b) {
        System.out.println("Data Master");
        System.out.println("--------------------");
        System.out.println("1. Daftar Buku\n2. Daftar Peminjam\n3. Tambah buku");
        System.out.print("Pilihan > ");
        int pilih = dhimas.nextInt();
        switch (pilih) {
            case 1:

                break;
            case 2:
                
                break;
            case 3:
                tambahBuku();
                break;
        }
    }

    static void tambahBuku() {
        String[][] cp = daftarBuku;
        String y;
        int[][] cq = jmlBuku;
        int jm,kt;
        System.out.println("Kategori yang ada adalah");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.print("Masukkan kategori: ");
        kt = dhimas.nextInt();
        if (kt == 1 || kt == 2 || kt == 3 || kt == 4 || kt == 5) {
            System.out.print("masukkan banyak buku: ");
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
            String[][] c = {umum, filsafat, sosial, sains, tekno};
            int[][] d = {jmlu, jmlf, jmls, jmlsm, jmlt};
            daftarBuku = c;
            jmlBuku = d;
            for (int i = (kt - 1); i < kt; i++) {
                for (int j = 0; j < daftarBuku[i].length; j++) {
                    if (j > daftarBuku[i].length - jm - 1) {
                        System.out.print("Masukkan nama Buku: ");
                        String nm = arbi.nextLine();
                        System.out.print("Masukkan jumlah Buku " + nm + ": ");
                        int nn = dhimas.nextInt();
                        daftarBuku[i][j] = nm;
                        jmlBuku[i][j] = nn;
                    } else {

                    }
                }
            }
            System.out.println("---Buku berhasil diinputkan---");
            System.out.print("Kembali ke menu > ");
            y = arbi.nextLine();
            if (y.equalsIgnoreCase("y")) {
                menu();
            } else {
                System.exit(0);
            }
        } else {
            System.out.println("Masukkan Kategori dengan benar!!!\n");
            tambahBuku();
        }
    }

//    static int[][] olahJumlah(int[][] a) {
//
//    }
//
//    static String[] olahPeminjam(String[] a) {
//
//    }
}
