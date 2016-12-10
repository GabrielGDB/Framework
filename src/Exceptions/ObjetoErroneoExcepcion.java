package Exceptions;

import bitacora.AdminMensajes;

public class ObjetoErroneoExcepcion extends Exception{
    private static AdminMensajes admin = new AdminMensajes();


    public ObjetoErroneoExcepcion(String message) {
        super(message);
        admin.error(this);
    }
    
}
