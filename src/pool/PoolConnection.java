package pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PoolConnection {
    private boolean isConnected;
    private Connection connection;
    
    public PoolConnection(Connection connection){
        this.isConnected = true;
        this.connection = connection;
    }
    
    public ResultSet request(String query) throws SQLException{
        ResultSet result = connection.prepareStatement(query).executeQuery();
        return result; 
    }
    
    public void disconnect(){
        this.isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }
    
    public void connect(){
        this.isConnected = true;
    }
}
