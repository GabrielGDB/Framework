package Exceptions;

import bitacora.AdminMensajes;



public class NoSePuedeAccederAlaClase extends Exception{
    private final String mensaje = "Ocurrio un error al acceder a la clase";
    private static AdminMensajes admin = new AdminMensajes();
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
