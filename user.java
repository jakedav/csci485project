import java.io.*;
import java.sql.*;
import java.lang.*;
/**
 * Write a description of class login here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class user
{
    // instance variables
    public static int userType, userOption,username,newUser,newGradYear;
    public static String  password, query, query2, query3, userCheck,newPass,newFName,newLName,newMajor,newJobTitle, newEmail, newMsgs;
    public static boolean insert;
    private Connection conn;
    private ResultSet rs,rs1,rs2;
    private Statement statement;
    public user(Connection con){
        try{
            conn = con;
            statement = con.createStatement();
            rs = statement.executeQuery("Select FirstName from Userlist");
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void start(BufferedReader reader){
        try{
            System.out.println("Admin(0)? Or User(1)");
            userType = Integer.parseInt(reader.readLine());
            if(userType == 1){
                //user options
                System.out.println("Login(0)? Or Register(1)");
                userOption = Integer.parseInt(reader.readLine());

                if(userOption == 0){
                    //user login
                    System.out.println("Enter Username");
                    username = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Password");
                    password = reader.readLine();
                    query = "select * from Userlist where StfxID ='" + username + "' and Password= '" + password + "'";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    rs = stmt.executeQuery();
                    if (rs.next()){
                        System.out.println("Login Succesful");
                        
                    }
                    
                    else {
                        System.out.println("Login Unsuccesful");
                    }

                    query2 = "select * from Userlist where StfxID ='" + username + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    if(rs1.next()){
                      System.out.println(rs1.getInt("UserID")); 
                      System.out.println(rs1.getInt("StfxID"));
                      System.out.println(rs1.getString("Password")); 
                      System.out.println(rs1.getString("FirstName"));
                      System.out.println(rs1.getString("LastName"));
                      System.out.println(rs1.getString("Major"));
                      System.out.println(rs1.getString("JobTitle"));
                      System.out.println(rs1.getInt("GradYear"));
                      System.out.println(rs1.getString("Email"));
                      System.out.println(rs1.getString("Msgs"));
                  }

                }     
                else if(userOption == 1){
                    //user register
                    System.out.println("New User (Stfx ID)");
                    newUser = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Password");
                    newPass = reader.readLine();
                    System.out.println("Enter first Name");
                    newFName = reader.readLine();
                    System.out.println("Enter last Name");
                    newLName = reader.readLine();
                    System.out.println("Enter Major");
                    newMajor = reader.readLine();
                    System.out.println("Enter Job Title");
                    newJobTitle = reader.readLine();
                    System.out.println("Enter year of graduation");
                    newGradYear = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Email");
                    newEmail = reader.readLine();
                    query3 = "insert into Userlist (StfxID, Password, FirstName, LastName, Major, JobTitle, GradYear, Email) values(?,?,?,?,?,?,?,?)";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);
                    stmt2.setInt(1, newUser);
                    stmt2.setString(2, newPass);
                    stmt2.setString(3, newFName);
                    stmt2.setString(4, newLName);
                    stmt2.setString(5, newMajor);
                    stmt2.setString(6, newJobTitle);
                    stmt2.setInt(7, newGradYear);
                    stmt2.setString(8, newEmail);             
                    insert = stmt2.execute();
                      if(insert == false){
                          System.out.println("Registration Succesful");
                        }
                      else{
                          System.out.println("Registration Unsuccesful");
                        }

                }
                else{
                    System.out.println("Invalid entry, please try again"); 
                    System.out.println("Admin(0)? Or User(1)");
                    userType = Integer.parseInt(reader.readLine());

                }
            }
            else if(userType == 2){
                //admin options

            }
            else{
                System.out.println("Invalid entry, please try again");  
                System.out.println("Admin(0)? Or User(1)");
                userType = Integer.parseInt(reader.readLine());

            }
            /* try{

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Userlist");
            while (rs.next()){
            System.out.println(
            rs.getInt("UserID")+ ","+ rs.getInt("StfxID")+","+rs.getString("Password") +",'"+ rs.getString("FirstName")+",'"+rs.getString("LastName")+",'"+rs.getString("Major")+",'"+rs.getString("JobTitle")+",'"+rs.getInt("GradYear")+",'"+rs.getString("Email")+",'"+rs.getString("Msgs"));
            }
            }
            catch(Exception e){
            e.printStackTrace();
            }*/
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

