package Util.exceptions;

import org.apache.log4j.Logger;

public class ArchivoConfigPoolNoEncontradoExcepcion extends Exception{
    private static Logger log = Logger.getLogger(ArchivoConfigPoolNoEncontradoExcepcion.class);

    public ArchivoConfigPoolNoEncontradoExcepcion(String mensaje) {
        
        super(mensaje);
        log.error(mensaje);
    }
    
}
