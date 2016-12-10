package pool;

import Exceptions.ConexionBDException;
import java.sql.Connection;
import java.util.ArrayList;
import Exceptions.ConnectionsInUseException;
import Exceptions.NotAvailableConnectionsException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {    
    private static ArrayList<PoolConnection> conexionesLibres;
    private static ArrayList<PoolConnection> conexionesOcupadas;
    private static int conexionesTotales;
    private Connection baseConnection;
    
    private ConnectionPool(String host, String user, String pass, String db_name) throws ConexionBDException{
        this.conexionesLibres = new ArrayList();
        this.conexionesOcupadas = new ArrayList();
        createConnections(conexionesTotales);
        baseConnection = getConnectionFromData(host,user,pass,db_name);
    }
    
    public PoolConnection getPoolConnection() throws NotAvailableConnectionsException{
        if(conexionesLibres.size()>0){
            for (int i = 0; i < conexionesLibres.size(); i++) {
                if(conexionesLibres.get(i).isConnected()){
                    conexionesOcupadas.add(conexionesLibres.get(i));
                    return conexionesLibres.get(i);
                }
            }
        }else{
            throw new NotAvailableConnectionsException("Imposible reducir,Hay muchas conexiones en uso");
        }
           
        return null;
    }
    
    public void closeConnection(PoolConnection ActiveConnection){
        conexionesLibres.remove(ActiveConnection);        
        ActiveConnection.disconnect();
        conexionesLibres.add(ActiveConnection);                
        conexionesOcupadas.remove(ActiveConnection);
        updateConnections();
    }
    
    public void updateConnections(){
        for (int i = 0; i < conexionesLibres.size(); i++) {
            if(!conexionesLibres.get(i).isConnected()){
                conexionesLibres.get(i).connect();
            }
        }
    }
    
    private static void createConnections(int numberOfConnections) {
        for (int i = 0; i < numberOfConnections; i++) {
            Connection connection = null;
            PoolConnection newConnection = new PoolConnection(connection);
            conexionesLibres.add(newConnection);
        }
    }
    
    public static void changeConnections() throws ConnectionsInUseException{
        if(conexionesTotales < conexionesOcupadas.size()){
            throw new ConnectionsInUseException("No Hay Mas Conexiones");
        }else{
            createConnections(conexionesTotales - conexionesOcupadas.size());
        }
    }
    
    public static void newNumberOfConnections(int newNumberOfConnections){
        conexionesTotales = newNumberOfConnections;
    }
    
    public Connection getConnectionFromData(String host, String user, String pass, String db_name) throws ConexionBDException {
        try {
            baseConnection = DriverManager.getConnection(host + '/' + db_name, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (Connection) baseConnection;
    }
}
