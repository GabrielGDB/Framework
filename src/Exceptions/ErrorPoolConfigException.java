package Exceptions;

import bitacora.AdminMensajes;



public class ErrorPoolConfigException extends Exception {
    private static AdminMensajes admin = new AdminMensajes();
    
    public ErrorPoolConfigException(String mensaje){
        super(mensaje);
        admin.error(this);
    }
}
