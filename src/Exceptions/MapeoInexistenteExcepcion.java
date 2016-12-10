package Util.exceptions;

import org.apache.log4j.Logger;

public class MapeoInexistenteExcepcion extends Exception{
    private static Logger log = Logger.getLogger(MapeoInexistenteExcepcion.class);


    public MapeoInexistenteExcepcion(String message) {
        super(message);
        log.error(message);
    }
    
}
