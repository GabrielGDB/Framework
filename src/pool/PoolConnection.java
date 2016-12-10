package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PoolConnection {
    private boolean active;
    private Connection connection;
    
    public PoolConnection(Connection connection){
        this.active = true;
        this.connection = connection;
    }
    
    public ResultSet query(String query) throws SQLException{
        ResultSet result = null;
        PreparedStatement request = connection.prepareStatement(query);
        result = request.executeQuery();
        return result; 
    }
    
    public void closeConnection(){
        this.active = false;
    }

    public boolean isConnectionActive() {
        return active;
    }
    
    public void activateConnection(){
        this.active = true;
    }
}
