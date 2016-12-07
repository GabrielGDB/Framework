
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lovom
 */
public class MySQL {
    private static Connection connection;
    
    

  
public Connection MySQLConnection(String host, String user, String pass, String db_name) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(host + db_name, user, pass);
            JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
       return connection;
}


 public void closeConnection() {
        try {
            connection.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



 public void createDB(String host,String name) throws Exception {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            closeConnection();
            MySQLConnection(host,"root", "", name);
JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 

 public void createTable(String name, String idvar1, String idvar2) {
        try {
            String Query = "CREATE TABLE " + name + ""
                    + idvar1
                    + idvar2;

            Statement st = connection.createStatement();
            st.executeUpdate(Query);
JOptionPane.showMessageDialog(null, "Se ha creado la tabla " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

 public void insertData(String table_name, String ID, String name, String lastname, String age, String gender) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + lastname + "\", "
                    + "\"" + age + "\", "
                    + "\"" + gender + "\")";
            Statement st = connection.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }

}


// lo que se planea hacer es que se lea el archivop de configuracion y este remplaze las variables que por lo general se piden al momento