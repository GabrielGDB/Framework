package aka;


import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class MonitoryFallos {
    String archivo = "";
    boolean cambio = false;
    public void opener(){// se debe iniciar junto con el programa 
        File fichero = new File("Archivo");
		Scanner s = null;
		try {
			s = new Scanner(fichero);
			while (s.hasNextLine()) {
				archivo = s.nextLine()+ archivo;  
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
    }
    
    
    public void Monitor (String plano){ //este metodo debe estar en constante ejecucion para saber si ha habido cambio en el archivo de configuracion
    if(plano != archivo)
        cambio = true;
    }
    
}