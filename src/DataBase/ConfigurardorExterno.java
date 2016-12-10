
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
public class ConfigurardorExterno {
    String fcambio1,fcambio2;
    MySQL MS = new MySQL();
    String cadena = "";
    
    


    public void ultimoCambioDeArchivo(){
        File fichero = new File("fechaModific");
		Scanner s = null;
		try {
			s = new Scanner(fichero);
			while (s.hasNextLine()) {
				fcambio1 = s.nextLine() + fcambio1;
                                // se lee el archivo que contiene la ultima fecha de modificacion del docuemnto 
			}
		} catch (Exception ex) {
			this.firstTime();
                        // en caso que el archivo no exista se llamara este metodo que lo creara por primera vez
		}
    }
    
    public void firstTime(){
        File f = new File("nombreArchivo");
            try{
                FileWriter w = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(w);
                PrintWriter wr = new PrintWriter(bw); 
                wr.write(Long.toString(f.lastModified()));
                    wr.close();
                    bw.close();

    }
            catch(Exception e){
                
            }
    }
    
    public void configurador (){
       File fichero = new File("Configurador.txt");
       fcambio2 = Long.toString(fichero.lastModified());
       try{
       if (fcambio1 == fcambio2){
           // se leeelarchivodeconfiguracionparaguardarlavariable
            FileReader f = new FileReader("Configurador.txt");
      BufferedReader b = new BufferedReader(f);
           
      while((cadena = b.readLine())!=null) {
          cadena = cadena+cadena;
      }
      b.close();
           // se efectua el archivo "Archivo" que a su vez es el xodigo del JDBC
           
           String segmento[] = new String[4];
           MS.MySQLConnection(segmento[1], segmento[2], segmento[3], segmento[4]);
       }
       
       
       else{
           //se ejecuta el mismo codigo de arriba
           
           // se llamara la funcion de la clase MonitoryFalos, en caso que arroje que el documento ha sido cambiado 
           if (fcambio1 == fcambio2){
           // se leeelarchivodeconfiguracionparaguardarlavariable
            FileReader f = new FileReader("Configurador.txt");
      BufferedReader b = new BufferedReader(f);
           
      while((cadena = b.readLine())!=null) {
          cadena = cadena+cadena;
      }
      b.close();
           // se efectua el archivo "Archivo" que a su vez es el xodigo del JDBC
           
           String segmento[] = new String[4];
           MS.MySQLConnection(segmento[1], segmento[2], segmento[3], segmento[4]);
       }
           //se lanza una excepcion que indica que el archivo de configuracion ha sido cambiado  
           Exception e;
       }
       }
       catch(Exception e){
           // se lanza una excepcion correspondiente a la configuracion de la base de datos
       }
       
    }
    
}
