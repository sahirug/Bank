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
public class NormalLoan extends Loan{
    private final double penaltyRate = 0.15;
    public NormalLoan(String customerNumber, double loanAmount, double monthlyInstallment, int paybackPeriod, int monthlyDeadline, String loanNumber) {
        super(customerNumber, loanAmount, monthlyInstallment, paybackPeriod, monthlyDeadline, loanNumber);
    }
    
    public NormalLoan(String loanNumber){
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
        String sql = "INSERT INTO loan(loannumber, customerNumber, loanAmount, installment ,paybackPeriod, monthlydeadline, type) VALUES('"+this.loanNumber+"', '"+this.customerNumber+"', "+this.loanAmount+", "+this.monthlyInstallment+", '"+this.paybackPeriod+"', "+this.monthlyDeadline+", 'Normal')";
        System.out.println(sql);
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
