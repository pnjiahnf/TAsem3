package MODEL;

import NODE.Kamar;
import NODE.Pemesanan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ModPemesanan {
    public ArrayList<Pemesanan> pemesananList;

    public ModPemesanan(){
        pemesananList = new ArrayList<>();
    }

    public void tambahpesan( String nama, String telp, String nik, Kamar nomorKamar, String tglCheckin, String tglCheckout, int jumlahMalam){
        pemesananList.add(new Pemesanan(nama,telp,nik,nomorKamar, tglCheckin, tglCheckout, jumlahMalam));
    }

    public long jumlahMalam(String tglCheckin, String tglCheckout){
        if (tglCheckin != null && tglCheckout != null) {
            return ChronoUnit.DAYS.between(LocalDate.parse(tglCheckin), LocalDate.parse(tglCheckout));
        } else {
            return 0;
        }
    }

    public void cekin(String nama, String telp, String nik, int kodeKamar, String tglCheckin, String tglCheckout){
    Kamar kamar = Model.modKamar.getKamar(kodeKamar);
        if (kamar != null && kamar.getStatus()) {
            int total = (int) (kamar.getHarga()*jumlahMalam(tglCheckin, tglCheckout));
            tambahpesan(nama,telp,nik,kamar,tglCheckin,tglCheckout,(int)jumlahMalam(tglCheckin, tglCheckout));
            Model.modTamu.TambahTAMU(nama,telp,nik,kamar);
            kamar.setStatus(false);
            System.out.println("Pemesanan berhasil bang!!");
            System.out.println(" ");
        }else{
            System.out.println("Kamar ga ada bang!!");
            System.out.println(" ");
        }
    }

    public void cekout(String namaPemesan, int kodeKamar){
        Pemesanan pemesanan = Model.modPemesanan.getNamaPemesan(namaPemesan);
        if (pemesanan != null){
            Kamar kamar = Model.modKamar.getKamar(kodeKamar);
            if(kamar != null){
                Boolean del = delete(namaPemesan);
                if(del){
                    kamar.setStatus(true);
                    System.out.println("Checkout berhasil!!!");
                    Model.modPemesanan.viewAllPemesanan();
                }else{
                    System.out.println("pesanan belum dihapus");
                }
            }else{
                System.out.println("kamar tidak ditemukan bang!!");
            }
        }else{
            System.out.println("tidak ada pemesanan untuk tamu dengan nama ( " + namaPemesan+" )");
        }
    }



    public Pemesanan getNamaPemesan(String nama) {
        for (Pemesanan pesan : pemesananList) {
            if (pesan.getNama().equals(nama)) {
                return pesan;
            }
        }
        System.out.println("Nama Pemesan Tidak ada !!");
        return null;
    }

    public boolean delete(String nm){
        Pemesanan pesan = getNamaPemesan(nm);
        if (pesan != null){
            pemesananList.remove(pesan);
            return true;
        }
        return false;
    }
    public void viewAllPemesanan (){
        for (int i = 0 ; i < pemesananList.size() ; i++){
            pemesananList.get(i).viewPesanan();
            System.out.println("=============");
        }
    }
}
