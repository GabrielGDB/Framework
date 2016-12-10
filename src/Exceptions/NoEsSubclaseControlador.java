package Exceptions;

import bitacora.AdminMensajes;



public class NoEsSubclaseControlador extends Exception{
    private final String mensaje = "La clase proporcionada no es subclase de Controlador";
    private static AdminMensajes admin = new AdminMensajes();
    
    public String getMensaje(){
        admin.error(this);
        return mensaje;
    }
}
