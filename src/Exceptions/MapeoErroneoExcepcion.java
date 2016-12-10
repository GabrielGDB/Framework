package Util.exceptions;

import org.apache.log4j.Logger;

public class MapeoErroneoExcepcion extends Exception{
    private static Logger log = Logger.getLogger(MapeoErroneoExcepcion.class);


    public MapeoErroneoExcepcion(String message) {
        super(message);
        log.error(message);
    }

    
    
}
