package Util.exceptions;

import org.apache.log4j.Logger;

public class NoEsSubclaseControlador extends Exception{
    private final String mensaje = "La clase proporcionada no es subclase de Controlador";
    private static Logger log = Logger.getLogger(NoEsSubclaseControlador.class);
    
    public String getMensaje(){
        log.error(mensaje);
        return mensaje;
    }
}
