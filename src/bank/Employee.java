/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author User
 */
public class Employee {
    private String employeeID, employeeName;

    public Employee(String employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
