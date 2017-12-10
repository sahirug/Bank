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
public class Loan {
    private Customer customer;
    private double loanAmount, monthlyInstallment;
    private int paybackPeriod;
    private String monthlyDeadline;
    
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
}
