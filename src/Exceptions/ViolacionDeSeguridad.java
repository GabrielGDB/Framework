package Exceptions;

import bitacora.AdminMensajes;



public class ViolacionDeSeguridad extends Exception{
    private static AdminMensajes admin = new AdminMensajes();
    private final String mensaje = "Ha habido una violación de seguridad";    
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
