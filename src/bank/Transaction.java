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
public class Transaction {
    private String accountNumber, type, date;
    private double amount;

    public Transaction(String accountNumber, double amount, String type, String date) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.date = date;
        this.amount = amount;
    }
    
    public int create(){
        String sql = "INSERT INTO transactions(accountNumber, amount, type, date) VALUES('"+this.accountNumber+"', "+this.amount+", '"+this.type+"', '"+new CurrentDate().getDate()+"')";
        try {
            return DB.insertUpdateDelete(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
