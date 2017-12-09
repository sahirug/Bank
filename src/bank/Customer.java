/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Customer{
    private String customerName, customerID, contactNumber;
    List<Account> accounts;
    List<Loan> loans;

    public Customer(String customerName, String customerID, String contactNumber) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.contactNumber = contactNumber;
    }

    public String customerName() {
        return customerName;
    }

    public String customerID() {
        return customerID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public static Customer getDetails(String customerID){
        String sql = "SELECT * FROM customer WHERE customerID = '"+customerID+"'";
        try {
            ResultSet rs = DB.search(sql);
            if(rs.next()){
                return new Customer(rs.getString(2), rs.getString(1), rs.getString(3));
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE); 
        }
        return null;
    }
    
    
    
}
