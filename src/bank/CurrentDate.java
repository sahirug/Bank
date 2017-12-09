/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class CurrentDate {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private final Date date = new Date();
    
    public String getDate(){
        return this.dateFormat.format(this.date);
    }
}
