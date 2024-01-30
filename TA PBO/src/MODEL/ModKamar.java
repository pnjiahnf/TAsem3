package MODEL;

import NODE.Kamar;

import java.util.ArrayList;

public class ModKamar {
    public ArrayList <Kamar> kamarList ;

    public ModKamar(){
        kamarList = new ArrayList<>();
    }

    public void Tambahkamar(int kodeKamar,String jeniskamar, int harga){
        boolean status = true;
        kamarList.add(new Kamar(kodeKamar,jeniskamar,harga,status));
    }

    public int getKODEKamar(){
        int kode = 0;
        if (kamarList != null) {
            for (Kamar kamar : kamarList) {
                kode = kamar.getKodeKamar();
            }
        }
        return kode;
    }


    public Kamar getKamar(int kode){
        for (Kamar kamar: kamarList){
            if(kamar.getKodeKamar() == kode){
                return kamar;
            }
        }
        return null;
    }

    public void viewALLkamar(){
        for (int i=0 ; i < kamarList.size(); i++){
            kamarList.get(i).viewKamar();
            System.out.println("==============");
        }
    }

    public boolean UpdateHarga(int kode,int Harga){
        for (Kamar kamar: kamarList){
            if (kamar.getKodeKamar() == kode){
                kamar.setHarga(Harga);
                return true;
            }
        }
        return false;
    }

    public boolean UpdateJenis(int kode,String jenis){
        for (Kamar kamar: kamarList){
            if (kamar.getKodeKamar() == kode){
                kamar.setJeniskamar(jenis);
                return true;
            }
        }
        return false;
    }

    public void ViewKamarTersedia(){
        for (Kamar kamar:kamarList){
            if (kamar.getStatus() == true){
                kamar.viewKamar();
            }
        }
    }


}
