/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.util.ArrayList;


/**
 *
 * @author Luis
 */
public class evento{
    
    //aqui va estar una lista de parametros

    ArrayList listaParametros;
    
    public evento(){
        listaParametros = new ArrayList();
    }
    
    public void agregarParametro(Object parmetro){
        this.listaParametros.add(parmetro);
    }
    
    public ArrayList getArrayList(){
        return this.listaParametros;
    }
}
