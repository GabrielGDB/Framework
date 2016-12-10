package Util.exceptions;

import org.apache.log4j.Logger;

public class NoSePuedeAccederAlaClase extends Exception{
    private final String mensaje = "Ocurrio un error al acceder a la clase";
    private static Logger log = Logger.getLogger(NoSePuedeAccederAlaClase.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
