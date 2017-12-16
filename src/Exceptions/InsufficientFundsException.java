/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author User
 */
public class InsufficientFundsException extends Exception {

    private double loanAmount;
    private double balance, withdrawAmount;

    public InsufficientFundsException(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
    
    
    
    
    @Override
    public String getMessage() {
        return "Insufficient funds to make that transaction!";
    }
    
    public String getMessage(double maxAmount, double loanAmount){
        return "The loan amount: "+loanAmount+" exceeded the maximum amount: "+maxAmount;
    }
    
}
