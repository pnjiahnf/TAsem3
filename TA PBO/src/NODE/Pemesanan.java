package NODE;

public class Pemesanan {
    private String nama;
    private String telp;
    private String nik;
    private Kamar Kamar;
    protected String tglCheckin;
    private String tglCheckout;
    private int jumlahMalam;

    public Pemesanan(String nama, String telp, String nik, Kamar Kamar, String tglCheckin, String tglCheckout, int jumlahMalam) {
        this.nama= nama;
        this.telp = telp;
        this.nik = nik;
        this.Kamar = Kamar;
        this.tglCheckin = tglCheckin;
        this.tglCheckout = tglCheckout;
        this.jumlahMalam = jumlahMalam;
    }

    public void viewPesanan() {
        System.out.println("====================");
        System.out.println("NAMA TAMU : " + nama);
        System.out.println("Nomor telp : " + telp);
        System.out.println("Nomor NIK : " + nik);
        System.out.println("Nomor Kamar: " + Kamar.getKodeKamar() + ", Jenis Kamar: " + Kamar.getJeniskamar());
        System.out.println("Harga permalam Kamar: " + Kamar.getHarga());
        System.out.println("Tanggal Check-in: " + tglCheckin);
        System.out.println("Tanggal Check-out: " + tglCheckout);
        System.out.println("Jumlah Malam Menginap: " + jumlahMalam + " Malam");
        System.out.println("===================");
    }

    public Object getNama() {
        return null;
    }
}
