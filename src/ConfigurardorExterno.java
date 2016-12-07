
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
public class ConfigurardorExterno {
    String fcambio1,fcambio2;
    boolean fisrt = false;
    MySQL MS = new MySQL();
    ConnectionPoolManager pool = new ConnectionPoolManager();
    
    


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
                        this.fisrt = true;
		}
    }
    
    public void firstTime(){
        File fichero = new File("Configurador.txt"); // nombre del archvo de configuracion de la base de datos 
        // se escribira el archico plano con el nombre fechaModific
        // el cual en su interior tendra en milesegundos la ultima fecha de modificaicon 
    }
    public void configurador (){
       File fichero = new File("Configurador.txt");
       fcambio2 = Long.toString(fichero.lastModified());
       try{
       if (fcambio1 == fcambio2){
           // se ejecuta todo el archivo de configuracion en reflexion de el archivo plano de java es dercir se llama todos los metodos de MySQL  junto con el configurador externo
          MS.MySQLConnection(algo, algo, algo);
         pool.getConnectionFromPool();
           // se efectua el archivo "Archivo" que a su vez es el xodigo del JDBC
       }
       else{
           //se ejecuta el mismo codigo de arriba
           
           // se llamara la funcion de la clase MonitoryFalos, en caso que arroje que el documento ha sido cambiado 
           //se lanza una excepcion que indica que el archivo de configuracion ha sido cambiado 
       }
       }
       catch(Exception e){
           // se lanza una excepcion correspondiente a la configuracion de la base de datos
       }
       
    }
    
}
