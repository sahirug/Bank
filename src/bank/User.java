/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import Exceptions.ExistingUsernameException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class User extends Employee implements EmployeeRegistrationService{
    private String username, password, empID;
    
    public User(){
        
    }

    public User(String username, String password, String employeeID) {
        this.empID = employeeID;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmpID() {
        return empID;
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
        
        String sql = "INSERT INTO user VALUES('"+this.username+"', '"+this.password+"', '"+this.empID+"')";
        int status = 0;
        try{
            this.checkUsername();
            try {
                status = DB.insertUpdateDelete(sql);
                
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.getMessage(), "System error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "System error", JOptionPane.ERROR_MESSAGE);            
            }
        }catch(ExistingUsernameException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Username exists", JOptionPane.ERROR_MESSAGE);
        }
        return status;
    }
    
    public void checkUsername() throws ExistingUsernameException{
        String sql = "SELECT COUNT(*) FROM user WHERE username = '"+this.username+"'";
        int count = 0;
        try {
            ResultSet rs = DB.search(sql);
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());            
        }
        if(count == 1){
             throw new ExistingUsernameException(this.username);
        }
    }
}
