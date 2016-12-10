package Util.exceptions;

import org.apache.log4j.Logger;

public class ErrorPoolConfigException extends Exception {
     private static Logger log = Logger.getLogger(ErrorPoolConfigException.class);

    
    public ErrorPoolConfigException(String mensaje){
        super(mensaje);
        log.error(mensaje);
    }
}
