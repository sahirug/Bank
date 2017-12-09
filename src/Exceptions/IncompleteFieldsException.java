/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author User
 */
public class IncompleteFieldsException extends Exception{

    private String message;
    
    public IncompleteFieldsException() {
        
    }

    public IncompleteFieldsException(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return "Please complete all fields";
    }
    
    public String getMessage(String message) {
        return message;
    }
    
    public String getErrorTitle(){
        return "Incomplete Fields";
    }
    
}
