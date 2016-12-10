package Util.exceptions;

import org.apache.log4j.Logger;

public class ConnectionsInUseException extends Exception {
    private static Logger log = Logger.getLogger(ConnectionsInUseException.class);

    public ConnectionsInUseException(String mensaje){
        super(mensaje);
        log.error(mensaje);
    }
}
