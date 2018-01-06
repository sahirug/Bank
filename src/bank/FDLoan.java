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
public class FDLoan extends Loan{
    private String accountNumber;
    private final double penaltyRate = 0.1;
    public FDLoan(String customerNumber, double loanAmount, double monthlyInstallment, int paybackPeriod, int monthlyDeadline, String loanNumber, String accountNumber) {
        super(customerNumber, loanAmount, monthlyInstallment, paybackPeriod, monthlyDeadline, loanNumber);
        this.accountNumber = accountNumber;
    }
    public FDLoan(String loanNumber){
        this.loanNumber = loanNumber;
        setFields();
    }

    public double getPenaltyRate() {
        return penaltyRate;
    }
    
    private void setFields(){
        String sql = "SELECT * FROM loan WHERE loanNumber = '"+this.loanNumber+"'";
        try {
            ResultSet rs = DB.search(sql);
            if(rs.next()){
                this.customerNumber = rs.getString(2);
                this.loanAmount = Double.parseDouble(rs.getString(3));
                this.monthlyInstallment = Double.parseDouble(rs.getString(4));
                this.paybackPeriod = Integer.parseInt(rs.getString(5));
                this.monthlyDeadline = Integer.parseInt(rs.getString(6));
                this.accountNumber =  rs.getString(7);
            }else{
                JOptionPane.showMessageDialog(null, "Something went wrong", "System error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
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
