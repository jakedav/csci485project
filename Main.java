
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
    public Button editUser = new Button("Edit User");
    public Button regUserbtn = new Button("Register");
    public Button back1 = new Button("Back");
    public Button backbtn2 = new Button("Back");
    public Button back3 = new Button("Back");
    public Button back4 = new Button("Back");
    public Button yourProfile = new Button("Profile");
    public Button editYrProfile = new Button("Edit Profile");
    public Button saveEditsUser = new Button("Save Changes");
    public Button logOutUser = new Button("Logout");

    public TextField email = new TextField();
    public TextField firstname = new TextField();
    public TextField lastname = new TextField();
    public TextField address = new TextField();
    public TextField ID = new TextField();
    public TextField StfxID = new TextField();
    public TextField password = new TextField();
    public TextField regpassword = new TextField();
    public TextField job = new TextField();
    public TextField majorStudy = new TextField();
    public TextField yearGraduated = new TextField();
    public TextField userSearching = new TextField();
    public TextArea result = new TextArea();

    public TextField email2 = new TextField();
    public TextField firstname2 = new TextField();
    public TextField lastname2 = new TextField();
    public TextField StfxID2 = new TextField();
    public TextField password2 = new TextField();
    public TextField job2 = new TextField();
    public TextField majorStudy2 = new TextField();
    public TextField yearGraduated2 = new TextField();

    public static String query, query2, query3;
    private Connection conn;
    private ResultSet rs,rs1,rs2;

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
    public Label edituser = new Label("Edit User");

    public Label firstName2 = new Label("First Name");
    public Label lastName2 = new Label("Last Name");
    public Label major2 = new Label("Major (Ie: Mathematics, Computer Science, Statistics, etc.)");
    public Label gradYear2 = new Label("Graduated Year");
    public Label yourXID2 = new Label("Stfx ID");
    public Label jobTitle2 = new Label("Job Title");
    public Label emailAddress2 = new Label("Email");

    @Override
    public void start(Stage primaryStage) {

        GridPane startScreen = new GridPane();
        GridPane loginScreen = new GridPane();
        GridPane registerScreen = new GridPane();
        GridPane userSearch = new GridPane();
        //GridPane userEditAdmin = new GridPane();
        //GridPane userResults = new GridPane();
        //GridPane userEditUser = new GridPane();
        //GridPane userProfile = new GridPane();

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
        loginScreen.add(backbtn2,3,9);

        userSearch.add(searchuser, 2, 1);
        userSearch.add(userSearching, 2, 2);
        userSearch.add(search, 2, 3);
        userSearch.add(result, 2, 5, 3, 5);
        userSearch.add(yourProfile,3,1);
        userSearch.add(logOutUser,1,12);
        /*
        userProfile.add(editYrProfile,3,8);
        userProfile.add(back4,3,9);

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
        userEditUser.add(job2, 1, 8);*/

        Scene scene1 = new Scene(startScreen, 650, 500);
        Scene scene2 = new Scene(loginScreen, 650, 500);
        Scene scene3 = new Scene(registerScreen, 650, 500);
        Scene scene4 = new Scene(userSearch, 650, 500);
        //Scene scene5 = new Scene(userEditUser,650,500);
        //Scene scene6 = new Scene(userProfile,650,500);

        primaryStage.setTitle("485 DB Project");
        primaryStage.setScene(scene1);
        primaryStage.show();

        loginbtn.setOnAction(e -> primaryStage.setScene(scene2));
        loginbtn2.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String uName = ID.getText();
                    String pWord = password.getText();
                    query = "select * from Userlist where StfxID ='" + uName + "' and Password= '" + pWord + "'";
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
                                + "Stfx Id:"+xid+"\n"
                                + "Password:"+p+"\n"
                                + "First Name:"+fn+"\n"
                                + "Last Name"+ln+"\n"
                                + "Major:"+m+"\n"
                                + "JobTitle"+xid+"\n"
                                + "Graduation Year:"+gy+"\n"
                                + "Email:"+em+"\n"
                                + "Messages:"+msg+"\n");
                        }}
                    else{
                        System.out.println("Registration Unsuccesful");
                    }

                } catch(Exception ex){
                    ex.printStackTrace();
                }
            });
        search.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String uName = userSearching.getText();
                    query2 = "select * from Userlist where FirstName ='" + uName + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    result.clear();
                    if (!rs1.next())
                    {                            

                        System.out.println("No records found");
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
                                + "Stfx Id:"+xid+"\n"
                                + "Password:"+p+"\n"
                                + "First Name:"+fn+"\n"
                                + "Last Name"+ln+"\n"
                                + "Major:"+m+"\n"
                                + "JobTitle"+xid+"\n"
                                + "Graduation Year:"+gy+"\n"
                                + "Email:"+em+"\n"
                                + "Messages:"+msg+"\n");// Get data from the current row and use it
                        } while (rs1.next());
                    }
                    if(rs1.next()){
                        result.clear();
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
                    } 
                    else{
                        System.out.print("No matching record, try again:");
                    }

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        // back2.setOnAction(e -> primaryStage.setScene(scene1));
        registerbtn.setOnAction(e -> primaryStage.setScene(scene3));
        //back1.setOnAction(e -> primaryStage.setScene(scene1));
        //yourProfile.setOnAction(e -> primaryStage.setScene(scene6));
        //back4.setOnAction(e -> primaryStage.setScene(scene4));
        //editYrProfile.setOnAction(e -> primaryStage.setScene(scene5));
        //back3.setOnAction(e -> primaryStage.setScene(scene6));
        //logOutUser.setOnAction(e -> primaryStage.close());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
