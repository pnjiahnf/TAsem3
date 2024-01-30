package NODE;

public class Admin extends User {
    public String Pass;
    public Admin (String nama,String nik,String pass){
        super(nama,nik);
        this.Pass=pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getPass() {
        return Pass;
    }
    public void viewAdmin(){
        System.out.println("Nama : " + Nama);
        System.out.println("Pass : " + Pass);
        System.out.println("NIP : " + Nik);
    }

}
