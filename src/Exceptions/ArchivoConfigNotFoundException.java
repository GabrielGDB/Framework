package Util.exceptions;

import org.apache.log4j.Logger;

public class ArchivoConfigNotFoundException extends Exception{
    private static Logger log = Logger.getLogger(ArchivoConfigNotFoundException.class);

    
    public ArchivoConfigNotFoundException(String mensaje){        
        super(mensaje);
        log.error(mensaje);
    }
}
