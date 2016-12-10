package Util.exceptions;

import org.apache.log4j.Logger;

public class ArgumentosNoCorrectos extends Exception{
    
    private final String mensaje = "Los argumentos insertados en el método no son correctos";
    private static Logger log = Logger.getLogger(ArgumentosNoCorrectos.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
