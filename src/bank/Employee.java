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
public class Employee implements CustomerRegistrationService{
    private String employeeID, employeeName, designation;

    public Employee(){
        
    }

    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }
    
    public Employee(String employeeID, String employeeName, String designation) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public int registerCustomer(Customer customerDetails) {
        String sql = "INSERT INTO customer VALUES('"+customerDetails.customerID()+"', '"+customerDetails.customerName()+"', '"+customerDetails.getContactNumber()+"')";
        try {
            return DB.insertUpdateDelete(sql);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    
    }

    @Override
    public void createAccount(Account account) {
    
    }
}
