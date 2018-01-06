/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import Exceptions.InsufficientFundsException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SavingsAccount extends Account{
    
    private List<Transaction> transactions; 

    public SavingsAccount(String accountNumber, String lastAccessed, String customerID, double balance) {
        super(accountNumber, lastAccessed, customerID, balance);
    }
    
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
        setTransactions(accountNumber);
    }

    public void setTransactions(String accountNumber) {
        String sql = "SELECT * FROM transactions WHERE accountNumber = '"+accountNumber+"'";
        try {
            ResultSet rs = DB.search(sql);
            this.transactions = new ArrayList<>();
            while(rs.next()){
                Transaction transaction = new Transaction(rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5));
                this.transactions.add(transaction);
            }
            System.out.println(this.transactions.size());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
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
            Transaction transaction = new Transaction(this.accountNumber, depositAmount, "deposit", cd.getDate());
            if(transaction.create() == 1){
                JOptionPane.showMessageDialog(null, "LKR "+depositAmount+" deposited!", "Deposit success", JOptionPane.INFORMATION_MESSAGE);
                return (depositAmount + this.balance);
            }
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
            Transaction transaction = new Transaction(this.accountNumber, withdrawAmount, "withdrawal", cd.getDate());
            if(transaction.create() == 1){
                JOptionPane.showMessageDialog(null, "LKR "+withdrawAmount+" withdrawn!", "Withdrawal success", JOptionPane.INFORMATION_MESSAGE);
                return (this.balance - withdrawAmount );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0.0;
    }
    
    public void closeAccount(){
        String sql = "DELETE FROM transactions WHERE accountNumber = '"+this.accountNumber+"'";
        try {
            DB.insertUpdateDelete(sql);
            sql = "DELETE FROM account WHERE accountNumber = '"+this.accountNumber+"'";
            DB.insertUpdateDelete(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
    }
}
