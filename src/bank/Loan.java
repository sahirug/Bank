/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Loan {
    protected double loanAmount, monthlyInstallment;
    protected int paybackPeriod, monthlyDeadline;
    protected String customerNumber, loanNumber;

    public Loan(String customerNumber, double loanAmount, double monthlyInstallment, int paybackPeriod, int monthlyDeadline, String loanNumber) {
        this.customerNumber = customerNumber;
        this.loanAmount = loanAmount;
        this.monthlyInstallment = monthlyInstallment;
        this.paybackPeriod = paybackPeriod;
        this.monthlyDeadline = monthlyDeadline;
        this.loanNumber = loanNumber;
    }
    
    public int createLoan(){
        return 0;
    }
    
    public static int getNewLoanNumber(){
        String sql = "SELECT count(*) FROM loan";
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
    
    public static double getMonthlyPayment(int months, double amount){
        double finalPayable = (((months * 1.25)+100)/100) * amount;
        System.out.println("interest: " + finalPayable);
        double monthlyPayment = finalPayable / months;
        System.out.println("withoutinterest: " + monthlyPayment);
        return Double.parseDouble(new DecimalFormat("#.00").format(monthlyPayment));
    }
}
