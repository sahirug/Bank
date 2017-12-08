/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

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
    public void registerCustomer(Customer customerDetails) {
    
    }

    @Override
    public void createAccount(Account account) {
    
    }
}
