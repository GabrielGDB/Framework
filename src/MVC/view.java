/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Luis
 */
public class view {
    
    private service[] listService;
    
    public view() throws FileNotFoundException{
        config config = new config();
        this.listService = config.cargarService();
    }
    
    
    public void callService(String service, evento evento){
        int numService = returnService(service);
        
        try{
            if(numService < listService.length){
                Class control = Class.forName(listService[numService].getControler());           
                Object obj = control.newInstance();
                
                Method method = control.getDeclaredMethod(listService[numService].getMetodo(), evento.class);
                method.invoke(obj, evento);
            }else{
            //service not found
            }
        }catch(ClassNotFoundException exp){
            System.out.println("clase no encontrada");
        }catch(InstantiationException exp){
            System.out.println("instancia no creada");
        }catch(IllegalAccessException exp){
            System.out.println("acceso ilegañ");
        }catch(NoSuchMethodException exp){
            System.out.println("metodo no existe");
        }catch(IllegalArgumentException exp){
            System.out.println("argumento ilegal");
        }catch(InvocationTargetException exp){
            System.out.println("error dentro del metodo");
        }
        
        
    }
    
    
    
    //busca en la lista la posicion en donde se encuentra el servicio
    private int returnService(String service){
        for(int numService = 0; numService < listService.length;numService++){
            System.out.println(listService[numService].getNameService());
            if(service.equals(listService[numService].getNameService())){
                return numService;
            }
        }
        return listService.length;
    }
}
