package Util.exceptions;

import org.apache.log4j.Logger;

public class NotAvailableConnectionsException extends Exception {
    private static Logger log = Logger.getLogger(NotAvailableConnectionsException.class);

    
    public NotAvailableConnectionsException(String mensaje){
        super(mensaje);
        log.error(mensaje);
    }
}
