
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.sql.*;

public class Main extends Application {
    //our statement variable used in our functions to run sql statements in our gui
    public Statement sqlstatement;

    //images for gui
    public File file = new File("/Users/jacobdavis/Downloads/student.jpg");
    public Image image = new Image(file.toURI().toString(),100,150,false,false);
    public ImageView searchUserPicture = new ImageView(image);

    //our extra buttons for our database sql functions, if needed for admin purposes.
    public Button view = new Button("View");
    public Button insert = new Button("Insert");
    public Button update = new Button("Update");
    public Button clear = new Button("Clear");
    public Button clearSQLResult = new Button("Clear Result");
    public Button connect = new Button("Connect DB");

    //our list of user/admin buttons for the user/admin interface
    public Button generalloginButton = new Button("Login");
    public Button userloginButton = new Button("Login");
    public Button registerButton = new Button("Register");
    public Button search = new Button("Search");
    public Button searchByName = new Button("Search Name");
    public Button searchByMajor = new Button("Search Major");
    public Button searchByEmailandMajor = new Button("Search Emails by Major");
    public Button registerUserButton = new Button("Register");
    //back buttons used to go between different windows
    public Button goBackToStartScreenFromRegister = new Button("Back");
    public Button goBackToStartScreenFromLogin = new Button("Back");
    public Button userGoBackToUserProfileFromUserEdit = new Button("Back");
    public Button adminGoBackToUserSearchFromAdminEdit = new Button("Back");
    public Button userGoBackToUserSearchFromUserEdit = new Button("Back");
    public Button adminGoBackToUserSearchFromEmail = new Button("Back");

    //buttons for user/admin profile edits
    public Button yourProfile = new Button("Profile");
    public Button editYrProfile = new Button("Edit Profile");
    public Button saveEditsUser = new Button("Save Changes");
    public Button logOutUser = new Button("Logout");
    public Button logOutAdmin = new Button("Logout");
    public Button adminloginbtn = new Button("Login");
    public Button edits = new Button("Update/Add/Delete Entry");
    public Button adminAdd = new Button("Add Entry");
    public Button adminDelete= new Button("Delete Entry");
    public Button adminUpdate= new Button("Update Entry");
    public Button sendEmail = new Button("Send Email");
    public Button deleteMsgs = new Button("Delete Emails");
    public Button emailStudents = new Button("Email Users");

    //user register text fields
    public TextField email = new TextField();
    public TextField firstname = new TextField();
    public TextField lastname = new TextField();
    public TextField ID = new TextField();
    public TextField StfxID = new TextField();
    public PasswordField password = new PasswordField();
    public TextField regpassword = new TextField();
    public TextField uppassword = new TextField();
    public TextField job = new TextField();
    public TextField majorStudy = new TextField();
    public TextField yearGraduated = new TextField();
    //user search text field
    public TextField userSearching = new TextField();
    //admin user search and user edit fields
    public TextField adminUppassword = new TextField();
    public TextField adminUserSearching = new TextField();
    //textareas for results from user searching, to email body
    public TextArea userSearchUserResult = new TextArea();
    public TextArea userProfileUpdateResult = new TextArea();
    public TextArea adminSearchUserResult = new TextArea();
    public TextArea adminCreateUserEmail = new TextArea();
    public TextArea adminCreateUserEmailBody = new TextArea();
    public TextArea msgs = new TextArea();

    //user profile edit text fields
    public TextField userEditEmailTF = new TextField();
    public TextField userEditFirstTF = new TextField();
    public TextField userEditLastTF = new TextField();
    public TextField userEditXIDTF = new TextField();
    public TextField userEditJobTF = new TextField();
    public TextField userEditMajorTF = new TextField();
    public TextField userEditGradYrTF = new TextField();

    //admin user profile edit
    public TextField adminEditUserEmailTF = new TextField();
    public TextField adminEditUserFirstTF = new TextField();
    public TextField adminEditUserLastTF = new TextField();
    public TextField adminEditUserXIDTF = new TextField();
    public TextField adminEditUserJobTF = new TextField();
    public TextField adminEditUserMajorTF = new TextField();
    public TextField adminEditUserGradYrTF = new TextField();

    public static String query, query2, query3, uName, pWord;
    private Connection conn;
    private ResultSet rs,rs1,rs2;
    public String uuName= "";

    //labels for the GUI
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
    public Label searchuser = new Label("Search for fellow grads here");
    public Label searchuserName = new Label("Search for user");
    public Label upPassword = new Label("Password");
    public Label upPassword1 = new Label("Password");
    public Label adminLogin = new Label("Admin? Login below!");
    public Label recipients = new Label("Send Message To:");
    public Label body = new Label("Body:");
    //more labels for user edit
    public Label userEditFirstName = new Label("First Name");
    public Label userEditLastName = new Label("Last Name");
    public Label userEditMajor = new Label("Major (Ie: Mathematics, Computer Science, Statistics, etc.)");
    public Label userEditGradYr = new Label("Graduated Year");
    public Label userEditXID = new Label("Stfx ID");
    public Label userEditJob = new Label("Job Title");
    public Label userEditEmail = new Label("Email");
    //labels for admin user edit
    public Label adminEditUserFirst = new Label("First Name");
    public Label adminEditUserLast = new Label("Last Name");
    public Label adminEditUserMajor = new Label("Major (Ie: Mathematics, Computer Science, Statistics, etc.)");
    public Label adminEditUserGradYr = new Label("Graduated Year");
    public Label adminEditUserXID = new Label("Stfx ID");
    public Label adminEditUserJob = new Label("Job Title");
    public Label adminEditUserEmail = new Label("Email");

    @Override
    public void start(Stage primaryStage) {
        //main gridpane configuration for GUI windows
        GridPane startScreen = new GridPane();
        GridPane loginScreen = new GridPane();
        GridPane registerScreen = new GridPane();
        GridPane userSearch = new GridPane();
        GridPane userEditAdmin = new GridPane();
        GridPane userEditUser = new GridPane();
        GridPane adminEdit = new GridPane();
        GridPane userProfile = new GridPane();
        GridPane adminEmail = new GridPane();

        //gridlines to test GUI layout
        startScreen.setGridLinesVisible(false);
        loginScreen.setGridLinesVisible(false);
        registerScreen.setGridLinesVisible(false);
        userSearch.setGridLinesVisible(false);
        userEditAdmin.setGridLinesVisible(false);
        userEditUser.setGridLinesVisible(false);
        adminEdit.setGridLinesVisible(false);
        userProfile.setGridLinesVisible(false);
        adminEmail.setGridLinesVisible(false);
        //making GUI panes the color white
        startScreen.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        loginScreen.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        registerScreen.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        userSearch.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        userEditAdmin.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        userEditUser.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        adminEdit.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        userProfile.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        adminEmail.setStyle("-fx-background-color:#ffffff; -fx-opacity:1;");
        //startup screen objects added
        startScreen.setAlignment(Pos.CENTER);
        startScreen.setHgap(5);
        startScreen.setVgap(5);
        startScreen.add(lblExistUser, 5,0);
        startScreen.add(generalloginButton,5 ,1);
        startScreen.add(lblNewUser, 5, 6);
        startScreen.add(registerButton, 5, 7);
        //register screen objects added
        registerScreen.setAlignment(Pos.CENTER);
        registerScreen.setHgap(2);
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
        registerScreen.add(registerUserButton, 1, 9);
        registerScreen.add(goBackToStartScreenFromRegister, 2, 9);
        //login screen objects added
        loginScreen.setAlignment(Pos.CENTER);
        loginScreen.setVgap(5);
        loginScreen.add(lblID, 3, 2);
        loginScreen.add(ID, 3, 3);
        loginScreen.add(lblPass, 3, 5);
        loginScreen.add(password, 3, 6);
        loginScreen.add(userloginButton,3,8);
        loginScreen.add(goBackToStartScreenFromLogin,3,13);
        loginScreen.add(adminLogin, 3, 9);
        loginScreen.add(adminloginbtn, 3, 10);
        //user searching users objects added
        userSearch.setAlignment(Pos.CENTER);
        userSearch.setVgap(5);
        userSearch.setHgap(2);
        userSearch.add(searchuser, 2, 2);
        userSearch.add(userSearching, 2, 1);
        userSearch.add(search, 3, 1);
        userSearch.add(userSearchUserResult, 2, 4, 3, 5);
        userSearch.add(yourProfile,5,1);
        userSearch.add(logOutUser,5,3);
        userSearch.add(searchUserPicture,2,3);
        userSearchUserResult.setEditable(false);
        //admin editing users objects added
        userEditAdmin.setAlignment(Pos.CENTER);
        userEditAdmin.setVgap(2);
        userEditAdmin.setHgap(2);
        userEditAdmin.add(searchuserName, 2, 1);
        userEditAdmin.add(adminUserSearching, 2, 2);
        userEditAdmin.add(searchByName, 2, 3);
        userEditAdmin.add(searchByMajor, 3, 3);
        userEditAdmin.add(searchByEmailandMajor, 4, 3);
        userEditAdmin.add(adminSearchUserResult, 2, 6, 3, 5);
        userEditAdmin.add(logOutAdmin,5,1);
        userEditAdmin.add(edits,5,3);
        //userEditAdmin.add(emailStudents,5,2);
        //admin user email section objects added
        adminEmail.setAlignment(Pos.CENTER);
        adminEmail.setHgap(2);
        adminEmail.setVgap(2);
        adminEmail.add(recipients,2,1);
        adminEmail.add(adminCreateUserEmail, 2,5,3,5);
        adminEmail.add(body,2,11);
        adminEmail.add(adminCreateUserEmailBody, 2,12,3,5);
        adminEmail.add(sendEmail, 2,17);
        adminEmail.add(adminGoBackToUserSearchFromEmail,5,17);
        //users profile objects added
        userProfile.setAlignment(Pos.CENTER);
        userProfile.add(editYrProfile,2,11);
        userProfile.add(msgs,2,5,3,5);
        userProfile.add(deleteMsgs,2,12);
        userProfile.add(userGoBackToUserSearchFromUserEdit,2,13);
        //user editing their profile objects added
        userEditUser.setAlignment(Pos.CENTER);
        userEditUser.add(userGoBackToUserProfileFromUserEdit,3,9);
        userEditUser.add(saveEditsUser,3,8);
        userEditUser.add(userEditFirstName, 1, 1);
        userEditUser.add(userEditLastName, 2, 1);
        userEditUser.add(userEditFirstTF, 1, 2);
        userEditUser.add(userEditLastTF, 2, 2);
        userEditUser.add(userEditMajor, 1, 4);
        userEditUser.add(userEditMajorTF, 1, 5);
        userEditUser.add(userEditGradYr, 2, 4);
        userEditUser.add(userEditGradYrTF, 2, 5);
        userEditUser.add(userEditXID, 3, 1);
        userEditUser.add(userEditXIDTF, 3, 2);
        userEditUser.add(userEditEmail, 3, 4);
        userEditUser.add(userEditEmailTF, 3, 5);
        userEditUser.add(userEditJob, 1, 7);
        userEditUser.add(userEditJobTF, 1, 8);
        userEditUser.add(upPassword,2,7);
        userEditUser.add(uppassword, 2, 8);
        userEditUser.add(userProfileUpdateResult, 1,11,3,5);
        //admin editing users to delete or add objects added
        adminEdit.setHgap(2);
        adminEdit.setVgap(2);
        adminEdit.setAlignment(Pos.CENTER);
        adminEdit.add(adminGoBackToUserSearchFromAdminEdit,3,11);
        adminEdit.add(adminAdd,1,9);
        adminEdit.add(adminDelete,2,11);
        adminEdit.add(adminUpdate,1,11);
        adminEdit.add(adminEditUserFirst, 1, 1);
        adminEdit.add(adminEditUserLast, 2, 1);
        adminEdit.add(adminEditUserFirstTF, 1, 2);
        adminEdit.add(adminEditUserLastTF, 2, 2);
        adminEdit.add(adminEditUserMajor, 1, 4);
        adminEdit.add(adminEditUserMajorTF, 1, 5);
        adminEdit.add(adminEditUserGradYr, 2, 4);
        adminEdit.add(adminEditUserGradYrTF, 2, 5);
        adminEdit.add(adminEditUserXID, 3, 1);
        adminEdit.add(adminEditUserXIDTF, 3, 2);
        adminEdit.add(adminEditUserEmail, 3, 4);
        adminEdit.add(adminEditUserEmailTF, 3, 5);
        adminEdit.add(adminEditUserJob, 1, 7);
        adminEdit.add(adminEditUserJobTF, 1, 8);
        adminEdit.add(upPassword1,2,7);
        adminEdit.add(adminUppassword, 2, 8);
        adminEdit.add(userProfileUpdateResult, 1,15,3,5);
        userProfileUpdateResult.setEditable(false);
        //scene creation for the panes above into their own scene to open when GUI is run
        Scene scene1 = new Scene(startScreen, 650, 450);
        Scene scene2 = new Scene(loginScreen, 650, 450);
        Scene scene3 = new Scene(registerScreen, 650, 450);
        Scene scene4 = new Scene(userSearch, 650, 450);
        Scene scene5 = new Scene(userEditUser,650,450);
        Scene scene6 = new Scene(userProfile,650,450);
        Scene scene7 = new Scene(userEditAdmin,650,450);
        Scene scene8 = new Scene(adminEdit,650,450);
        Scene scene9 = new Scene(adminEmail,650,450);
        primaryStage.setTitle("485 DB Project");
        primaryStage.setScene(scene1);
        primaryStage.show();
        edits.setOnAction(e -> primaryStage.setScene(scene8));
        editYrProfile.setOnAction(e -> primaryStage.setScene(scene5));
        generalloginButton.setOnAction(e -> primaryStage.setScene(scene2));
        emailStudents.setOnAction(e -> primaryStage.setScene(scene9));

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
                        msgs.appendText("Update Successful"+"\n");
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
                                + "JobTitle: "+jt+"\n"
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
                    String ta = adminCreateUserEmailBody.getText();
                    String[] emails = adminCreateUserEmail.getText().toString().split(",");
                    for(int i=0;i<emails.length;i++){
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                        query3 = "update Userlist set Msgs = '"+ta+ "' where Email = '"+emails[i]+ "'";
                        PreparedStatement stmt2 = conn.prepareStatement(query3);
                        int insert = stmt2.executeUpdate();
                        if(insert == 0){
                            adminCreateUserEmailBody.appendText("Update Unsuccesful");
                        }
                        else{
                            adminCreateUserEmailBody.clear();
                            adminCreateUserEmailBody.appendText("Update Successful");
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
                        adminSearchUserResult.appendText("User id:"+uid+"\n"
                            + "Stfx Id:"+xid+"\n"
                            + "Password:"+p+"\n"
                            + "First Name:"+fn+"\n"
                            + "Last Name"+ln+"\n"
                            + "Major:"+m+"\n"
                            + "JobTitle"+jt+"\n"
                            + "Graduation Year:"+gy+"\n"
                            + "Email:"+em+"\n"
                            + "Messages:"+msg+"\n");

                    }  }catch(Exception ex){
                    ex.printStackTrace();
                }

            });
        userloginButton.setOnAction(e -> {
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
                        String em = (rs1.getString("Email"));
                        String msg = (rs1.getString("Msgs"));
                        userSearchUserResult.appendText("User id:"+uid+"\n"
                            + "Stfx Id:"+xid+"\n"
                            + "Password:"+p+"\n"
                            + "First Name:"+fn+"\n"
                            + "Last Name"+ln+"\n"
                            + "Major:"+m+"\n"
                            + "JobTitle"+jt+"\n"
                            + "Graduation Year:"+gy+"\n"
                            + "Email:"+em+"\n"
                            + "Messages:"+msg+"\n");

                    }  }catch(Exception ex){
                    ex.printStackTrace();
                }

            });
        registerUserButton.setOnAction(e-> {
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
                            userSearchUserResult.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
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
                    String rfn = adminEditUserFirstTF.getText();
                    String rln = adminEditUserLastTF.getText();
                    String rm = adminEditUserMajorTF.getText();
                    int ryg = Integer.parseInt(adminEditUserGradYrTF.getText());
                    int rxid = Integer.parseInt(adminEditUserXIDTF.getText());
                    String rem = adminEditUserEmailTF.getText();
                    String rjt = adminEditUserJobTF.getText();
                    String rp = adminUppassword.getText();

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
                        userProfileUpdateResult.clear();
                        userProfileUpdateResult.appendText("Registration Succesful");
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
                            userProfileUpdateResult.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n"
                                + "Messages: "+msg+"\n");
                        }}
                    else{
                        userProfileUpdateResult.clear();
                        userProfileUpdateResult.appendText("Registration Unsuccesful");
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
                        userSearchUserResult.clear();
                        userSearchUserResult.appendText("No records found");
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
                            userSearchUserResult.appendText("User id:"+uid+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n");

                        } while (rs1.next());
                    }

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        goBackToStartScreenFromLogin.setOnAction(e -> primaryStage.setScene(scene1));
        registerButton.setOnAction(e -> primaryStage.setScene(scene3));
        goBackToStartScreenFromRegister.setOnAction(e -> primaryStage.setScene(scene1));
        adminGoBackToUserSearchFromAdminEdit.setOnAction(e -> primaryStage.setScene(scene4));

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

        searchByName.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = adminUserSearching.getText();
                    query2 = "select * from Userlist where FirstName ='" + username + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    adminSearchUserResult.clear();
                    if (!rs1.next())
                    {
                        adminSearchUserResult.clear();
                        adminSearchUserResult.appendText("No records found");
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
                            adminSearchUserResult.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n"
                                + "Messages: "+msg+"\n");

                        } while (rs1.next());
                    }

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        searchByMajor.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = adminUserSearching.getText();
                    query2 = "select * from Userlist where Major ='" + username + "'";
                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    
                    if (!rs1.next())
                    {
                        adminSearchUserResult.clear();
                        adminSearchUserResult.appendText("No records found");
                    }
                    else {
                        do {
                            adminSearchUserResult.clear();
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
                            adminSearchUserResult.appendText("User id:"+uid+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
                                + "Graduation Year: "+gy+"\n"
                                + "Email: "+em+"\n");

                        } while (rs1.next());
                    }

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        searchByEmailandMajor.setOnAction(e -> {
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    String username = adminUserSearching.getText();
                    query2 = "select Email from Userlist where Major ='" + username + "'";

                    PreparedStatement stmt1 = conn.prepareStatement(query2);
                    rs1 = stmt1.executeQuery();
                    primaryStage.setScene(scene9);
                    adminCreateUserEmail.clear();

                    if (!rs1.next())
                    {
                        adminCreateUserEmail.clear();
                        adminCreateUserEmail.appendText("No records found");
                    }
                    else {
                        do {

                            String em = (rs1.getString("Email"));
                            adminCreateUserEmail.appendText(

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
                    String efn = userEditFirstTF.getText();
                    String eln = userEditLastTF.getText();
                    String em = userEditMajorTF.getText();
                    int eyg = Integer.parseInt(userEditGradYrTF.getText());
                    int exid = Integer.parseInt(userEditXIDTF.getText());
                    String eem = userEditEmailTF.getText();
                    String ejt = userEditJobTF.getText();
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
                            userProfileUpdateResult.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
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
                    String efn = adminEditUserFirstTF.getText();
                    String eln = adminEditUserLastTF.getText();
                    String em = adminEditUserMajorTF.getText();
                    int eyg = Integer.parseInt(adminEditUserGradYrTF.getText());
                    int exid = Integer.parseInt(adminEditUserXIDTF.getText());
                    String eem = adminEditUserEmailTF.getText();
                    String ejt = adminEditUserJobTF.getText();
                    String erp = adminUppassword.getText();

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "update Userlist set StfxID = '"+exid+ "', Password='"+erp+ "', FirstName='"+efn+ "', LastName='"+eln+ "', Major='"+eem+ "', JobTitle='"+ejt+ "', GradYear='"+eyg+ "', Email='"+eem+ "' where StfxID = '"+exid+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        userProfileUpdateResult.clear();
                        userProfileUpdateResult.appendText("Update Unsuccesful");
                    }
                    else{
                        userProfileUpdateResult.clear();
                        userProfileUpdateResult.appendText("Update Succesful");

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
                            userProfileUpdateResult.appendText("User id:"+uid+"\n"
                                + "Stfx Id: "+xid+"\n"
                                + "Password: "+p+"\n"
                                + "First Name: "+fn+"\n"
                                + "Last Name: "+ln+"\n"
                                + "Major: "+m+"\n"
                                + "JobTitle: "+jt+"\n"
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
                    int exid = Integer.parseInt(adminEditUserXIDTF.getText());
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate?autoReconnect=true&useSSL=false","root","jacobdavis");
                    query3 = "delete from Userlist where StfxID = '"+exid+ "'";
                    PreparedStatement stmt2 = conn.prepareStatement(query3);
                    int insert = stmt2.executeUpdate();
                    if(insert == 0){
                        userProfileUpdateResult.clear();
                        userProfileUpdateResult.appendText("Update Unsuccesful");
                    }
                    else{
                        userProfileUpdateResult.clear();
                        userProfileUpdateResult.appendText("Update Succesful");

                    }

                } catch(Exception ex){
                    ex.printStackTrace();
                }

                primaryStage.setScene(scene8);

            });
        userGoBackToUserProfileFromUserEdit.setOnAction(e -> primaryStage.setScene(scene6));
        userGoBackToUserSearchFromUserEdit.setOnAction(e -> primaryStage.setScene(scene4));
        adminGoBackToUserSearchFromAdminEdit.setOnAction(e-> primaryStage.setScene(scene7));
        adminGoBackToUserSearchFromEmail.setOnAction(e -> primaryStage.setScene(scene7));
        logOutUser.setOnAction(e -> primaryStage.close());
        logOutAdmin.setOnAction(e -> primaryStage.close());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
