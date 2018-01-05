/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import Exceptions.InsufficientFundsException;
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
    
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
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
    
    public double deposit(double depositAmount){
        String sql = "UPDATE account SET balance = "+(depositAmount + this.balance)+" WHERE accountNumber = '"+this.accountNumber+"'";
        try {
            DB.insertUpdateDelete(sql);
            CurrentDate cd = new CurrentDate();
            sql = "INSERT INTO transactions(accountNumber, amount, type, date) VALUES('"+this.accountNumber+"', "+depositAmount+", 'deposit', '"+cd.getDate()+"')";
            DB.insertUpdateDelete(sql);
            JOptionPane.showMessageDialog(null, "LKR "+depositAmount+" deposited!", "Deposit success", JOptionPane.INFORMATION_MESSAGE);
            return (depositAmount + this.balance);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0.0;
    }
    
    public double withdraw(double withdrawAmount) throws InsufficientFundsException{
        if(withdrawAmount > this.balance){
            throw new InsufficientFundsException(withdrawAmount);
        }
        String sql = "UPDATE account SET balance = "+(this.balance - withdrawAmount)+" WHERE accountNumber = '"+this.accountNumber+"'";
        try {
            DB.insertUpdateDelete(sql);
            CurrentDate cd = new CurrentDate();
            sql = "INSERT INTO transactions(accountNumber, amount, type, date) VALUES('"+this.accountNumber+"', "+withdrawAmount+", 'withdrawal', '"+cd.getDate()+"')";
            DB.insertUpdateDelete(sql);
            JOptionPane.showMessageDialog(null, "LKR "+withdrawAmount+" withdrawn!", "Withdrawal success", JOptionPane.INFORMATION_MESSAGE);
            return (this.balance - withdrawAmount );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0.0;
    }
}
