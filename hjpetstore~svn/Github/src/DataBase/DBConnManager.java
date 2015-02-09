/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author maheshr
 */
public class DBConnManager {
    String sourceURL;
    public DBConnManager(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load JDBC Driver
            sourceURL=new String("jdbc:mysql://localhost:3309/fyp2015"); // Connection URL
        } catch (ClassNotFoundException ex) {
            System.out.println(ex + "------------------------Unable to load database driver classes");
        }
    }
    public Connection connect(){
        Connection dbConn=null;
        try {    
            dbConn= DriverManager.getConnection(sourceURL, "root", "1234");
        } catch (SQLException ex) {
            System.out.println(ex + "---------------------------DB Connection failure");
        }
        return dbConn;
    }
    public void con_close(Connection dbConn){
        try {
            dbConn.close();
        } catch (SQLException ex) {
            System.out.println(ex + "-----------------DB connection closing failure");
        }
    }
}
