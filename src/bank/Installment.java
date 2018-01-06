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
public class Installment {
    private String loanNumber, date;
    private double amount;

    public Installment(String loanNumber, String date, double amount) {
        this.loanNumber = loanNumber;
        this.date = date;
        this.amount = amount;
    }
    
    public int create(){
        String sql = "INSERT INTO installment(loanNumber, installmentAmount, date) VALUES('"+this.loanNumber+"', "+this.amount+", '"+this.date+"')";
        try {
            return DB.insertUpdateDelete(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
