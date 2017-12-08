/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.List;

/**
 *
 * @author User
 */
public class Customer{
    private String name;
    List<Account> accounts;
    List<Loan> loans;

    public Customer(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }
    
    
    
}
