package Util.exceptions;

import org.apache.log4j.Logger;

public class MetodoNoExiste extends Exception{
    
    private final String mensaje = "El método no existe";
    private static Logger log = Logger.getLogger(MetodoNoExiste.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
