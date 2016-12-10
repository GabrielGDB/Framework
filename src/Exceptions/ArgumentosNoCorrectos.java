package Exceptions;

import bitacora.AdminMensajes;


public class ArgumentosNoCorrectos extends Exception{
    private static AdminMensajes admin = new AdminMensajes();
    private final String mensaje = "Los argumentos insertados en el método no son correctos";
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
