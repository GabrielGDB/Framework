package Exceptions;

import bitacora.AdminMensajes;

public class FalloInstanciaDeClase extends Exception{
    private static AdminMensajes admin = new AdminMensajes();
    private final String mensaje = "Ocurrio un error al instanciar la clase controlador proporcionada";
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
