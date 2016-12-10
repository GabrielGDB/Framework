package Exceptions;

import bitacora.AdminMensajes;

public class ArchivoConfigPoolNoEncontradoExcepcion extends Exception{
    private static AdminMensajes admin = new AdminMensajes();

    public ArchivoConfigPoolNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
        admin.error(this);
    }
    
}
