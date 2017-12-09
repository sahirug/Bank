/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Account {
    private String accountNumber, lastAccessed, customerID;
    private double balance;

    public Account(String accountNumber, String lastAccessed, String customerID, double balance) {
        this.accountNumber = accountNumber;
        this.lastAccessed = lastAccessed;
        this.customerID = customerID;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getLastAccessed() {
        return lastAccessed;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }
    
    public static int getNewAccountNumber(){
        String sql = "SELECT count(*) FROM account";
        try {
            ResultSet rs = DB.search(sql);
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 1;
    }
    
    public int createAccount(Account account){
        System.out.println("hello from account class");
        return 0;
    }
}
