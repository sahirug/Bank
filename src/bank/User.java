/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class User extends Employee implements EmployeeRegistrationService{
    private String username, password;
    
    public User(){
        
    }

    public User(String username, String password, String employeeID) {
        super(employeeID);
        this.username = username;
        this.password = password;
    }

    @Override
    public int registerEmployee(Employee employee) {
        String employeeID = employee.getEmployeeID();
        String employeeName = employee.getEmployeeName();
        String designation = employee.getDesignation();
        String sql = "INSERT INTO employee VALUES('"+employeeID+"', '"+employeeName+"', '"+designation+"')";
        try {
            int status = DB.insertUpdateDelete(sql);
            return status;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }
    
    public int registerUser(){
        return 1;
    }
}
