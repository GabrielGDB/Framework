package Util.exceptions;

import org.apache.log4j.Logger;

public class FalloInstanciaDeClase extends Exception{
    
    private final String mensaje = "Ocurrio un error al instanciar la clase controlador proporcionada";
    private static Logger log = Logger.getLogger(FalloInstanciaDeClase.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
