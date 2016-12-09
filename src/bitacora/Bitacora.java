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
public class Bitacora {
    private Logger registro = Logger.getLogger(Bitacora.class);
    
public Bitacora(){
        try {
            Properties props = new Properties();
            props.load(getClass().getResourceAsStream("/bitacora/config_bit.properties"));
            PropertyConfigurator.configure(props);
        } catch (IOException e) {
            error(e);
            System.err.println("Ocurrio un error en propiedades del log4j");
        }
    }

    
    public void error(Exception e, Class clazz){
        registro.error(
                    "En la siguiente clase "
                    + getClassName(clazz)
                    + ", Se genero la siguiente exepcion: " 
                    + e
                
        );
        
    }
    public void error(Exception e){
        registro.error(
                    "Se genero la siguiente exepcion: " 
                    + e
                
        );
    }
    public void warn(Exception e, Class clazz){
        registro.warn(
                    "En la siguiente clase: "
                    + getClassName(clazz)
                    + ", Se genero la siguiente exepcion: " 
                    + e
                
        );
        
    }
    public void warn(Exception e){
        registro.warn(
                    "Se genero la siguiente exepcion: " 
                    + e
                
        );
    }
    
    public void customWarn(String message){
        registro.warn(
                "Se ingreso la siguiente advertencia: "
                + message
        );
    }
    
    public void customWarn(String message, Class clazz){
        registro.warn(
                "En la siguiente clase: "
                + getClassName(clazz)
                + ", Se ingreso la siguiente advertencia: "
                + message
        );
    }

    public void customError(String message){
        registro.error(
                "Se ingreso la siguiente error: "
                + message
        );
    }
    
    public void customError(String message, Class clazz){
        registro.error(
                "En la siguiente clase: "
                + getClassName(clazz)
                + ", Se ingreso la siguiente error: "
                + message
        );
    }
    
    private String getClassName(Class clazz) {
        return clazz.getSimpleName();
    }
    
    public static void easterEgg(){
        int caso = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        switch(caso){
            case 1:
                System.out.println("Bitacora de Buzz Lightyear, no detecto vida inteligente");
                break;
            case 2:
                System.err.println("Primero estás defendiendo toda la galaxia y, de pronto te encuentras tomando té de Deerjaling con María Antonieta y su hermanita.");
                break;
            default:
                break;
        }
        
    }
}
