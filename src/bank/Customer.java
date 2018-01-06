/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Customer{
    private String customerName, customerID, contactNumber;
    List<Account> accounts;
    private List<Loan> loans;

    public Customer(String customerName, String customerID, String contactNumber) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.contactNumber = contactNumber;
    }

    public Customer(String customerName, String customerID, String contactNumber, List<Account> accounts) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.contactNumber = contactNumber;
        this.accounts = accounts;
        setLoans(customerID);
    }

    public String customerName() {
        return customerName;
    }

    public List<Account> getAccounts() {
        return accounts;
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
                String name = rs.getString(2), id = rs.getString(1), contact = rs.getString(3);
                List<Account> accounts = new ArrayList<>();
                rs = Account.getCustomerAccounts(id);
                while(rs.next()){
                    accounts.add(new Account(rs.getString(1), rs.getString(5), id, Double.parseDouble(rs.getString(4))));
                }
                return new Customer(name, id, contact, accounts);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error1", JOptionPane.ERROR_MESSAGE); 
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error2", JOptionPane.ERROR_MESSAGE); 
        }
        return null;
    }

    public void setLoans(String customerNumber) {
        String sql = "SELECT * from loan WHERE customerNumber = '"+customerNumber+"'";
        this.loans = new ArrayList<>();
        try {
            ResultSet rs = DB.search(sql);
            while(rs.next()){
                System.out.println("fshf");
                Loan loan = new Loan(rs.getString(2), Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(4)), Integer.parseInt(rs.getString(5)), Integer.parseInt(rs.getString(6)), rs.getString(1));
                this.loans.add(loan);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error1", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "System error2", JOptionPane.ERROR_MESSAGE); 
        }
    }

    public List<Loan> getLoans() {
        return loans;
    }
    
    
    
    
    
    
}
