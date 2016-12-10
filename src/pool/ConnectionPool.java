package pool;

import java.sql.Connection;
import java.util.ArrayList;
import Util.exceptions.ConnectionsInUseException;
import Util.exceptions.NotAvailableConnectionsException;

public class ConnectionPool {    
    private static ArrayList<PoolConnection> availablePoolConnections;
    private static ArrayList<PoolConnection> unavailablePoolConnections;
    
    private static int totalConnections;
    
    private final static String NOT_AVAILABLE_CONNECTIONS = "No Hay Conexiones Disponibles";
    private final static String IMPOSSIBLE_REDUCE_CONNECTIONS = "Imposible reducir "+ "el número de conexiones. Hay conexiones en uso";
    
    private ConnectionPool(){
        this.availablePoolConnections = new ArrayList();
        this.unavailablePoolConnections = new ArrayList();
        createConnections(totalConnections);
    }
    
    public PoolConnection getPoolConnection() throws NotAvailableConnectionsException{
        if(availablePoolConnections.size()>0){
            for (int i = 0; i < availablePoolConnections.size(); i++) {
                if(availablePoolConnections.get(i).isConnectionActive()){
                    unavailablePoolConnections.add(availablePoolConnections.get(i));
                    return availablePoolConnections.get(i);
                }
            }
        }else{
            throw new NotAvailableConnectionsException(NOT_AVAILABLE_CONNECTIONS);
        }
           
        return null;
    }
    
    public void closeConnection(PoolConnection pc){
        availablePoolConnections.remove(pc);        
        pc.closeConnection();
        availablePoolConnections.add(pc);                
        unavailablePoolConnections.remove(pc);
        updateConnections();
    }
    
    public void updateConnections(){
        for (int i = 0; i < availablePoolConnections.size(); i++) {
            if(!availablePoolConnections.get(i).isConnectionActive()){
                availablePoolConnections.get(i).activateConnection();
            }
        }
    }
    
    private static void createConnections(int numberOfConnections) {
        for (int i = 0; i < numberOfConnections; i++) {
            Connection connection = null;
            PoolConnection pc = new PoolConnection(connection);
            availablePoolConnections.add(pc);
        }
    }
    
    public static void changeConnections() throws ConnectionsInUseException{
        if(totalConnections < unavailablePoolConnections.size()){
            throw new ConnectionsInUseException(IMPOSSIBLE_REDUCE_CONNECTIONS);
        }else{
            createConnections(totalConnections - unavailablePoolConnections.size());
        }
    }
    
    public static void changeNumberOfConnections(int newNumberOfConnections){
        totalConnections = newNumberOfConnections;
    }       
}
