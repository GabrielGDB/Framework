/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

/**
 *
 * @author dell
 */
public class AccessManager {
    
    int maxIntents;
    
    public void setMaxNumberIntents(int maxIntents){
        this.maxIntents = maxIntents;
    }
    
    public void decreaseIntentes(){
        maxIntents--;
    }
    
    public int getIntents(){
        return maxIntents;
    }
    
    public boolean validateOperation(){
        return maxIntents != 0;
    }
}
