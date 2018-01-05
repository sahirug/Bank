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
public class FDLoan extends Loan{
    private String accountNumber;
    public FDLoan(String customerNumber, double loanAmount, double monthlyInstallment, int paybackPeriod, int monthlyDeadline, String loanNumber, String accountNumber) {
        super(customerNumber, loanAmount, monthlyInstallment, paybackPeriod, monthlyDeadline, loanNumber);
        this.accountNumber = accountNumber;
    }

    @Override
    public int createLoan() {
        String sql = "INSERT INTO loan(loannumber, customerNumber, loanAmount, installment ,paybackPeriod, monthlydeadline, accountNumber, type) VALUES('"+this.loanNumber+"', '"+this.customerNumber+"', "+this.loanAmount+", "+this.monthlyInstallment+", '"+this.paybackPeriod+"', "+this.monthlyDeadline+", '"+this.accountNumber+"', 'FD')";
        System.out.println(sql);
        try {
            return DB.insertUpdateDelete(sql);//return value when loan create success
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return 0;
    }
    
    
    
}
