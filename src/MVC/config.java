/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class config {
    //aqui debe cargar de un archivo plano los servicios
    
    public service[] cargarService() throws FileNotFoundException{
        //va abrir un archivo llamado configuracion y va  leer y crear un lista de servicios
        Scanner fileConfig = new Scanner(new FileReader("config.txt"));
        
        service[] listService = new service[100];
        int numService = 0;
        while(fileConfig.hasNextLine()){
            service service = new service();
            service.setNameService(this.getCallService(fileConfig.nextLine()));
            
            if(!service.getNameService().isEmpty()){
                
                if(fileConfig.hasNextLine()){                  
                    service.setControler(this.getControl(fileConfig.nextLine()));
                    
                    if(!service.getControler().isEmpty()){
                        
                        if(fileConfig.hasNextLine()){
                            service.setMetodo(this.getMetodo(fileConfig.nextLine()));
                            
                            if(!service.getNameService().isEmpty()){
                                listService[numService] = service;
                                numService++;
                            }else{
                                 //excepcion de metodo mal escrito en archivo
                                System.out.println("Error");
                                fileConfig.close();
                                return listService;
                            }
                            
                        }else{
                        //excepcion de ultimo servicio no finalizado
                            System.out.println("Error");
                            fileConfig.close();
                            return listService;
                        }
                        
                    }else{
                        //excepcion de controlador mal escrito en archivo
                        System.out.println("Error");
                        fileConfig.close();
                        return listService;
                    }
                    
                }else{
                    // excepcion de ultimo servicio no finalizado
                    System.out.println("Error");
                    fileConfig.close();
                    return listService;
                }
                
            }else{
                //excepcion de callservice mal escrito en archivo
                System.out.println("Error");
                fileConfig.close();
                return listService;
            }
            
        }

        fileConfig.close();
        return listService;
    }
    
    
    private String getCallService(String line){
        if(line.startsWith("callservice = ")){
            return line.substring(15, line.length()-1);
        }
        
        return null;
    }
    
    private String getControl(String line){
        if(line.startsWith("controlador = ")){
            return line.substring(15, line.length()-1);
        }
        return null;
    }
    
    private String getMetodo(String line){
        if(line.startsWith("metodo = ")){
            return line.substring(10, line.length()-1);
        }
        return null;
    }
    
}
