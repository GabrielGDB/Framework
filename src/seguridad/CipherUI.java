/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dell
 */
public class CipherUI {
    
    //mlMsk1RjGtA= sin encriptar Roland
    //7/0WwdVGhv8= sin encriptar anna
    
    HashMap users =  new HashMap();
    
    Cipher cipher;
    UserInterface ui;
    AdministradorAcceso accessManager;
    
    public CipherUI(){
       cipher = new Cipher(); 
       ui = new UserInterface();
       accessManager =  new AdministradorAcceso();
       users.put("Roland", "7/0WwdVGhv8=");
    }
            
    public void initCipher(String secretKey,int max){
        cipher.setSecretKey(secretKey); 
        accessManager.setMaxNumberIntents(max);
    }
    
    public void beginLogin(){
       while(accessManager.validateOperation()){
           
            ui.printMessage("Ingrese su nombre de usuario");
            String user = ui.getInput();
            ui.printMessage("Ingrese su contraseña");
            String pass = ui.getInput();
            String passC = cipher.Encrypt(pass);
        if(passC.equals(users.get(user))){
            System.out.println("welcome "+ user);
            break;
        }else{
            System.out.println("Error en el inicio de sesion");
            accessManager.decreaseIntentes();
            int left = accessManager.getIntents();
            System.out.println("Intentos restantes: " +left);
            
        }
       }
        
    }
    
    public void setMaxNumberIntents(int max){
        accessManager.setMaxNumberIntents(max);
    }
    
}
