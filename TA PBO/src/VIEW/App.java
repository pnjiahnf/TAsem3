package VIEW;
import NODE.*;
import MODEL.*;
import VIEW.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Model.modAdmin.TambahAdmin("panji","07602","123");
        Model.modKamar.Tambahkamar(1,"VIP",1000);
        Model.modKamar.Tambahkamar(2,"Private",700);
        Model.modKamar.Tambahkamar(3,"Standart",300);
        Fitur fitur = new Fitur();
        Scanner scan = new Scanner(System.in);

        int pilihan;
        awal:
        while (true){
            fitur.Menu1();
            pilihan = scan.nextInt(); scan.nextLine();
            switch (pilihan) {
                case 1:
                    fitur.addAdmin();
                    break;
                case 2:
                    System.out.println("MASUKKAN USERNAME ADMIN : ");
                    String nm = scan.nextLine();
                    System.out.println("MASUKKAN PASSWORD ADMIN : ");
                    String pw = scan.nextLine();
                    for (Admin adminLogin : Model.modAdmin.adminList) {
                        if (adminLogin.getNama().equals(nm)) {
                            if (adminLogin.getPass().equals(pw)) {
                                boolean login = true;
                                while (login) {
                                    fitur.Menu2();
                                    int pilihanMenu = scan.nextInt();
                                    scan.nextLine();
                                    switch (pilihanMenu) {
                                        case 1:
                                            fitur.addKamar(adminLogin);
                                            break;
                                        case 2:
                                            fitur.InfoKAMAR(adminLogin);
                                            break;
                                        case 3:
                                            fitur.UpdateKamar(adminLogin);
                                            break;
                                        case 4:
                                            fitur.CEKIN(adminLogin);
                                            break;
                                        case 5:
                                            fitur.CEKOUT(adminLogin);
                                            break;
                                        case 6:
                                            fitur.LIHATRESERVASI(adminLogin);
                                            break;
                                        case 7:
                                            fitur.KamarTersedia(adminLogin);
                                            break;
                                        case 8:
                                            fitur.lihatdataTamu(adminLogin);
                                            break;
                                        case 9:
                                            System.out.println("Keluar dari menu");
                                            continue awal;
                                        default:
                                            System.out.println("Pilihan ga valid bang,ulangi");
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Kata sandi salahh");
                    break;
                case 3:
                    System.out.println("anda keluar dari program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid bangg, ulangi nggeh");
            }
        }
    }
}