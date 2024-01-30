package NODE;

public class Tamu {
    private String nama;
    private String telp;
    private String nik;
    private Kamar kamar;


    public Tamu(String nama, String telp, String nik,Kamar kamar) {
        this.nama = nama;
        this.telp = telp;
        this.nik = nik;
        this.kamar = kamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }


    public void viewTamu(){
        System.out.println("NAMA : " + nama);
        System.out.println("NO.TELEPON : "+ telp);
        System.out.println("NIK : " + nik);
        System.out.println("BERADA DI KAMAR (" + kamar.getKodeKamar() + ") Berjenis kamar : " + kamar.getJeniskamar());
    }
}
