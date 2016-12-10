package pool;

import java.sql.Connection;
import java.util.ArrayList;
import Exceptions.ConnectionsInUseException;
import Exceptions.NotAvailableConnectionsException;

public class ConnectionPool {    
    private static ArrayList<PoolConnection> availablePoolConnections;
    private static ArrayList<PoolConnection> unavailablePoolConnections;
    private static ConnectionPool newPool;
    private static int totalConnections;
    
    private ConnectionPool(){
        this.availablePoolConnections = new ArrayList();
        this.unavailablePoolConnections = new ArrayList();
        createConnections(totalConnections);
    }
    
    public static ConnectionPool getPool(){
        if(newPool == null){
            newPool = new ConnectionPool();
        }        
        return newPool;
    }
    
    public PoolConnection getPoolConnection() throws NotAvailableConnectionsException{
        if(availablePoolConnections.size()>0){
            for (int i = 0; i < availablePoolConnections.size(); i++) {
                if(availablePoolConnections.get(i).isConnected()){
                    unavailablePoolConnections.add(availablePoolConnections.get(i));
                    return availablePoolConnections.get(i);
                }
            }
        }else{
            throw new NotAvailableConnectionsException("Imposible reducir,Hay muchas conexiones en uso");
        }
           
        return null;
    }
    
    public void closeConnection(PoolConnection ActiveConnection){
        availablePoolConnections.remove(ActiveConnection);        
        ActiveConnection.disconnect();
        availablePoolConnections.add(ActiveConnection);                
        unavailablePoolConnections.remove(ActiveConnection);
        updateConnections();
    }
    
    public void updateConnections(){
        for (int i = 0; i < availablePoolConnections.size(); i++) {
            if(!availablePoolConnections.get(i).isConnected()){
                availablePoolConnections.get(i).connect();
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
            throw new ConnectionsInUseException("No Hay Mas Conexiones");
        }else{
            createConnections(totalConnections - unavailablePoolConnections.size());
        }
    }
    
    public static void newNumberOfConnections(int newNumberOfConnections){
        totalConnections = newNumberOfConnections;
    }       
}
