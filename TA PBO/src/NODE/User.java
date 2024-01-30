package NODE;

public class User {
    public String Nik;
    public String Nama;

    public User(String nama,String nik) {
        this.Nama=nama;
        this.Nik=nik;
    }

    public String getNik() {
        return Nik;
    }

    public void setNik(String nik) {
        Nik = nik;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
