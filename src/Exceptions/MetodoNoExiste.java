package Exceptions;

import bitacora.AdminMensajes;



public class MetodoNoExiste extends Exception{
    private static AdminMensajes admin = new AdminMensajes();
    private final String mensaje = "El método no existe";
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
