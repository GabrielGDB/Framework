/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitacora;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 *
 * @author A10003074
 */
public class AdminMensajes {
    private Logger registro = Logger.getLogger(AdminMensajes.class);
    
public AdminMensajes(){
        try {
            Properties props = new Properties();
            props.load(getClass().getResourceAsStream("/bitacora/config_bit.properties"));
            PropertyConfigurator.configure(props);
        } catch (IOException e) {
            error(e);
            customError("Ocurrio un error en propiedades del log4j");
        }
    }

    
    public void error(Exception excepcion, Class clase){
        registro.error(
                    "En la siguiente clase "
                    + obtenerNombreClase(clase)
                    + ", Se genero la siguiente exepcion: " 
                    + excepcion
                
        );
        
    }
    public void error(Exception excepcion){
        registro.error(
                    "Se genero la siguiente exepcion: " 
                    + excepcion
                
        );
    }
    public void advertencia(Exception excepcion, Class clase){
        registro.warn(
                    "En la siguiente clase: "
                    + obtenerNombreClase(clase)
                    + ", Se genero la siguiente exepcion: " 
                    + excepcion
                
        );
        
    }
    public void advertencia(Exception excepcion){
        registro.warn(
                    "Se genero la siguiente exepcion: " 
                    + excepcion
                
        );
    }
    
    public void customAdvertencia(String mensaje){
        registro.warn(
                "Se ingreso la siguiente advertencia: "
                + mensaje
        );
    }
    
    public void customAdvertencia(String mensaje, Class clase){
        registro.warn(
                "En la siguiente clase: "
                + obtenerNombreClase(clase)
                + ", Se ingreso la siguiente advertencia: "
                + mensaje
        );
    }

    public void customError(String mensaje){
        registro.error(
                "Se ingreso la siguiente error: "
                + mensaje
        );
    }
    
    public void customError(String mensaje, Class clase){
        registro.error(
                "En la siguiente clase: "
                + obtenerNombreClase(clase)
                + ", Se ingreso la siguiente error: "
                + mensaje
        );
    }
    
    private String obtenerNombreClase(Class clase) {
        return clase.getSimpleName();
    }
    
}
