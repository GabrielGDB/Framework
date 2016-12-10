package Exceptions;

import bitacora.AdminMensajes;



public class ErrorAlInvocarObjetivo extends Exception {
    private static AdminMensajes admin = new AdminMensajes();
    private final String mensaje = "Hubo un error al invocar la clase o método";

    public String getMensaje() {
        admin.error(this);
        return mensaje;
    }
}
