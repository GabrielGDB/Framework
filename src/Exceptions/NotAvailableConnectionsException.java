package Exceptions;

import bitacora.AdminMensajes;


public class NotAvailableConnectionsException extends Exception {
    private static AdminMensajes admin = new AdminMensajes();
    
    public NotAvailableConnectionsException(String mensaje){
        super(mensaje);
        admin.error(this);
    }
}
