package Util.exceptions;

import org.apache.log4j.Logger;

public class ClaseNoEncontrada extends Exception{
    private final String mensaje = "La clase proporcionada no existe";
    private static Logger log = Logger.getLogger(ClaseNoEncontrada.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
