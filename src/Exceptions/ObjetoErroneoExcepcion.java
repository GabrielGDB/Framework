package Util.exceptions;

import org.apache.log4j.Logger;

public class ObjetoErroneoExcepcion extends Exception{
    private static Logger log = Logger.getLogger(ObjetoErroneoExcepcion.class);


    public ObjetoErroneoExcepcion(String message) {
        super(message);
        log.error(message);
    }
    
}
