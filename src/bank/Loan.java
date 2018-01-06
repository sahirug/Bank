/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Loan {
    protected double loanAmount, monthlyInstallment;
    protected int paybackPeriod, monthlyDeadline;
    protected String customerNumber, loanNumber;
    protected List<Installment> installments;

    public Loan(){
        
    }
    
    public Loan(String loanNumber){
        this.loanNumber = loanNumber;
    }
    
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

    public String getLoanNumber() {
        return loanNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public int getPaybackPeriod() {
        return paybackPeriod;
    }

    public int getMonthlyDeadline() {
        return monthlyDeadline;
    }
    
    public void setInstallments(){
        String sql = "SELECT * FROM installment WHERE loanNumber = '"+this.loanNumber+"'";
        try {
            ResultSet rs = DB.search(sql);
            this.installments = new ArrayList<>();
            while(rs.next()){
                Installment installment = new Installment(this.loanNumber, rs.getString(4), rs.getDouble(3));
                this.installments.add(installment);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
    }

    public List<Installment> getInstallments() {
        return installments;
    }
    
    public static String getType(String loanNumber){
        String sql = "SELECT type FROM loan WHERE loanNumber = '"+loanNumber+"'";
        try {
            ResultSet rs = DB.search(sql);
            if(rs.next()){
                return rs.getString(1); 
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return null;
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
    
    public void settleLoan(){
        String sql = "DELETE FROM installment WHERE loanNumber = '"+this.loanNumber+"'";
        try {
            DB.insertUpdateDelete(sql);
            sql = "DELETE FROM loan WHERE loanNumber = '"+this.loanNumber+"'";
            DB.insertUpdateDelete(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
    }
}
