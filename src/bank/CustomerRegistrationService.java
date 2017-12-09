/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author User
 */
public interface CustomerRegistrationService {
    public int registerCustomer(Customer customerDetails);
    public void createAccount(Account account);
}
