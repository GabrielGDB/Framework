/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Luis
 */
public class view {
    
    private service[] listService;
    
    public view(service[] listService){
        listService = listService;
    }
    
    
    public void callService(String service, evento evento) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        int numService = returnService(service);
        
        if(numService < listService.length){
            Class control = Class.forName(listService[numService].getControl());           
            Object obj = control.newInstance();
            Method method = control.getDeclaredMethod(listService[numService].getMetodo(), evento.class);
            method.invoke(obj, evento);
        }else{
            //service not found
        }
        
    }
    
    //busca en la lista la posicion en donde se encuentra el servicio
    private int returnService(String service){
        for(int numService = 0; numService < listService.length;numService++){
            boolean isEquals = service.equals(listService[numService].getNameService());
            if(isEquals == true){
                return numService;
            }
        }
        return listService.length;
    }
}
