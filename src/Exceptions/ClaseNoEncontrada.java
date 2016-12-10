package Exceptions;

import bitacora.AdminMensajes;



public class ClaseNoEncontrada extends Exception{
    private final String mensaje = "La clase proporcionada no existe";
    private static AdminMensajes admin = new AdminMensajes();
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
