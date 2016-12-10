package Exceptions;

import bitacora.AdminMensajes;



public class MapeoErroneoExcepcion extends Exception{
    private static AdminMensajes admin = new AdminMensajes();

    public MapeoErroneoExcepcion(String message) {
        super(message);
        admin.error(this);
    }

    
    
}
