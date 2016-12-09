/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.util.Scanner;

/**
 *
 * @author dell
 */
public class UserInterface {
    
    public void printMessage(String message){
        System.out.println(message);
    }
    
    public String getInput(){
        Scanner scanner =  new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }
    
}
