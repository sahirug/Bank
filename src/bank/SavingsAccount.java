/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SavingsAccount extends Account{

    public SavingsAccount(String accountNumber, String lastAccessed, String customerID, double balance) {
        super(accountNumber, lastAccessed, customerID, balance);
    }
    
    @Override
    public int createAccount(Account account){
        System.out.println("savinfgs account");
        String accountNumber = account.getAccountNumber();
        double balance = account.getBalance();
        String lastAccessed = account.getLastAccessed();
        String customerID = account.getCustomerID();
        String sql = "INSERT INTO account VALUES('"+accountNumber+"', 'savings', NULL, "+balance+", '"+lastAccessed+"', '"+lastAccessed+"', '"+customerID+"')";
        try {
            return DB.insertUpdateDelete(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0;
    }
}
