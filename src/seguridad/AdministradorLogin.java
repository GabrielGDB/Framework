/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class AdministradorLogin {
    
    private ArrayList<Usuario> usuarios;
    Cifrador cipher;
    AdministradorAcceso accessManager;

    public AdministradorLogin() {
       cipher = new Cifrador();
       accessManager =  new AdministradorAcceso();
    }
    
    public void obtenerUsuarios(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    
    public void iniciarCifrador(String secretKey,int max){
        cipher.setSecretKey(secretKey); 
        accessManager.setMaxNumberIntents(max);
    }
    
    public String iniciarLogin(String nombre, String pass){
        String passS1;
        String passS2;
        int index = 0;
        if(accessManager.validateOperation()){
            accessManager.decreaseIntentes();
            passS1 = cipher.Encrypt(pass);
            passS2 = cipher.Encrypt(passS1);
            while(index <= usuarios.size()-1){
            if(nombre.equals(usuarios.get(index).name) && passS2.equals(usuarios.get(index).pass)){
                return usuarios.get(index).permission;
            }else{
                index++;
            }
        }
          }else{
            return "Demasiados Intentos";
        }
        return "error";
       
    }   
}
    

