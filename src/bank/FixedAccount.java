/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FixedAccount extends Account{
    private String maturityPeriod;

    public FixedAccount(String accountNumber, String lastAccessed, String customerID, double balance, String maturityPeriod) {
        super(accountNumber, lastAccessed, customerID, balance);
        this.maturityPeriod = maturityPeriod;
    }

    public String getMaturityPeriod() {
        return maturityPeriod;
    }
    
    @Override
    public int createAccount(Account account){
        System.out.println("fixed account");
        String accountNumber = account.getAccountNumber();
        double balance = account.getBalance();
        String lastAccessed = account.getLastAccessed();
        String customerID = account.getCustomerID();
        String maturityPeriod = this.getMaturityPeriod();
        String sql = "INSERT INTO account VALUES('"+accountNumber+"', 'fixed', '"+maturityPeriod+"', "+balance+", '"+lastAccessed+"', '"+lastAccessed+"', '"+customerID+"')";
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
    
    public static double getFinalAmount(int months, double amount, double rate){
        double finalAmount = amount * Math.pow((1 + (rate/1200)), months);
        return Double.parseDouble(new DecimalFormat("#.00").format(finalAmount));
    }
    
    public double[] getCompoundInterest(){
        double newAmount = this.balance;
        double monthlyBalance[] = new double[Integer.parseInt(this.getMaturityPeriod())];
        for(int i = 0; i < Integer.parseInt(this.getMaturityPeriod()); i++){
           newAmount = newAmount + (newAmount * (0.15/12));
//            System.out.println(new DecimalFormat("#.00").format(newAmount));
            monthlyBalance[i] = Double.parseDouble(new DecimalFormat("#.00").format(newAmount));
        }
        return monthlyBalance;
    }
    
}
