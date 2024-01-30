package MODEL;

import NODE.Kamar;
import NODE.Tamu;

import java.util.ArrayList;

public class ModTamu {
    public ArrayList<Tamu> daftartamu ;

    public ModTamu(){
        daftartamu = new ArrayList<>();
    }

    public void TambahTAMU(String nama, String telp, String nik, Kamar kamar){
        daftartamu.add(new Tamu(nama,telp,nik,kamar));
    }
    public Tamu getNamaTamu(String nama) {
        for (Tamu tamu : daftartamu) {
            if (tamu.getNama().equals(nama)) {
                return tamu;
            }
        }
        System.out.println("Nama TAMU TIDAK ADA !!");
        return null;
    }
    public void viewAllTAMU(){
        for (int i=0; i < daftartamu.size();i++){
            daftartamu.get(i).viewTamu();
            System.out.println("===========");

        }
    }
}