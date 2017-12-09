/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ExistingUsernameException extends Exception{
    private String username;

    public ExistingUsernameException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Username " + this.username + " exists";
    }
    
    
}
