package Exceptions;

import bitacora.AdminMensajes;

public class ArchivoConfigNotFoundException extends Exception{
    private static AdminMensajes admin = new AdminMensajes();

    
    public ArchivoConfigNotFoundException(String mensaje){        
        super(mensaje);
        admin.error(this);
    }
}
