package Util.exceptions;

import org.apache.log4j.Logger;

public class ViolacionDeSeguridad extends Exception{
    
    private final String mensaje = "Ha habido una violación de seguridad";    
    private static Logger log = Logger.getLogger(ViolacionDeSeguridad.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
