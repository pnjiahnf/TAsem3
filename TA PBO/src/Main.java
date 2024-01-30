import MODEL.Model;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Model.modAdmin.TambahAdmin("panji","07602","123");
        Model.modKamar.Tambahkamar(1,"VIP",1000);
        Model.modKamar.Tambahkamar(2,"Private",700);
        Model.modKamar.Tambahkamar(3,"Standart",300);

        Model.modPemesanan.cekin("pandu","088","89",2,"2022-03-23","2022-03-23");
        Model.modKamar.ViewKamarTersedia();
//        Model.modPemesanan.cekout();

        }

}