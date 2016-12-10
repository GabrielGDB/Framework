package Util.exceptions;

import org.apache.log4j.Logger;

public class ErrorAlInvocarObjetivo extends Exception {

    private final String mensaje = "Hubo un error al invocar la clase o método";
    private static Logger log = Logger.getLogger(ErrorAlInvocarObjetivo.class);

    public String getMensaje() {
        log.error(mensaje);
        return mensaje;
    }
}
