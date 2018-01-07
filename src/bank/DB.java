/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DB {
    static Connection c;
    
    public static void createConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        DB.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
    }
    
    public static int insertUpdateDelete(String sql) throws Exception{
        if(c == null || c.isClosed()){
            createConnection();
            System.out.println(c.isClosed());
        }
        return c.createStatement().executeUpdate(sql);
    }
    
    public static ResultSet search(String sql) throws Exception{
        if(c == null)
            createConnection();
        return c.createStatement().executeQuery(sql);
    }
    
    public static void closeConnection() throws SQLException{
        c.close();
    }
}
