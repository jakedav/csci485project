import java.io.*;
import java.sql.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    
    
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
            user u = new user(conn);
            u.start(reader);
        
        
        
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
}
