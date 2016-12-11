/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dell
 */
public class VerificadorContraseña {
    
    private Pattern pattern;
    private Matcher matcher;

    private static final String PATRON_CONTRASEÑA = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";

    public VerificadorContraseña() {
        pattern = Pattern.compile(PATRON_CONTRASEÑA);
    }

    public boolean validar(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
}
