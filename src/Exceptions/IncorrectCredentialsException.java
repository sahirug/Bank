/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author User
 */
public class IncorrectCredentialsException extends Exception{
      public String getMessage(){
          return "Please enter a valid username and password";
      }    
}
