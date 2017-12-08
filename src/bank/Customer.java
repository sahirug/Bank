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
public class Customer implements CustomerRegistrationService{
    private String name;
    List<Account> accounts;
    List<Loan> loans;

    public Customer(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }    
    
    @Override
    public void register(Customer customerDetails) {
        
    }

    @Override
    public void createAccount(Account account) {
        
    }
    
    
    
}
