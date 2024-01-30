package VIEW;

import MODEL.Model;
import NODE.Admin;
import NODE.Kamar;
import NODE.Pemesanan;

import java.util.Scanner;

public class Fitur {
    Scanner scan = new Scanner(System.in);

    public void Menu1(){
        System.out.println("==== HosteL ====");
        System.out.println("1. Admin ");
        System.out.println("2. Login ");
        System.out.println("3. Exit ");
        System.out.println("Pilih : ");
    }

    public void Menu2(){
            System.out.println(" ");
            System.out.println("==== WELCOME TO HOSTEL MENU ====");
            System.out.println("1. Menambah data kamar baru");
            System.out.println("2. Melihat info Seluruh kamar ");
            System.out.println("3. Mengedit data kamar ");
            System.out.println("4. Reservasi kamar(check-in) ");
            System.out.println("5. Reservasi kamar(check-out) ");
            System.out.println("6. Melihat detail reservasi ");
            System.out.println("7. Melihat kamar yang tersedia ");
            System.out.println("8. Melihat data tamu ");
            System.out.println("9. EXIT");
            System.out.print ("Pilih : ");
    }

    public void addAdmin(){
        System.out.println("MASUKKAN NAMA STAFF :");
        String nm = scan.nextLine();
        System.out.println("MASUKKAN PASSWORD :");
        String pw = scan.nextLine();
        System.out.println("MASUKKAN NIK :");
        String nik = scan.nextLine();

        Model.modAdmin.TambahAdmin(nm,pw,nik);
        Model.modAdmin.ViewAlladmin();
    }

    public void addKamar(Admin admin){
        System.out.println("Masukkan kode : ");
        int kd = scan.nextInt();
        System.out.println("Masukkan jenis kamar : ");
        String jn=scan.nextLine();
        System.out.println("Masukkan harga per malamnya : ");
        int hg = scan.nextInt();

        Model.modKamar.Tambahkamar(kd,jn,hg);

    }

    public void InfoKAMAR(Admin admin){
        System.out.println("====== LIST KAMAR ======");
        Model.modKamar.viewALLkamar();
    }

    public void UpdateKamar(Admin admin){
        System.out.println("====== menu UPDATE =====");
        System.out.println("1.jenis Kamar.");
        System.out.println("2.harga");
        System.out.println("3.kembali");
        System.out.print("pilih : ");
        int pil = scan.nextInt();
        scan.nextLine();
        switch (pil){
            case 1:
                Model.modKamar.viewALLkamar();
                System.out.print("Masukkan kode kamar : ");
                int kd = scan.nextInt();
                scan.nextLine();
                Kamar kamar = Model.modKamar.getKamar(kd);
                if (kamar != null){
                    System.out.print("Masukkan jenis kamar barunya : ");
                    String jn = scan.nextLine();
                    Model.modKamar.UpdateJenis(kd,jn);
                    System.out.println("SETELAH DIUPDATE : ");
                    Model.modKamar.getKamar(kd).viewKamar();
                }else {
                    System.out.println("Kode kamar salah bang!!");
                }
                break;
            case 2:
                Model.modKamar.viewALLkamar();
                System.out.print("Masukkan kode kamar : ");
                int id = scan.nextInt();
                scan.nextLine();
                Kamar kam = Model.modKamar.getKamar(id);
                if (kam != null){
                    System.out.print("masukkan harga terbarunya: ");
                    int harga = scan.nextInt();
                    Model.modKamar.UpdateHarga(id,harga);
                    System.out.println("SETELAH DIUPDATE : ");
                    Model.modKamar.getKamar(id).viewKamar();
                }else {
                    System.out.println("Kode kamar salah!!");
                }
                break;
            default:
                System.out.println("pilihan tidak valid, anda kembali ke menu");
        }
    }

    public void CEKIN(Admin admin){
        System.out.println("== RESERVASI HOTEL ==");
        System.out.println("MASUKKAN NAMA TAMU : ");
        String nm = scan.nextLine();
        System.out.println("MASUKKAN NO.TELP : ");
        String tl = scan.nextLine();
        System.out.println("MASUKKAN NIK : ");
        String nik = scan.nextLine();
        Model.modKamar.ViewKamarTersedia();
        System.out.println("MASUKKAN KODE KAMAR YANG AKAN DITEMPATI : ");
        int kode = scan.nextInt();
        scan.nextLine();
        System.out.println("CHECKIN HOTEL (YYYY-MM-DD) :");
        String cekin = scan.nextLine();
        System.out.println("CHECKOUT HOTEL (YYYY-MM-DD) : ");
        String cekout = scan.nextLine();
        scan.nextLine();
        Model.modPemesanan.cekin(nm,tl,nik,kode,cekin,cekout);
    }

    public void CEKOUT(Admin admin){
        Model.modPemesanan.viewAllPemesanan();
        System.out.println("MASUKKAN nama pemesanan : ");
        String nm = scan.nextLine();
        System.out.println("MASUKKAN KODE KAMAR : ");
        int kd = scan.nextInt();
        scan.nextLine();
        Model.modPemesanan.cekout(nm,kd);
    }

    public void LIHATRESERVASI(Admin admin) {
        System.out.println("===== LIHAT RESERVASI ====");
        System.out.println("Masukkan NAMA TAMU : ");
        String nm = scan.nextLine();
        Pemesanan pemesanan = Model.modPemesanan.getNamaPemesan(nm);
        if(pemesanan != null) {
            pemesanan.viewPesanan();
        }else{
            System.out.println("tidak ada reservasi untuk tamu dengan nama " + nm);
        }
    }

    public void KamarTersedia(Admin admin){
        System.out.println(" ======== LIST KAMAR KOSONG ========");
        Model.modKamar.ViewKamarTersedia();
    }

    public void lihatdataTamu(Admin admin){
        System.out.println("== LIST DATA TAMU ==");
        System.out.println("1.View all tamu");
        System.out.println("2. cari tamu (nama)");
        System.out.println("3. kembali");
        int pil = scan.nextInt();
        scan.nextLine();
        switch (pil){
            case 1 :
                Model.modTamu.viewAllTAMU();
                break;
            case 2 :
                System.out.println("Masukkan Nama Tamu : ");
                String nm = scan.nextLine();
                Model.modTamu.getNamaTamu(nm).viewTamu();
                break;
            default:
                System.out.println("pilihan tidak valid, anda kembali ke menu");
        }
    }
}
