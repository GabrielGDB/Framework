package Exceptions;

import bitacora.AdminMensajes;

public class MapeoInexistenteExcepcion extends Exception{
    private static AdminMensajes admin = new AdminMensajes();


    public MapeoInexistenteExcepcion(String message) {
        super(message);
        admin.error(this);
    }
    
}
