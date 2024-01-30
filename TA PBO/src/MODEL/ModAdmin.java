package MODEL;

import NODE.Admin;

import java.util.ArrayList;

public class ModAdmin {
    public ArrayList <Admin> adminList ;

    public ModAdmin (){
    adminList =new ArrayList<>();
    }
    public void TambahAdmin(String nama,String nik,String pass){
        adminList.add(new Admin(nama,nik,pass));
    }

    public void ViewAlladmin(){
        for (int i = 0 ; i < adminList.size();i++){
            adminList.get(i).viewAdmin();
            System.out.println("==========");
        }
    }
}