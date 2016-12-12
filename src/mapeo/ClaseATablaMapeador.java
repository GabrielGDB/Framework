package mapeo;

import java.util.ArrayList;

public class ClaseATablaMapeador {
    private String nombreClase;
    private String nombreTabla;
    private ArrayList<String> atributosClase;
    private ArrayList<String> camposTabla;
    private int tamaño=0;

    public ClaseATablaMapeador() {
        this.atributosClase = new ArrayList<>();
        this.camposTabla = new ArrayList<>();
    }
    
    
    public void agregar(String atributo, String campo){
        atributosClase.add(atributo);
        camposTabla.add(campo);
        tamaño++;
    }
    
    public int tamaño(){
       return tamaño;
    }
    
    public String getCampo(String atributo){
        
        for(int i=0;i<atributosClase.size();i++){
            if((atributosClase.get(i)).equals(atributo)){
                return camposTabla.get(i);
            }
        }
        return null;
    }

  
    public String getNombreClase() {
        return nombreClase;
    }

    
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

   
    public String getNombreTabla() {
        return nombreTabla;
    }

    
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }
    
   

}