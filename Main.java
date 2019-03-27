
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.lang.String;

public class Main extends Application {

    public Statement stmt;

    public Button view = new Button("View");
    public Button insert = new Button("Insert");
    public Button update = new Button("Update");
    public Button clear = new Button("Clear");
    public Button clearSQLResult = new Button("Clear Result");
    public Button connect = new Button("Connect DB");
    public Button loginbtn = new Button("Login");
    public Button loginbtn2 = new Button("Login");
    public Button registerbtn = new Button("Register");
    public Button search = new Button("Search");
    public Button searchName = new Button("Search Name");
    public Button searchMajor = new Button("Search Major");
    public Button searchEmailMajor = new Button("Search Emails by Major");
    public Button editUser = new Button("Edit User");
    public Button regUserbtn = new Button("Register");
    public Button back1 = new Button("Back");
    public Button back2 = new Button("Back");
    public Button back3 = new Button("Back");
    public Button back4 = new Button("Back");
    public Button back5 = new Button("Back");
    public Button yourProfile = new Button("Profile");
    public Button editYrProfile = new Button("Edit Profile");
    public Button saveEditsUser = new Button("Save Changes");
    public Button logOutUser = new Button("Logout");
    public Button adminloginbtn = new Button("Login");
    public Button edits = new Button("Update/Add/Delete Entry");
    public Button adminAdd = new Button("Add Entry");
    public Button adminDelete= new Button("Delete Entry");
    public Button adminUpdate= new Button("Update Entry");
    public Button sendEmail = new Button("Send Email");
    public Button deleteMsgs = new Button("Delete Emails");
    
    
    

    public TextField email = new TextField();
    public TextField firstname = new TextField();
    public TextField lastname = new TextField();
    public TextField address = new TextField();
    public TextField ID = new TextField();
    public TextField StfxID = new TextField();
    public TextField password = new TextField();
    public TextField regpassword = new TextField();
    public TextField uppassword = new TextField();
    public TextField uppassword1 = new TextField();
    public TextField job = new TextField();
    public TextField majorStudy = new TextField();
    public TextField yearGraduated = new TextField();
    public TextField userSearching = new TextField();
    public TextField adminUserSearching = new TextField();
    public TextArea result = new TextArea();
    public TextArea result1 = new TextArea();
    public TextArea result2 = new TextArea();
    public TextArea result3 = new TextArea();
    public TextArea result4 = new TextArea();
    public TextArea msgs = new TextArea();

    public TextField email2 = new TextField();
    public TextField firstname2 = new TextField();
    public TextField lastname2 = new TextField();
    public TextField StfxID2 = new TextField();
    public TextField password2 = new TextField();
    public TextField job2 = new TextField();
    public TextField majorStudy2 = new TextField();
    public TextField yearGraduated2 = new TextField();
    
    public TextField email3 = new TextField();
    public TextField firstname3 = new TextField();
    public TextField lastname3 = new TextField();
    public TextField StfxID3 = new TextField();
    public TextField password3 = new TextField();
    public TextField job3 = new TextField();
    public TextField majorStudy3 = new TextField();
    public TextField yearGraduated3 = new TextField();

    public static String query, query2, query3, uName, pWord;
    private Connection conn;
    private ResultSet rs,rs1,rs2;
    public String uuName= "";
    
    public Label lblStatus = new Label();
    public Label lblNewUser = new Label("New User? Register below!");
    public Label lblExistUser = new Label("Already a user? Login below!");
    public Label firstName = new Label("First Name");
    public Label lastName = new Label("Last Name");
    public Label major = new Label("Major (Ie: Mathematics, Computer Science, Statistics, etc.)");
    public Label gradYear = new Label("Graduated Year");
    public Label yourXID = new Label("Stfx ID");
    public Label lblID = new Label("Stfx ID");
    public Label jobTitle = new Label("Job Title");
    public Label emailAddress = new Label("Email");
    public Label lblPass = new Label("Password");
    public Label rlblPass = new Label("Password");
    public Label searchuser = new Label("Search for user");
    public Label searchuserName = new Label("Search for user");
    public Label edituser = new Label("Edit User");
    public Label upPassword = new Label("Password");
    public Label upPassword1 = new Label("Password");
    public Label adminLogin = new Label("Admin? Login below!");
    public Label recipients = new Label("Send Message To:");
    public Label body = new Label("Body:");

    public Label firstName2 = new Label("First Name");
    public Label lastName2 = new Label("Last Name");
    public Label major2 = new Label("Major (Ie: Mathematics, Computer Science, Statistics, etc.)");
    public Label gradYear2 = new Label("Graduated Year");
    public Label yourXID2 = new Label("Stfx ID");
    public Label jobTitle2 = new Label("Job Title");
    public Label emailAddress2 = new Label("Email");
    
    public Label firstName3 = new Label("First Name");
    public Label lastName3 = new Label("Last Name");
    public Label major3 = new Label("Major (Ie: Mathematics, Computer Science, Statistics, etc.)");
    public Label gradYear3 = new Label("Graduated Year");
    public Label yourXID3 = new Label("Stfx ID");
    public Label jobTitle3 = new Label("Job Title");
    public Label emailAddress3 = new Label("Email");

    @Override
    public void start(Stage primaryStage) {

        GridPane startScreen = new GridPane();
        GridPane loginScreen = new GridPane();
        GridPane registerScreen = new GridPane();
        GridPane userSearch = new GridPane();
        GridPane userEditAdmin = new GridPane();
        GridPane userResults = new GridPane();
        GridPane userEditUser = new GridPane();
        GridPane adminEdit = new GridPane();
        GridPane userProfile = new GridPane();
        GridPane adminEmail = new GridPane();

        startScreen.add(lblExistUser, 2, 1);
        startScreen.add(loginbtn, 2, 2);
        startScreen.add(lblNewUser, 2, 4);
        startScreen.add(registerbtn, 2, 5);
        
        registerScreen.add(firstName, 1, 1);
        registerScreen.add(lastName, 2, 1);
        registerScreen.add(firstname, 1, 2);
        registerScreen.add(lastname, 2, 2);
        registerScreen.add(major, 1, 4);
        registerScreen.add(majorStudy, 1, 5);
        registerScreen.add(gradYear, 2, 4);
        registerScreen.add(yearGraduated, 2, 5);
        registerScreen.add(yourXID, 3, 1);
        registerScreen.add(StfxID, 3, 2);
        registerScreen.add(emailAddress, 3, 4);
        registerScreen.add(email, 3, 5);
        registerScreen.add(jobTitle, 1, 7);
        registerScreen.add(job, 1, 8);
        registerScreen.add(rlblPass,2,7);
        registerScreen.add(regpassword,2,8);
        registerScreen.add(regUserbtn, 1, 9);
        registerScreen.add(back1, 2, 9);

        loginScreen.add(lblID, 3, 2);
        loginScreen.add(ID, 3, 3);
        loginScreen.add(lblPass, 3, 5);
        loginScreen.add(password, 3, 6);
        loginScreen.add(loginbtn2,3,8);
        loginScreen.add(back2,3,9);
        loginScreen.add(adminLogin, 3, 10);
        loginScreen.add(adminloginbtn, 3, 11);

        userSearch.add(searchuser, 2, 1);
        userSearch.add(userSearching, 2, 2);
        userSearch.add(search, 2, 3);
        userSearch.add(result, 2, 5, 3, 5);
        userSearch.add(yourProfile,3,1);
        userSearch.add(logOutUser,1,12);
       
        userEditAdmin.add(searchuserName, 2, 1);
        userEditAdmin.add(adminUserSearching, 2, 2);
        userEditAdmin.add(searchName, 2, 3);
        userEditAdmin.add(searchMajor, 3, 3);
        userEditAdmin.add(searchEmailMajor, 5, 3);
        userEditAdmin.add(result2, 2, 5, 3, 5);
        userEditAdmin.add(logOutUser,1,15);
        userEditAdmin.add(edits,4,3);
        
        
        adminEmail.add(recipients,2,1);
        adminEmail.add(result3, 2,5,3,5);
        adminEmail.add(body,2,11);
        adminEmail.add(result4, 2,12,3,5);
        adminEmail.add(sendEmail, 2,17);
        
        userProfile.add(editYrProfile,2,11);
        userProfile.add(msgs,2,5,3,5);
        userProfile.add(deleteMsgs,2,12);
        userProfile.add(back5,2,13);

        //        userEditAdmin.add();

        userEditUser.add(back3,3,9);
        userEditUser.add(saveEditsUser,3,8);
        userEditUser.add(firstName2, 1, 1);
        userEditUser.add(lastName2, 2, 1);
        userEditUser.add(firstname2, 1, 2);
        userEditUser.add(lastname2, 2, 2);
        userEditUser.add(major2, 1, 4);
        userEditUser.add(majorStudy2, 1, 5);
        userEditUser.add(gradYear2, 2, 4);
        userEditUser.add(yearGraduated2, 2, 5);
        userEditUser.add(yourXID2, 3, 1);
        userEditUser.add(StfxID2, 3, 2);
        userEditUser.add(emailAddress2, 3, 4);
        userEditUser.add(email2, 3, 5);
        userEditUser.add(jobTitle2, 1, 7);
        userEditUser.add(job2, 1, 8);
        userEditUser.add(upPassword,2,7);
        userEditUser.add(uppassword, 2, 8);
        userEditUser.add(result1, 1,11,3,5);
        
        adminEdit.add(back4,3,9);
        adminEdit.add(adminAdd,3,10);
        adminEdit.add(adminDelete,3,11);
        adminEdit.add(adminUpdate,3,8);
        adminEdit.add(firstName3, 1, 1);
        adminEdit.add(lastName3, 2, 1);
        adminEdit.add(firstname3, 1, 2);
        adminEdit.add(lastname3, 2, 2);
        adminEdit.add(major3, 1, 4);
        adminEdit.add(majorStudy3, 1, 5);
        adminEdit.add(gradYear3, 2, 4);
        adminEdit.add(yearGraduated3, 2, 5);
        adminEdit.add(yourXID3, 3, 1);
        adminEdit.add(StfxID3, 3, 2);
        adminEdit.add(emailAddress3, 3, 4);
        adminEdit.add(email3, 3, 5);
        adminEdit.add(jobTitle3, 1, 7);
        adminEdit.add(job3, 1, 8);
        adminEdit.add(upPassword1,2,7);
        adminEdit.add(uppassword1, 2, 8);
        adminEdit.add(result1, 1,15,3,5);

        Scene scene1 = new Scene(startScreen, 650, 500);
        Scene scene2 = new Scene(loginScreen, 650, 500);
        Scene scene3 = new Scene(registerScreen, 650, 500);
        Scene scene4 = new Scene(userSearch, 650, 500);
        Scene scene5 = new Scene(userEditUser,650,500);
        Scene scene6 = new Scene(userProfile,650,500);
        Scene scene7 = new Scene(userEditAdmin,650,500);
        Scene scene8 = new Scene(adminEdit,650,500);
        Scene scene9 = new Scene(adminEmail,650,500);
        primaryStage.setTitle("485 DB Project");
        primaryStage.setScene(scene1);
        primaryStage.show();
        edits.setOnAction(e -> primaryStage.setScene(scene8));
        editYrProfile.setOnAction(e -> primaryStage.setScene(scene5));
        loginbtn.setOnAction(e -> primaryStage.setScene(scene2));
        
        deleteMsgs.setOnAction(e -> {
            try{
                  
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "update Userlist set Msgs = '"+null+ "' where StfxID = '"+uuName+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);            
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        msgs.appendText("Update Unsuccesful");
                        }
                    else{
                        msgs.clear();
                        msgs.appendText("Update Successful");
                        query2 = "select * from Userlist where StfxID ='" + uuName + "'";
                        PreparedStatement stmt1 = conn.prepareStatement(query2);
                        rs1 = stmt1.executeQuery();
                        if(rs1.next()){
                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String email = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            msgs.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+email+"\n"
                                + "Messages: "+msg+"\n");
                }
            
            
            
            
            }}
                catch (Exception ex){
                    ex.printStackTrace();
                }
        
        });
        sendEmail.setOnAction(e -> {
                try{
                    String ta = result4.getText();
                    String[] emails = result3.getText().toString().split(",");
                    for(int i=0;i<emails.length;i++){
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "update Userlist set Msgs = '"+ta+ "' where Email = '"+emails[i]+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);            
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        result4.appendText("Update Unsuccesful");
                        }
                    else{
                        result4.clear();
                        result4.appendText("Update Successful");
                }
            
            
            
            
            }}
                catch (Exception ex){
                    ex.printStackTrace();
                }
        });
        
        adminloginbtn.setOnAction(e ->{
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String uName = ID.getText();
                    String pWord = password.getText();
                    query = "select * from Adminlist where adminID ='" + uName + "' and password= '" + pWord + "'";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    rs = stmt.executeQuery();
                    if (rs.next()){
                        System.out.println("Login Succesful");
                        primaryStage.setScene(scene7);

                    } 
                    else {
                        System.out.println("Login Unsuccesful");
                    }
                    query2 = "select * from Userlist where StfxID ='" + uName + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    if(rs1.next()){
                        int uid = (rs1.getInt("UserID")); 
                        int xid = (rs1.getInt("StfxID"));
                        String p =(rs1.getString("Password")); 
                        String fn =(rs1.getString("FirstName"));
                        String ln =(rs1.getString("LastName"));
                        String m =(rs1.getString("Major"));
                        String jt = (rs1.getString("JobTitle"));
                        int gy =(rs1.getInt("GradYear"));
                        String em = (rs1.getString("Email"));
                        String msg = (rs1.getString("Msgs"));
                        result2.appendText("User id:"+uid+"\n"
                            + "Stfx Id:"+xid+"\n"
                            + "Password:"+p+"\n"
                            + "First Name:"+fn+"\n"
                            + "Last Name"+ln+"\n"
                            + "Major:"+m+"\n"
                            + "JobTitle"+xid+"\n"
                            + "Graduation Year:"+gy+"\n"
                            + "Email:"+em+"\n"
                            + "Messages:"+msg+"\n");

                    }  }catch(Exception ex){
                    ex.printStackTrace();
                }

            });
        loginbtn2.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    uuName = ID.getText();
                    String pWord = password.getText();
                    query = "select * from Userlist where StfxID ='" + uuName + "' and Password= '" + pWord + "'";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    rs = stmt.executeQuery();
                    if (rs.next()){
                        System.out.println("Login Succesful");
                        primaryStage.setScene(scene4);

                    } 
                    else {
                        System.out.println("Login Unsuccesful");
                    }
                    query2 = "select * from Userlist where StfxID ='" + uName + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    if(rs1.next()){
                        int uid = (rs1.getInt("UserID")); 
                        int xid = (rs1.getInt("StfxID"));
                        String p =(rs1.getString("Password")); 
                        String fn =(rs1.getString("FirstName"));
                        String ln =(rs1.getString("LastName"));
                        String m =(rs1.getString("Major"));
                        String jt = (rs1.getString("JobTitle"));
                        int gy =(rs1.getInt("GradYear"));
                        String em = (rs1.getString("Email"));
                        String msg = (rs1.getString("Msgs"));
                        result.appendText("User id:"+uid+"\n"
                            + "Stfx Id:"+xid+"\n"
                            + "Password:"+p+"\n"
                            + "First Name:"+fn+"\n"
                            + "Last Name"+ln+"\n"
                            + "Major:"+m+"\n"
                            + "JobTitle"+xid+"\n"
                            + "Graduation Year:"+gy+"\n"
                            + "Email:"+em+"\n"
                            + "Messages:"+msg+"\n");

                    }  }catch(Exception ex){
                    ex.printStackTrace();
                }

            });
        regUserbtn.setOnAction(e-> {
                try{
                    String rfn = firstname.getText();
                    String rln = lastname.getText();
                    String rm = majorStudy.getText();
                    int ryg = Integer.parseInt(yearGraduated.getText());
                    int rxid = Integer.parseInt(StfxID.getText());
                    String rem = email.getText();
                    String rjt = job.getText();
                    String rp = regpassword.getText();

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "insert into Userlist (StfxID, Password, FirstName, LastName, Major, JobTitle, GradYear, Email) values(?,?,?,?,?,?,?,?)";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);
                    stmt2.setInt(1, rxid);
                    stmt2.setString(2,rp );
                    stmt2.setString(3, rfn);
                    stmt2.setString(4, rln);
                    stmt2.setString(5, rm);
                    stmt2.setString(6, rjt);
                    stmt2.setInt(7, ryg);
                    stmt2.setString(8, rem);             
                    boolean insert = stmt2.execute();
                    if(insert == false){
                        System.out.println("Registration Succesful");
                        primaryStage.setScene(scene4);
                        query2 = "select * from Userlist where StfxID ='" + rxid + "'";
                        PreparedStatement stmt1 = conn.prepareStatement(query2);
                        rs1 = stmt1.executeQuery();
                        if(rs1.next()){
                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String em = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n"
                                + "Messages: "+msg+"\n");
                        }}
                    else{
                        System.out.println("Registration Unsuccesful");
                    }

                } catch(Exception ex){
                    ex.printStackTrace();
                }
            });
        adminAdd.setOnAction(e-> {
                try{
                    String rfn = firstname3.getText();
                    String rln = lastname3.getText();
                    String rm = majorStudy3.getText();
                    int ryg = Integer.parseInt(yearGraduated3.getText());
                    int rxid = Integer.parseInt(StfxID3.getText());
                    String rem = email3.getText();
                    String rjt = job3.getText();
                    String rp = uppassword1.getText();

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "insert into Userlist (StfxID, Password, FirstName, LastName, Major, JobTitle, GradYear, Email) values(?,?,?,?,?,?,?,?)";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);
                    stmt2.setInt(1, rxid);
                    stmt2.setString(2,rp );
                    stmt2.setString(3, rfn);
                    stmt2.setString(4, rln);
                    stmt2.setString(5, rm);
                    stmt2.setString(6, rjt);
                    stmt2.setInt(7, ryg);
                    stmt2.setString(8, rem);             
                    boolean insert = stmt2.execute();
                    if(insert == false){
                        result1.clear();
                        result1.appendText("Registration Succesful"); 
                        query2 = "select * from Userlist where StfxID ='" + rxid + "'";
                        PreparedStatement stmt1 = conn.prepareStatement(query2);
                        rs1 = stmt1.executeQuery();
                        if(rs1.next()){
                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String em = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result1.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n"
                                + "Messages: "+msg+"\n");
                        }}
                    else{
                        result1.clear();
                        result1.appendText("Registration Unsuccesful");
                    }

                } catch(Exception ex){
                    ex.printStackTrace();
                }
            });
        search.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = userSearching.getText();
                    query2 = "select * from Userlist where FirstName ='" + username + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    
                    if (!rs1.next())
                    {                            
                        result2.clear();
                        result2.appendText("No records found");
                    }
                    else {
                        do {

                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String em = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result.appendText("User id:"+uid+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n");
                                
                        } while (rs1.next());
                    }
                    
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
         back2.setOnAction(e -> primaryStage.setScene(scene1));
        registerbtn.setOnAction(e -> primaryStage.setScene(scene3));
        back1.setOnAction(e -> primaryStage.setScene(scene1));
        back4.setOnAction(e -> primaryStage.setScene(scene4));
        yourProfile.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    
                    query2 = "select Msgs from Userlist where StfxId ='" + uuName + "'";
                   
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    primaryStage.setScene(scene6);
                    msgs.clear();
                    
                    if (!rs1.next())
                    {   
                        msgs.clear();
                        msgs.appendText("No records found");
                    }
                    else {
                        do {
                             
                            String em = (rs1.getString("Msgs"));
                            msgs.appendText(
                                 
                                ""+em+",");
                                
                        } while (rs1.next());
                    }
                    
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        
        
        searchName.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = adminUserSearching.getText();
                    query2 = "select * from Userlist where FirstName ='" + username + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    result.clear();
                    if (!rs1.next())
                    {                            
                        result.clear();
                        result.appendText("No records found");
                    }
                    else {
                        do {

                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String em = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result2.appendText("User id:"+uid+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n");
                                
                        } while (rs1.next());
                    }
                    
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        searchMajor.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = adminUserSearching.getText();
                    query2 = "select * from Userlist where Major ='" + username + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    result.clear();
                    if (!rs1.next())
                    {   
                        result2.clear();
                        result2.appendText("No records found");
                    }
                    else {
                        do {

                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String em = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result2.appendText("User id:"+uid+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n");
                                
                        } while (rs1.next());
                    }
                    
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        searchEmailMajor.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = adminUserSearching.getText();
                    query2 = "select Email from Userlist where Major ='" + username + "'";
                   
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    primaryStage.setScene(scene9);
                    result3.clear();
                    
                    if (!rs1.next())
                    {   
                        result3.clear();
                        result3.appendText("No records found");
                    }
                    else {
                        do {
                             
                            String em = (rs1.getString("Email"));
                            result3.appendText(
                                 
                                ""+em+",");
                                
                        } while (rs1.next());
                    }
                    
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        saveEditsUser.setOnAction(e -> {
            try{
            String efn = firstname2.getText();
                    String eln = lastname2.getText();
                    String em = majorStudy2.getText();
                    int eyg = Integer.parseInt(yearGraduated2.getText());
                    int exid = Integer.parseInt(StfxID2.getText());
                    String eem = email2.getText();
                    String ejt = job2.getText();
                    String erp = uppassword.getText();

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "update Userlist set StfxID = '"+exid+ "', Password='"+erp+ "', FirstName='"+efn+ "', LastName='"+eln+ "', Major='"+eem+ "', JobTitle='"+ejt+ "', GradYear='"+eyg+ "', Email='"+eem+ "' where StfxID = '"+exid+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);            
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        System.out.println("Update Unsuccesful");
                        }
                    else{
                       System.out.println("Update Succesful");
                        primaryStage.setScene(scene5);
                        query2 = "select * from Userlist where StfxID ='" + exid + "'";
                        PreparedStatement stmt1 = conn.prepareStatement(query2);
                        rs1 = stmt1.executeQuery();
                        if(rs1.next()){
                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String email = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result1.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+email+"\n"
                                + "Messages: "+msg+"\n");
                    }

                } }catch(Exception ex){
                    ex.printStackTrace();
                }
            
            primaryStage.setScene(scene5);
        
        });
        adminUpdate.setOnAction(e -> {
            try{
            String efn = firstname3.getText();
                    String eln = lastname3.getText();
                    String em = majorStudy3.getText();
                    int eyg = Integer.parseInt(yearGraduated3.getText());
                    int exid = Integer.parseInt(StfxID3.getText());
                    String eem = email3.getText();
                    String ejt = job3.getText();
                    String erp = uppassword1.getText();

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "update Userlist set StfxID = '"+exid+ "', Password='"+erp+ "', FirstName='"+efn+ "', LastName='"+eln+ "', Major='"+eem+ "', JobTitle='"+ejt+ "', GradYear='"+eyg+ "', Email='"+eem+ "' where StfxID = '"+exid+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);            
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        result1.clear();
                        result1.appendText("Update Unsuccesful");
                        }
                    else{
                        result1.clear();
                        result1.appendText("Update Succesful");
                        
                        query2 = "select * from Userlist where StfxID ='" + exid + "'";
                        PreparedStatement stmt1 = conn.prepareStatement(query2);
                        rs1 = stmt1.executeQuery();
                        if(rs1.next()){
                            int uid = (rs1.getInt("UserID")); 
                            int xid = (rs1.getInt("StfxID"));
                            String p =(rs1.getString("Password")); 
                            String fn =(rs1.getString("FirstName"));
                            String ln =(rs1.getString("LastName"));
                            String m =(rs1.getString("Major"));
                            String jt = (rs1.getString("JobTitle"));
                            int gy =(rs1.getInt("GradYear"));
                            String email = (rs1.getString("Email"));
                            String msg = (rs1.getString("Msgs"));
                            result1.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+xid+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+email+"\n"
                                + "Messages: "+msg+"\n");
                    }

                } }catch(Exception ex){
                    ex.printStackTrace();
                }
            
            primaryStage.setScene(scene8);
       
        });
        adminDelete.setOnAction(e -> {
            try{
                    int exid = Integer.parseInt(StfxID3.getText());
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "delete from Userlist where StfxID = '"+exid+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);            
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        result1.clear();
                        result1.appendText("Update Unsuccesful");
                        }
                    else{
                        result1.clear();
                        result1.appendText("Update Succesful");
                       
                    }

                } catch(Exception ex){
                    ex.printStackTrace();
                }
            
            primaryStage.setScene(scene8);
       
        });
        back3.setOnAction(e -> primaryStage.setScene(scene6));
        back5.setOnAction(e -> primaryStage.setScene(scene7));
        logOutUser.setOnAction(e -> primaryStage.close());

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
