package Exceptions;

import bitacora.AdminMensajes;



public class ConnectionsInUseException extends Exception {
    private static AdminMensajes admin = new AdminMensajes();

    public ConnectionsInUseException(String mensaje){
        super(mensaje);
        admin.error(this);
    }
}
